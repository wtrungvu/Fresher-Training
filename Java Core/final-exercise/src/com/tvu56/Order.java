package com.tvu56;

import java.util.Comparator;
import java.util.Date;

public class Order {
	private int id;
	private int custId;
	private String description;
	private long total;
	private String orderDate;

	Order() {
	}

	Order(int id, int custId, String description, long total, String orderDate) {
		this.id = id;
		this.custId = custId;
		this.description = description;
		this.total = total;
		this.orderDate = orderDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", custId=" + custId + ", description=" + description + ", total=" + total
				+ ", orderDate=" + orderDate + "]";
	}
	
	public static Comparator<Order> COMPARE_BY_TOTAL = new Comparator<Order>() {
		public int compare(Order totalOne, Order totalTwo) {
			return totalOne.getTotal() > totalTwo.getTotal() ? -1 : totalOne.getTotal() < totalTwo.getTotal() ? 1 : 0;
		}
	};

}
