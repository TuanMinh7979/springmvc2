package com.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.pojo.CartI;
import com.springmvc.utils.utils;

@RestController
public class ApiCartController {
	@PostMapping("/api/cart")
	// khong can response entity
	public int add(@RequestBody CartI carti, HttpSession session) {
		Map<Integer, CartI> cartMap = (Map<Integer, CartI>) session.getAttribute("cartMap");
		if (cartMap == null) {
			cartMap = new HashMap<>();

		}
		int productId = carti.getProductId();
		if (cartMap.containsKey(carti.getProductId())) {
			// san pham da co trong gio
			CartI oldcarti = cartMap.get(productId);
			oldcarti.setQuanlity(oldcarti.getQuanlity() + 1);
		} else {
			carti.setQuanlity(1);
			cartMap.put(productId, carti);
		}
		session.setAttribute("cartMap", cartMap);
		return utils.countCart(cartMap);
	}

	@PutMapping("/api/cart")

	public int updateQuanlity(@RequestBody CartI carti, HttpSession session) {
		Map<Integer, CartI> cartMap = (Map<Integer, CartI>) session.getAttribute("cartMap");
		if (cartMap == null) {
			cartMap = new HashMap<>();

		}
		int productId = carti.getProductId();
		if (cartMap.containsKey(carti.getProductId())) {
			// san pham da co trong gio
			CartI oldcarti = cartMap.get(productId);
			oldcarti.setQuanlity(carti.getQuanlity());
		} else {
			carti.setQuanlity(1);
			cartMap.put(productId, carti);
		}
		session.setAttribute("cartMap", cartMap);
		return utils.countCart(cartMap);

	}

	@DeleteMapping("/api/cart/{productId}")
	public int deleteCartItem(@PathVariable(value = "productId") int productId, HttpSession session) {
		Map<Integer, CartI> cartMap = (Map<Integer, CartI>) session.getAttribute("cartMap");
		if (cartMap != null && cartMap.containsKey(productId)) {
			cartMap.remove(productId);

			session.setAttribute("cartMap", cartMap);
		}
		// phai return de cap nhat number tren gio ngay con neu khong thi phai reload
		// moi co the cap nhat lai dc
		return utils.countCart(cartMap);

	}
}
