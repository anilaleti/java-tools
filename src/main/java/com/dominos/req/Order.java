package com.dominos.req;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Anil
 *
 * Sep 15, 2018
 */
@XmlRootElement
public class Order {

	private String orderId;
	private String productName;
	private String price;
	private String date;
	private String qty;
	private DeliveryDetails delvryDtls;
	private CustomerDetails cstmrDtls;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public DeliveryDetails getDelvryDtls() {
		return delvryDtls;
	}

	public void setDelvryDtls(DeliveryDetails delvryDtls) {
		this.delvryDtls = delvryDtls;
	}

	public CustomerDetails getCstmrDtls() {
		return cstmrDtls;
	}

	public void setCstmrDtls(CustomerDetails cstmrDtls) {
		this.cstmrDtls = cstmrDtls;
	}

}
