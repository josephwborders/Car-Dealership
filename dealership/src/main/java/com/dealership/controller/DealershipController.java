package com.dealership.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.dealership.accounts.User;
import com.dealership.accountservice.AccountService;
import com.dealership.inventory.Listing;
import com.dealership.inventory.Vehicle;
import com.dealership.inventoryservice.ListingService;
import com.dealership.inventoryservice.TransactionService;
import java.util.List;

@Controller
public class DealershipController {

	@Autowired
	AccountService as;

	@Autowired
	ListingService ls;

	@Autowired
	TransactionService ts;

	@GetMapping("/")
	public String home(Model model, HttpSession session) {
		session.getAttribute("user");
		return "index";
	}

	@GetMapping("/welcome")
	public String welcome(Model model, HttpSession session) {
		model.addAttribute("listings", ls.listAll());
		model.addAttribute("transactions", ts.findAll());
		return "welcome";
	}

	@GetMapping("/details")
	public String detail(@RequestParam int stockNumber, Model model, HttpSession session) {
		model.addAttribute("listing", ls.findByStockNumber(stockNumber));
		model.addAttribute("transactions", ts.findAll());
		model.addAttribute("customers", as.findCustomers());
		return "details";
	}

	@GetMapping("/bid")
	public String bid(@RequestParam int stockNumber, Model model, HttpSession session) {
		model.addAttribute("listing", ls.findByStockNumber(stockNumber));
		return "bid";
	}

	@PostMapping("/bid")
	public String handleBid(@RequestParam int stockNumber, @RequestParam double bidAmt, Model model,
			HttpSession session) {
//		session.getAttribute("user");
		model.getAttribute("user");
		model.getAttribute("listing");
		model.addAttribute("listing", ls.findByStockNumber(stockNumber));
		Listing bidVeh = ls.findByStockNumber(stockNumber);
		double reservePrice = (bidVeh.vehicle.getPrice()) - bidVeh.vehicle.getPrice() * 0.1;

		if (bidAmt >= reservePrice) {
			model.addAttribute("msg", "Your bid of $" + bidAmt + " is successful! Please proceed to payment.");
			model.getAttribute("user");
			model.addAttribute("bid", bidAmt);
			return "bid-success";
		}
		model.addAttribute("msg", "Your bid does not meet the reserve requirement. Please bid again.");
		return "bid";
	}

	@GetMapping("/payment")
	public String payment(@RequestParam int stockNumber, @RequestParam int id, @RequestParam double sellPrice,
			@RequestParam String saleType, Model model, HttpSession session) {
		model.getAttribute("listing");
		model.addAttribute("listing", ls.findByStockNumber(stockNumber));
		ts.completePurchase(stockNumber, id, sellPrice, saleType);

		return "payment";
	}

	@GetMapping("/search")
	public String search(Model model, HttpSession session) {
		return "search";
	}
	
	@PostMapping("/search")
	String handleSearch(@RequestParam String keyword, Model model, HttpSession session) {
		List<Listing> matches = ls.search(keyword);
		model.addAttribute("matches", matches);
		model.addAttribute("msg", "Sorry, no results found. Please try again.");
		return "results";
	}

	@GetMapping("/browseasguest")
	String browseAsGuest(Model model) {
		model.addAttribute("listings", ls.listAll());
		return "browse-as-guest";
	}

	@GetMapping("/register")
	public ModelAndView register(Model model) {
		return new ModelAndView("register", "user", new User());
	}

	@PostMapping("/register")
	public String handleRegister(@ModelAttribute("user") User user, Model model, HttpSession session) {
		model.addAttribute("newUser", user);
		user.setId(as.generateUserId());
		user.setRole("customer");
		model.addAttribute("newUser", user);
		as.accounts.add(user);
		return "success";
	}

	@GetMapping("/newListing")
	public ModelAndView newListing(Model model, HttpSession session) {
		return new ModelAndView("newListing", "listing", new Listing(LocalDate.now(), 0, new Vehicle()));
	}

	@PostMapping("/newListing")
	public String handleNewListing(@ModelAttribute("listing") Listing listing,
			@ModelAttribute("newVehicle") Vehicle vehicle, Model model, HttpSession session) {
		model.addAttribute("newListing", listing);
		listing.setDateListed(LocalDate.now());
		listing.setListingAge(ls.calcListingAge(listing.getDateListed()));
		listing.vehicle.setStockNumber(ls.activeList.size() + 10001);
		ls.activeList.add(listing);
		model.addAttribute("msg", "New Listing Has Been Added");
		model.addAttribute("listings", ls.listAll());
		return "welcome";
	}

	@GetMapping("/login")
	public ModelAndView login(Model model) {
		return new ModelAndView("login", "user", new User());
	}

	@PostMapping("/login")
	public String handleLogin(@ModelAttribute("user") User user, Model model, HttpSession session) {

		User login = as.findByEmail(user.getEmail());

		if (login != null && login.getPassword().equals(user.getPassword())) {
			user = login;
			model.addAttribute("user", user);
			session.setAttribute("user", user);
			model.addAttribute("listings", ls.listAll());
			model.addAttribute("transactions", ts.findAll());
			model.addAttribute("customers", as.findCustomers());
			return "welcome";

		}
		model.addAttribute("msg", "Invalid Credentials");
		return "login";
	}

	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		session.removeAttribute("user");
		return "logout";
	}
	
	@GetMapping("/transactions")
	public String transaction(Model model, HttpSession session) {
		model.getAttribute("user");
		model.addAttribute("transactions", ts.findAll());
		return "/transactions";
	}
	
	@GetMapping("/customers")
	public String customerList(Model model, HttpSession session) {
		model.getAttribute("user");
		model.addAttribute("customers", as.findCustomers());
		return "/customers";
	}
}
