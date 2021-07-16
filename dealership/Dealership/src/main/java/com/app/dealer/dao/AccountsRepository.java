package com.app.dealer.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.dealer.model.Account;


public interface AccountsRepository extends JpaRepository<Account, Long> {

	Optional<Account> findByEmail(String email);
	
	//position parameter case sensitive
	@Query("select a from Account a where a.fname=?1 OR a.lname=?1 OR a.email=?1")
	List<Account> search(String keyword);

	//position parameter case insensitive
	@Query("select a from Account a where lower(a.fname) like lower(concat('%', ?1,'%'))"
			+ " OR lower(a.lname) like lower(concat('%', ?1,'%')) OR "
			+ "lower(a.email) like lower(concat('%', ?1,'%'))")
	List<Account> searchIgnoreCase(String keyword);
	
	//named parameter case insensitive
	@Query("FROM Account a WHERE a.email LIKE (CONCAT('%',:keyword, '%')) OR a.fname LIKE (CONCAT('%',:keyword, '%')) OR a.lname LIKE (CONCAT('%',:keyword, '%'))")
	List<Account> searchuser(@Param("keyword") String keyword);
	
	
}
