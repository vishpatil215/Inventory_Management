package com.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class LogsPro {

	@Id
	private int id;
	private String iname;
	private String date;
	private int quantity;
	private int cost;
	private int itemid;
	private String itemname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public LogsPro(int id, String iname, String date, int quantity, int cost, int itemid, String itemname) {
		super();
		this.id = id;
		this.iname = iname;
		this.date = date;
		this.quantity = quantity;
		this.cost = cost;
		this.itemid = itemid;
		this.itemname = itemname;
	}
	public LogsPro() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LogsPro [id=" + id + ", iname=" + iname + ", date=" + date + ", quantity=" + quantity + ", cost=" + cost
				+ ", itemid=" + itemid + ", itemname=" + itemname + "]";
	}
	
}
