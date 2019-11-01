package com.SCMXPert.sbmongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SCMXPert.sbmongodb.document.Login;
import com.SCMXPert.sbmongodb.repository.LoginRepository;

@Controller
@RequestMapping("/SCMXPert")
public class LoginController {
	
	@Autowired
	private LoginRepository loginrepo;
	
	@ResponseBody
	@PostMapping("/Login")
	public String createUser(@RequestBody Login login){
/*		Query query = new Query();
		query.addCriteria(Criteria.where("customer_id").is(login.getCustomer_id()));
		boolean bool =loginrepo.findOne(query);
		if(bool){*/	
/*		if(loginrepo.findBycustomer_id1(login.getCustomer_id()).toString() != null ){
		
			return "Already Customer_ID exists";
		}else{
		System.out.println(loginrepo.findBycustomer_id1(login.getCustomer_id()).toString().length());
			loginrepo.save(login);
			return login.toString();
		}*/
/*		}else{
			
			return "Already With Same Custome_ID user exists";
		}*/
		return "Already With Same Custome_ID user exists";	
	}
	
	@ResponseBody
	@GetMapping("/getValidation/{email}")
	public List<Login> demo(@PathVariable String email){
		
		
		return loginrepo.findByemail(email);
		
	}

	
}
