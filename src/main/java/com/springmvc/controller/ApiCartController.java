package com.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.pojo.CartI;
import com.springmvc.utils.utils;

@RestController
public class ApiCartController {
	@PostMapping("/api/cart")
	public ResponseEntity<Integer> add(@RequestBody CartI carti, HttpSession session) {
		Map<Integer, CartI> cartMap = (Map<Integer, CartI>) session.getAttribute("cartMap");
		if (cartMap == null) {
			cartMap = new HashMap<>();

		}
		int productId= carti.getProductId();
		if (cartMap.containsKey(carti.getProductId())) {
			// san pham da co trong gio
			CartI oldcarti = cartMap.get(productId);
			oldcarti.setQuanlity(oldcarti.getQuanlity() + 1);
		}else {
			carti.setQuanlity(1);
			cartMap.put(productId, carti);
		}
		session.setAttribute("cartMap", cartMap);
		return new ResponseEntity<>(utils.countCart(cartMap), HttpStatus.OK);
	}
}
