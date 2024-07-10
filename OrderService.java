package com.wakefit.ecommerce.service;

import com.wakefit.ecommerce.entity.Order;

public interface OrderService {
    Order addOrder(Order order);
    Order getOrderById(Long orderId);
	Order updateOrder(Long orderId, Order updatedOrder);
	void deleteOrder(Long orderId);
   
}
