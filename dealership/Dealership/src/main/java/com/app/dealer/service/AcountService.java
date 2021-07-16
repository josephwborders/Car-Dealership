package com.app.dealer.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.app.dealer.dao.AccountsRepository;
import com.app.dealer.model.Account;

@Component
public class AcountService {
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	private AccountsRepository accountsRepository;
	
	private static final String UPLOADED_FOLDER = "assets"+ File.separator +"uploads";
	
	public static List<Account> acc= new LinkedList<>();
	
	static {
		acc.add(new Account("James", "Smith", "31", "smith@email.com", "901 847 68346", "M1passw0rd!!","Senior"));
		acc.add(new Account("Jeniffer", "Smith", "21", "jenifer@email.com", "901 847 68346", "M1passw0rd!!","Junior"));
		acc.add(new Account("Jacob", "Smith", "41", "jack@email.com", "901 847 68346", "M1passw0rd!!","Senior"));
		acc.add(new Account("Mathes", "Smith", "41", "matt@email.com", "901 847 68346", "M1passw0rd!!","Junior"));
	}
	
	public void saveUser(Account user) {
		acc.add(user);		
	}
	
	public List<Account> findAll(){
		return acc;
	}
	
	public List<Account> search(String keyword){
		List<Account> users=acc.stream().filter(a->a.getFname().equalsIgnoreCase(keyword) 
							|| a.getLname().equalsIgnoreCase(keyword) || a.getEmail().equalsIgnoreCase(keyword))
							.collect(Collectors.toList());
		return users;
	}
	
	public List<Account> searchwithloop(String keyword){
		List<Account> users= new LinkedList<Account>();
		for(Account a: acc) {
			if(a.getFname().equalsIgnoreCase(keyword) || a.getLname().equalsIgnoreCase(keyword) || a.getEmail().equalsIgnoreCase(keyword)) {
				users.add(a);
			}
		}				
		return users;
	}
	
	public Account findByemail(String email) {
		Account user = acc.stream()
			  .filter(a -> email.equalsIgnoreCase(a.getEmail()))
			  .findAny()
			  .orElse(null);
		return user;
	}
	
	public void delete(String email) {
		Account user=findByemail(email);
		acc.removeIf(a->a.getEmail().equals(user.getEmail()));	
	}
	
	@Transactional
	public void addProfilePhoto(MultipartFile file, long id, String folder) throws Exception {
	      try {
			    // save dir
	    	    String destDir = request.getSession().getServletContext()
	    	    .getRealPath(UPLOADED_FOLDER)+ File.separator +folder+ File.separator +id+ File.separator +"profile";
	    	 
	    	    MultipartFile multipartFile = (MultipartFile) file; 
				String fileName = file.getOriginalFilename(); 
				
				Optional<Account> user= accountsRepository.findById(id);
				String img= user.get().getImage();
				//check if profile image exists and delete before add new
				File dir = new File(destDir);
			    
			    if(!dir.exists()){                                    	 
				    new File(destDir).mkdirs();                                        
					}
			    File doc = new File(destDir + File.separator + img); 
			    if(doc.exists()) {
			    doc.delete(); 
			    }				 
			    //rename file to md5 before upload
			    String parseMd5=md5(fileName.toLowerCase());
			    File destination = new File(destDir + File.separator + parseMd5);
			    //save to file system and db
			    multipartFile.transferTo(destination);
			   //save image to database md5	
			    user.get().setImage(parseMd5);
			    
			  } catch (Exception e) {
				e.printStackTrace();
			} 
		   }
	
	       

	public String md5(String filename) throws NoSuchAlgorithmException, UnsupportedEncodingException{
	    String hash = DatatypeConverter.printHexBinary(MessageDigest.getInstance("MD5").digest(filename.getBytes("UTF-8")));
		return hash;
   }
}
