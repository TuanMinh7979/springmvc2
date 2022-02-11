package com.springmvc.service;

import java.util.Map;

import com.springmvc.pojo.CartI;

public interface OrderService {
	boolean addReceipt(Map<Integer, CartI> cartMap );
}
