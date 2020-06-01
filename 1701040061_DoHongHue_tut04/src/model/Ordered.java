package model;

import java.sql.Date;

public class Ordered {
	private int orderedId;
	private java.sql.Date orderedAt;
	private int quantity;
	private int bookId;
	
	private int userId;
public Ordered(int orderedId, Date orderedAt, int quantity, int bookId, int userId) {
	super();
	this.orderedId = orderedId;
	this.orderedAt = orderedAt;
	this.quantity = quantity;
	this.bookId = bookId;
	this.userId = userId;
}
public Ordered(int orderedId, Date orderedAt, int quantity) {
	this.orderedId = orderedId;
	this.orderedAt = orderedAt;
	this.quantity = quantity;
}
public Ordered(Date orderedAt, int quantity) {
	this.orderedAt = orderedAt;
	this.quantity = quantity;
}



public int getOrderedId() {
	return orderedId;
}
public void setOrderedId(int orderedId) {
	this.orderedId = orderedId;
}
public java.sql.Date getOrderedAt() {
	return orderedAt;
}
public void setOrderedAt(java.sql.Date orderedAt) {
	this.orderedAt = orderedAt;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}

}
