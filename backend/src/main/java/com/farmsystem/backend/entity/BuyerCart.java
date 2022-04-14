package com.farmsystem.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="buyercart")
public class BuyerCart 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cartid")
	private int cartid;
	
	@Column(name="buyerusername")
	private String buyerusername;
	
	@Column(name="crop")
	private String crop;
	
	@Column(name="quantity")
	private double quantity;
	
	@Column(name="expectedprice")
	private double expectedprice;
	
	@Column(name="farmername")
	private String farmername;
	
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public String getBuyerusername() {
		return buyerusername;
	}
	public void setBuyerusername(String buyerusername) {
		this.buyerusername = buyerusername;
	}
	public String getCrop() {
		return crop;
	}
	public void setCrop(String crop) {
		this.crop = crop;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getExpectedprice() {
		return expectedprice;
	}
	public void setExpectedprice(double expectedprice) {
		this.expectedprice = expectedprice;
	}
	public String getFarmername() {
		return farmername;
	}
	public void setFarmername(String farmername) {
		this.farmername = farmername;
	}
	public BuyerCart(int cartid, String buyerusername, String crop, double quantity, double expectedprice,
			String farmername) {
		super();
		this.cartid = cartid;
		this.buyerusername = buyerusername;
		this.crop = crop;
		this.quantity = quantity;
		this.expectedprice = expectedprice;
		this.farmername = farmername;
	}
	public BuyerCart() {

	}
	
}
