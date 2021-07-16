package com.dealership.accountservice;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import com.dealership.accounts.User;

@Service
public class AccountService {

	public List<User> accounts = new LinkedList<User>();
	
	// method to generate user id numbers for newly registered accounts
	public int generateUserId() {
		int count = accounts.size() + 1;
		count++;
		return count;
	}
	//method to find a user by email address
	public User findByEmail(String email) {
		User user = new User();
		for (User acc : accounts) {
			if (acc.getEmail().equals(email)) {
				user = acc;
				return user;
			}
		}
		return null;
	}
	// method to find a user by id number
	public User findById(int id) {
		User user = new User();
		for (User acc : accounts) {
			if (acc.getId() == id) {
				user = acc;
				return user;
			}
		}
		return null;
	}
	// method to return a list of all users
	public List<User> listAllUsers() {
		return accounts;
	}
	// method to return a list of users with a role of customer only
	public List<User> findCustomers() {
		List<User> cust = new LinkedList<User>();
		for (User acc : accounts) {
			if (acc.getRole().equalsIgnoreCase("customer"))
				;
			cust.add(acc);
		}
		return cust;
	}
//**code below this line is only for setting default listings********************************************************************	
// adds one administrator account and 10 customer accounts to list "accounts"
	@PostConstruct
	public void defaultAccounts() {
		// create administrator account and add to accounts list
		User admin1 = new User(1, "Manager", "Manager", "2125551212", "admin@dealer.com", "pass", "admin");
		accounts.add(admin1);
		// create 10 customers and add to accounts list
		User customer1 = new User(2, "Tom", "Hanks", "2128081109", "tom@email.com", "pass", "customer");
		User customer2 = new User(3, "Betty", "White", "2128081108", "betty@email.com", "pass", "customer");
		User customer3 = new User(4, "Fred", "Flintstone", "2128081107", "fred@email.com", "pass", "customer");
		User customer4 = new User(5, "Thomas", "Jefferson", "2128061207", "thomas@email.com", "pass", "customer");
		User customer5 = new User(6, "Dwayne", "Johnson", "3128081107", "dwayne@email.com", "pass", "customer");
		User customer6 = new User(7, "Michael", "Jordan", "2164081107", "michael@email.com", "pass", "customer");
		User customer7 = new User(8, "Betty", "Rubble", "4628051107", "betty@email.com", "pass", "customer");
		User customer8 = new User(9, "Taylor", "Swift", "6821231107", "taylor@email.com", "pass", "customer");
		User customer9 = new User(10, "Lindsey", "Lohan", "5208084407", "lindsey@email.com", "pass", "customer");
		User customer10 = new User(11, "Andrew", "Jackson", "9028493707", "andrew@email.com", "pass", "customer");
		accounts.add(customer1);
		accounts.add(customer2);
		accounts.add(customer3);
		accounts.add(customer4);
		accounts.add(customer5);
		accounts.add(customer6);
		accounts.add(customer7);
		accounts.add(customer8);
		accounts.add(customer9);
		accounts.add(customer10);

	}
}
