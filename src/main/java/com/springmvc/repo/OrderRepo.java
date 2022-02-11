package com.springmvc.repo;

import java.util.Map;

import com.springmvc.pojo.CartI;

public interface OrderRepo {
	boolean addReceipt(Map<Integer, CartI> cartMap);
}
