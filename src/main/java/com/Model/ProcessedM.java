package com.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="processedm")
@Component
public class ProcessedM {
	
	@Id
	private int id;
	private String name;
	private int quantity;
	private String unit;
	private int costPerUnit;
	@Override
	public String toString() {
		return "ProcessedM [id=" + id + ", name=" + name + ", quantity=" + quantity + ", unit=" + unit
				+ ", costPerUnit=" + costPerUnit + "]";
	}
	public ProcessedM() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProcessedM(int id, String name, int quantity, String unit, int costPerUnit) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
		this.costPerUnit = costPerUnit;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getCostPerUnit() {
		return costPerUnit;
	}
	public void setCostPerUnit(int costPerUnit) {
		this.costPerUnit = costPerUnit;
	}
	

}
