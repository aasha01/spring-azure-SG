package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.ProductPackageDAO;
import com.example.demo.exception.ProductPackageAlreadyExistingException;
import com.example.demo.exception.ProductPackageNotFoundException;
import com.example.demo.model.ProductPackage;
import com.example.demo.util.StringUtil;

import jakarta.validation.Valid;

//@CrossOrigin(origins = {"http://localhost:3000/"})
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/package")
public class ProductPackageController {

	@Autowired
	private ProductPackageDAO pkgDAO;
	
	@GetMapping("/")
	public String greeting() {
		return "Hello! Welcome!!!";
	}
	
	@PostMapping("/create")
	public ResponseEntity<ProductPackage> create(@Valid @RequestBody ProductPackage newPackage) {
		
		ProductPackage searchPkg = new ProductPackage();
		searchPkg.setPackageName(newPackage.getPackageName());
		searchPkg.setStatus(1);
		
		ArrayList<ProductPackage> foundPackages = pkgDAO.searchPackageByName(newPackage.getPackageName());
		boolean isExisting = false;
		
		Iterator<ProductPackage> it = foundPackages.iterator();
		
		while(it.hasNext()) {
			ProductPackage temp = it.next();
			if(temp.getPackageName().equalsIgnoreCase(newPackage.getPackageName())) {
				isExisting = true;
				break;
			}
		}
		
		if(isExisting) {
			System.out.println("An active Product Package already exisiting with same name.");
			throw new ProductPackageAlreadyExistingException("An active Product Package already exisiting with same name.");
		}
		System.out.println("after");
		return new ResponseEntity<ProductPackage>(pkgDAO.createPackage(newPackage), HttpStatus.CREATED);
	}
	
	@GetMapping("/selectAllActivePackages")
	public ArrayList<ProductPackage> selectAllActivePackages() {
		return pkgDAO.selectAllActivePackages();
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> testAPIConnection() {
		return ResponseEntity.ok("API is working fine");
	}
	
	@GetMapping("/searchPackages")
	public ArrayList<ProductPackage> getAllPackages(@RequestBody(required = false) ProductPackage searchPackage) {
	    return null;
	}
	
	@GetMapping("/findPackage")
	public ProductPackage findPackage(@RequestBody(required = false) ProductPackage searchPackage) {
	    return null;
	}
	
	@GetMapping("/findPackageById")
	public ResponseEntity<ProductPackage> findPackageById(@RequestParam(required = false) String id) {
		int iid = -1;
		try {
			iid = Integer.parseInt(id);
		}catch(Exception e) {
			System.out.println("Invalid input {Id}");
			return null;
		}
		
		ProductPackage foundPackage = pkgDAO.findPackageById(iid);
		if(foundPackage == null) {
			throw new ProductPackageNotFoundException("Product Package not found with Id: " + id);
		} else {
			return new ResponseEntity<ProductPackage>(foundPackage, HttpStatus.FOUND);		
		}
	}
	
	@GetMapping("/findPackageByIdAndName")
	public ProductPackage findPackageByIdAndName(@RequestParam(required = false) String searchPackageId, @RequestParam(required = true) String name) {
		int id = -1;
		try {
			id = Integer.parseInt(searchPackageId);
		}catch(Exception e) {
			System.out.println("Invalid input {Id}");
			return null;
		}
	    return pkgDAO.findPackageByIdAndName(id, name);
	}
	
	@GetMapping("/advPackageSearch")
	public ArrayList<ProductPackage> advancedPackageSearch(@RequestParam(required = false) String name, @RequestParam(required = false) String description) {
		
	    if(StringUtil.isNullOrEmpty(name) && StringUtil.isNullOrEmpty(description)) {
	    	throw new IllegalArgumentException();
	    
	    } else if(StringUtil.isNullOrEmpty(name) && StringUtil.isNullOrEmpty(description)) {
	    	return pkgDAO.searchPackageAdvanced(StringUtil.toNullEmpty(name), StringUtil.toNullEmpty(description));
	    	
	    } else if(StringUtil.isNotNullOrEmpty(name) && StringUtil.isNullOrEmpty(description)) {
	    	return pkgDAO.searchPackageByName(StringUtil.toNullEmpty(name));
	    
	    } else if(StringUtil.isNullOrEmpty(name) && StringUtil.isNotNullOrEmpty(description)) {
	    	return pkgDAO.searchPackageByDesc(StringUtil.toNullEmpty(description));
	    
	    } else {
	    	throw new IllegalArgumentException();
	    }
	}
	
	@GetMapping("/keywordPkgSearch/{keyword}")
	//@CrossOrigin(origins = "http://localhost:3000/search")
	//public ArrayList<ProductPackage> keywordPackageSearch() {
	public ArrayList<ProductPackage> keywordPackageSearch(@PathVariable(required = false) String keyword) {
		//String keyword = "bath";
	    if(StringUtil.isNullOrEmpty(keyword)) {
	    	throw new IllegalArgumentException();
	    } else {
	    	return pkgDAO.searchPackageAdvanced(StringUtil.toNullEmpty(keyword), StringUtil.toNullEmpty(keyword));
	    } 
	}
	
	@DeleteMapping("/deletePackageById")
	public ProductPackage deletePackageById(@RequestParam(required = true) String searchPackageId) {
	    return null;
	}
	
	@GetMapping("/customers")
	public String callUser() {
		
		 // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Specify the URL you want to call
        String apiUrl = "http://localhost:8092/customers/test";

        // Make a GET request and store the response in a ResponseEntity
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

        // Extract and print the response body
        String responseBody = response.getBody();
        System.out.println("Response: " + responseBody);
        
		return responseBody;
	}
}
