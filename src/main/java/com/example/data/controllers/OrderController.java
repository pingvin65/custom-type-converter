package com.example.data.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.data.models.Order;

import java.time.LocalDate;

@RestController
@RequestMapping("/orders")
public class OrderController {

	private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

	@GetMapping("/order/{date}")
	public Order getOrderByDate(@PathVariable("date") LocalDate date) {
		String des = "TP-Link AC1750 Smart WiFi Router - Dual Band Gigabit Wireless Internet Router for Home, "
				+ "Works with Alexa, VPN Server, Parental Control&QoS (Archer A7) ";
		LOG.info("Sending order for the request date {} ", date);
		return new Order(64.99, des, date);
	}
}
