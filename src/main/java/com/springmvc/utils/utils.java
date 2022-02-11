package com.springmvc.utils;

import java.util.Map;

import com.springmvc.pojo.CartI;

public class utils {
	public static int countCart(Map<Integer, CartI> cartMap) {
		int q = 0;
		if (cartMap != null) {
			for (CartI c : cartMap.values()) {
				q += c.getQuanlity();
			}
		}
		return q;

	}
}
