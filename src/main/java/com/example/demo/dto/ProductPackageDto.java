package com.example.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ProductPackageDto {
	
	private int id;
	
	@NotEmpty(message = "Package Name is required.")
	@Size(min=2, message = "Should be atleast 2 characters")
	@Size(max = 250, message = "Should be less than 250 characters")
	private String packageName;
	
	private String packageDescription;
	
	private float price;
//	private ArrayList<PackageService> packageServices;
	
	public ProductPackageDto(int id, String packageName, String packageDescription) {
		super();
		this.packageName = packageName;
		this.packageDescription = packageDescription;
	}
	
	public int getId() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	public String getPackageDescription() {
		return packageDescription;
	}
	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
