package com.sarvika.technologies.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sarvika.technologies.assignment.exception.OrderNotFoundException;
import com.sarvika.technologies.assignment.model.Order;
import com.sarvika.technologies.assignment.model.User;
import com.sarvika.technologies.assignment.repository.OrderRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private RestTemplate restTemplate;

	// Create an order
	public Order createOrder(Order order) {
		ResponseEntity<User> userEntity = getUserById(order.getUserId());
		if (userEntity == null || userEntity.getBody() == null) {
			throw new IllegalArgumentException("Invalid User ID: " + order.getUserId());
		}
		orderRepository.save(order);
		order.setUser(userEntity.getBody());
		return order;
	}

	@CircuitBreaker(name = "userService", fallbackMethod = "userServiceFallback")
	public ResponseEntity<User> getUserById(Long userId) {
		try {
			String userServiceUrl = "http://localhost:8081/users/" + userId;
			ResponseEntity<User> response = restTemplate.getForEntity(userServiceUrl, User.class);
			return response;
		} catch (Exception e) {
			throw new RuntimeException("User service is unavailable "+ e.getMessage());
		}
	}

	// Fallback method
	public ResponseEntity<User> userServiceFallback(Long userId, Throwable throwable) {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null); 
	}

	// Get order by ID
	public Order getOrderById(Long orderId) {
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));
		ResponseEntity<User> userEntity = getUserById(order.getUserId());
		if (userEntity != null && userEntity.getBody() != null) {
			order.setUser(userEntity.getBody());
		}

		return order;
	}

	// Get all orders
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	// Update an order
	public Order updateOrder(Long orderId, Order orderDetails) {
		Order order = getOrderById(orderId);
		order.setUserId(orderDetails.getUserId());
		order.setProductIds(orderDetails.getProductIds());
		order.setTotalPrice(orderDetails.getTotalPrice());
		order.setOrderDate(orderDetails.getOrderDate());
		order.setOrderStatus(orderDetails.getOrderStatus());
		return orderRepository.save(order);
	}

	// Delete an order
	public void deleteOrder(Long orderId) {
		Order order = getOrderById(orderId);
		orderRepository.delete(order);
	}

}
