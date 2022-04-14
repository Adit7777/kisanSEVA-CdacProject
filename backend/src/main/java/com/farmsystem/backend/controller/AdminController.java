package com.farmsystem.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmsystem.backend.entity.Admin;
import com.farmsystem.backend.entity.Buyer;
import com.farmsystem.backend.entity.Farmer;
import com.farmsystem.backend.entity.Order;
import com.farmsystem.backend.entity.Product;
import com.farmsystem.backend.repository.AdminRepo;
import com.farmsystem.backend.repository.BuyerCartRepo;
import com.farmsystem.backend.repository.BuyerRepo;
import com.farmsystem.backend.repository.FarmerRepo;
import com.farmsystem.backend.repository.OrderRepo;
import com.farmsystem.backend.repository.ProductRepo;



@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController 
{
	
	@Autowired
	AdminRepo adminRepo;
	
	@Autowired
	BuyerRepo buyerRepo;
	
	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	FarmerRepo farmerRepo;
	
	@PostMapping("/login")
	public String loginUser(@RequestBody Admin admin) {
	        
			System.out.println(admin.getPassword());
			System.out.println(admin.getUser_name());
			List<Admin> adminList = adminRepo.findAll();              
			
			String passMsg = "pass" ;
			String failMsg = "fail" ;
			
			for(Admin adminobj : adminList )
			{
			if(adminobj.getUser_name().equals(admin.getUser_name()) && adminobj.getPassword().equals(admin.getPassword()))
				{
					
					return passMsg ;
				}
			}
		
		return failMsg;
	}
	
	@PostMapping("/buyer-list")
	public List<Buyer> getBuyers() {
	        
		
			List<Buyer> buyerList = buyerRepo.findAll();              
			
		return buyerList;
	}
	
	@PostMapping("/farmer-list")
	public List<Farmer> getFarmers() {
	        
		
			List<Farmer> farmerList = farmerRepo.findAll();              
			
		return farmerList;
	}
	
	@PostMapping("/total-orders")
	public List<Order> getOrders() {
	        
		
			List<Order> orderList = orderRepo.findAll();              
			
		return orderList;
	}
	
	@PostMapping("/products")
	public List<Product> getProduct() {
	        
			List<Product> productList = productRepo.findAll();              
			
		return productList;
	}
}
