package com.dealership.inventory;

import java.time.LocalDate;
import com.dealership.accounts.User;

public class Transaction {

	private int transactionNumber;
	private LocalDate sellDate;
	private User user;
	private Listing listing;
	private double sellPrice;
	private String saleType;
	private String paymentMethod;

	public Transaction() {
	}

	public Transaction(int transactionNumber, LocalDate sellDate, User user, Listing listing, double sellPrice,
			String saleType, String paymentMethod) {
		super();
		this.transactionNumber = transactionNumber;
		this.sellDate = sellDate;
		this.user = user;
		this.listing = listing;
		this.sellPrice = sellPrice;
		this.saleType = saleType;
		this.paymentMethod = paymentMethod;
	}

	public LocalDate getSellDate() {
		return sellDate;
	}

	public void setSellDate(LocalDate sellDate) {
		this.sellDate = sellDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Listing getListing() {
		return listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getSaleType() {
		return saleType;
	}

	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}

	public int getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
}
