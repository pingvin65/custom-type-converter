package com.example.data.models;

import java.time.LocalDate;

public class Order {
	private double carg;
	private String description;
	private LocalDate data;

	protected Order() {
	}

	public Order(double carg, String description, LocalDate date) {
		this.carg = carg;
		this.description = description;
		this.data = date;
	}

	public double getCarg() {
		return carg;
	}

	public void setCarg(double carg) {
		this.carg = carg;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getData() {
		return data;
	}

}
