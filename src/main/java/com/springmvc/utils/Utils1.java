package com.springmvc.utils;

import java.util.HashMap;
import java.util.Map;

import com.springmvc.pojo.CartI;

public class Utils1 {
	public static int countCart(Map<Integer, CartI> cartMap) {
		int q = 0;
		if (cartMap != null) {
			for (CartI c : cartMap.values()) {
				q += c.getQuanlity();
			}
		}
		return q;

	}

	public static Map<String, String> cartStats(Map<Integer, CartI> cartMap) {
		Long s = 0l;
		int q = 0;
		if (cartMap != null)
			for (CartI c : cartMap.values()) {
				q += c.getQuanlity();
				s += c.getQuanlity() * c.getPrice();
			}

		Map<String, String> kq = new HashMap<>();
//		Long da= (long)q;
		kq.put("counter", String.valueOf(q));
		kq.put("amount", String.valueOf(s));
		return kq;
	}
}
