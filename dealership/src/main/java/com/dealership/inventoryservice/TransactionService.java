package com.dealership.inventoryservice;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dealership.accountservice.*;
import com.dealership.inventory.Transaction;

@Service
public class TransactionService {

	@Autowired
	AccountService as;
	
	@Autowired
	ListingService ls;
	
	public List<Transaction> transactionList = new LinkedList<>();
	
	// method to return a list of all transactions stored in "transactionList"
	public List<Transaction> findAll() {
		return transactionList;
	}
	// method to complete a purchase, creates a transaction object linking a listing object and a user object
	// together, then deleting the listing from available inventory before adding the new transaction to
	// "transactionList"
	public void completePurchase(int stockNumber, int id, double sellPrice, String saleType) {
		Transaction tr = new Transaction();
		tr.setTransactionNumber(transactionList.size()+1);
		tr.setSellDate(LocalDate.now());
		tr.setUser(as.findById(id));
		tr.setListing(ls.findByStockNumber(stockNumber));
		tr.setSellPrice(sellPrice);
		tr.setSaleType(saleType);
		tr.setPaymentMethod("Cash");
		transactionList.add(tr);
		
		ls.activeList.remove(ls.findByStockNumber(stockNumber));
	}
	
}
