package com.springmvc.repo.impl;

import java.util.Date;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.pojo.CartI;
import com.springmvc.pojo.OrderDetail;
import com.springmvc.pojo.Product;
import com.springmvc.pojo.SaleOrder;
import com.springmvc.repo.OrderRepo;
import com.springmvc.repo.ProductRepo;
import com.springmvc.repo.UserRepo;
import com.springmvc.utils.Utils1;

@Repository
public class OrderRepoImpl implements OrderRepo {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private LocalSessionFactoryBean ses;

	@Autowired
	private ProductRepo productRepo;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	// luu nhieu bang va co moi quan he cha con
	public boolean addReceipt(Map<Integer, CartI> cartMap) {
		// TODO Auto-generated method stub
		try {
			Session session = ses.getObject().getCurrentSession();

			SaleOrder order = new SaleOrder();
			order.setUser(userRepo.getUserById(1));
			order.setCreatedDate(new Date());
			Map<String, String> stats = Utils1.cartStats(cartMap);
			order.setAmount(Long.parseLong(stats.get("amount")));

			session.save(order);

			for (CartI carti : cartMap.values()) {
				OrderDetail orderdi = new OrderDetail();
				orderdi.setSaleOrder(order);
				Product productCur = productRepo.getProductById(carti.getProductId());
				orderdi.setProduct(productCur);
				orderdi.setUnitprice(carti.getPrice());
				orderdi.setNum(carti.getQuanlity());
				session.save(orderdi);

			}
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

}
