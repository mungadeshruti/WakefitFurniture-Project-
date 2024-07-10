package com.wakefit.ecommerce.serviceimplement;

import com.wakefit.ecommerce.entity.Order;
import com.wakefit.ecommerce.exception.ResourceNotFoundException;
import com.wakefit.ecommerce.repository.OrderRepository;
import com.wakefit.ecommerce.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + orderId));
    }

    @Override
    public Order updateOrder(Long orderId, Order updatedOrder) {
        Order existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + orderId));

        // Update existingOrder with updatedOrder fields
        existingOrder.setOrderStatus(updatedOrder.getOrderStatus());
        existingOrder.setTotalAmount(updatedOrder.getTotalAmount());
        // Update other fields as needed

        return orderRepository.save(existingOrder);
    }

    @Override
    public void deleteOrder(Long orderId) {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
        } else {
            throw new ResourceNotFoundException("Order not found with id " + orderId);
        }
    }
}
