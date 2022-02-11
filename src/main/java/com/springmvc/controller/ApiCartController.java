package com.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.pojo.CartI;
import com.springmvc.service.OrderService;
import com.springmvc.utils.Utils1;

@RestController
public class ApiCartController {
	@Autowired
	private OrderService orderService;

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
		return Utils1.countCart(cartMap);
	}

	@PutMapping("/api/cart")

	public ResponseEntity<Map<String, String>> updateQuanlity(@RequestBody CartI carti, HttpSession session) {
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
		return new ResponseEntity<>(Utils1.cartStats(cartMap), HttpStatus.OK);

	}

	@DeleteMapping("/api/cart/{productId}")
	public ResponseEntity<Map<String, String>> deleteCartItem(@PathVariable(value = "productId") int productId,
			HttpSession session) {
		Map<Integer, CartI> cartMap = (Map<Integer, CartI>) session.getAttribute("cartMap");
		if (cartMap != null && cartMap.containsKey(productId)) {
			cartMap.remove(productId);

			session.setAttribute("cartMap", cartMap);
		}
		// phai return de cap nhat number tren gio ngay con neu khong thi phai reload
		// moi co the cap nhat lai dc
		return new ResponseEntity<>(Utils1.cartStats(cartMap), HttpStatus.OK);

	}

	@PostMapping("/api/pay")
	public HttpStatus pay(HttpSession session) {
		if (orderService.addReceipt((Map<Integer, CartI>) session.getAttribute("cartMap"))) {
			session.removeAttribute("cartMap");
			return  HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
			

	}
}
