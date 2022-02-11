package com.springmvc.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.pojo.CartI;
import com.springmvc.repo.OrderRepo;
import com.springmvc.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepo orderDetailRepo;

	@Override
	public boolean addReceipt(Map<Integer, CartI> cartMap) {
		// TODO Auto-generated method stub
		if (cartMap != null)
			return orderDetailRepo.addReceipt(cartMap);
		return false;
	}

}
