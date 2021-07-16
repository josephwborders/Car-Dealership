package com.app.dealer.controller;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dealer.dao.AccountsRepository;
import com.app.dealer.model.Account;
import com.app.dealer.service.AcountService;

@Controller
public class AppController {
	
	@Autowired
	public AcountService acountService;
	
	@Autowired
	private AccountsRepository accountsRepository;
	
	@Autowired
	private HttpServletRequest request;

	@GetMapping({"home","index","/"})	
	String home(Model model) {
		
		model.addAttribute("msg", "Welcome to spring!!");
				
		return "index";		
	}
	
	@GetMapping("users")	
	String users(Model model) {
		
		model.addAttribute("users", accountsRepository.findAll());
		
		return "users";		
	}

	@GetMapping("about")	
	String about(Model model) {
		
		model.addAttribute("msg", "This is about us!");
		model.addAttribute("success", "about");
		
		return "about";		
	}
	
	@GetMapping("contact")	
	String contact(Model model) {
		
		model.addAttribute("msg", "This is contact us!");
		model.addAttribute("success", "Drop us a line");
		
		return "contact";		
	}
	
	@GetMapping("signup")	
	String register(Model model) {
		
		model.addAttribute("msg", "Please Register");
		model.addAttribute("user", new Account());
		
		return "register";		
	}
	
	@GetMapping("edituser")
	String editUser(@RequestParam String email, Model model) {
		
		model.addAttribute("user", accountsRepository.findByEmail(email));
		
		return "register";	
	}
	
		
	/*
	 * @PostMapping("register") String register(@RequestParam String
	 * fname, @RequestParam String lname, @RequestParam String phone, @RequestParam
	 * String grade,
	 * 
	 * @RequestParam String email, @RequestParam String password, @RequestParam
	 * String age, RedirectAttributes redirect) {
	 * 
	 * Account acc= new Account(); acc.setGrade(grade); acc.setAge(age);
	 * acc.setEmail(email); acc.setFname(fname); acc.setLname(lname);
	 * acc.setPhone(phone); acc.setPass(password); acountService.saveUser(acc);
	 * //model.addAttribute("users", acountService.findAll());
	 * redirect.addFlashAttribute("success", "Thank you account added ");
	 * 
	 * return "redirect:index"; }
	 */
	
	@PostMapping("adduser")
	String adduser(@ModelAttribute Account user, RedirectAttributes redirect) {
		
		Optional <Account> acc= accountsRepository.findByEmail(user.getEmail());
		if(acc.isPresent()) {
			redirect.addFlashAttribute("error", "Email Exists try another one");
			return "redirect:signup";	
		}
		accountsRepository.save(user);
		redirect.addFlashAttribute("success", "Thank you account added ");
		
	return "redirect:users";
	}
	
	@PostMapping("updateuser")	
	String update(@ModelAttribute Account user, Model model) {
		Optional<Account> acc=accountsRepository.findById(user.getId());
		acc.ifPresent(a->{
			a.setAge(user.getAge());
			a.setFname(user.getFname());
			a.setGrade(user.getGrade());
			a.setLname(user.getLname());
			a.setPhone(user.getPhone());
			accountsRepository.save(a);
		});
		model.addAttribute("account", acc.get());
		model.addAttribute("success", "Update Success");
		
		
		return "welcome";	
	
	}
	
	@PostMapping("search")
	String searchusers(@RequestParam String keyword, Model model) {
		
		model.addAttribute("users", accountsRepository.searchIgnoreCase(keyword));
		
		return "users";
	}
	
	@GetMapping("delete-{email}")
	String delete(@PathVariable String email, RedirectAttributes redirect) {
		
		accountsRepository.delete(accountsRepository.findByEmail(email).get());
		
		redirect.addFlashAttribute("success", "ccount Deleted ");
		
		return "redirect:users";
		
	}
	
	
	@GetMapping("deleteByid-{id}")
	String deleteById(@PathVariable Long id, RedirectAttributes redirect) {
		
		accountsRepository.deleteById(id);		
		redirect.addFlashAttribute("success", "ccount Deleted ");
		
		return "redirect:users";
		
	}
	
	
	@GetMapping("login")	
	String login(@RequestParam(required=false) boolean expired, Model model) {
		
		model.addAttribute("msg", "Login");
		if(expired==true) {
		model.addAttribute("expired", "You have been logged out due to inactivity");
		}
		
		return "login";		
	}
	
	@PostMapping("authenticate")
	String authenticate(@RequestParam String email, @RequestParam String pass, Model model) {
		
		Optional<Account> acc= accountsRepository.findByEmail(email);
		
		if(acc.isPresent() && acc.get().getPass().equals(pass)) {
			model.addAttribute("account", acc.get());
			request.getSession().setAttribute("email", acc.get().getEmail());
			return "welcome";	
		}else {
			model.addAttribute("error", "Inavalid Credentials");
		}
		
		return "login";
	}
	
	@GetMapping("profile")
	String profile(Model model, @SessionAttribute(required=false) String email) {
		if(email==null) {
			model.addAttribute("msg", "Please login");
			return "login";
		}
		model.addAttribute("account", accountsRepository.findByEmail(email).get());
		
		return "welcome";	
	}
	
	@GetMapping("logout")
	String logout(Model model) {
		
		request.getSession().removeAttribute("email");
		model.addAttribute("msg", "You have been logged out");
		
		return "login";	
	}
	
	@PostMapping("/addimages")
	public String add(@RequestParam MultipartFile file, @RequestParam Long id, RedirectAttributes model) {
    	    
		Pattern ext = Pattern.compile("([^\\s]+(\\.(?i)(png|jpg|mp4|pdf))$)");
		try {
			
			  if(file != null && file.isEmpty()){
				  model.addFlashAttribute("error", "Error No file Selected "); 
			      return "redirect:profile"; 
			      } 
			  if(file.getSize()>1073741824){
				  model.addAttribute("error","File size "+file.getSize()+"KB excceds max allowed, try another photo ");
				  return "redirect:profile"; 
			      } 
			  Matcher mtch = ext.matcher(file.getOriginalFilename());
			  
			  if (!mtch.matches()) {
				  model.addFlashAttribute("error", "Invalid Image type "); 
			      return "redirect:profile";			  
			  }
			
			  acountService.addProfilePhoto(file, id, "users");	
				
			model.addFlashAttribute("msg", "Upload success "+ file.getSize()+" KB");
			
		} catch (Exception e) {
			//e.printStackTrace);
		}

		return "redirect:profile";
	} 
	
	
	
}
