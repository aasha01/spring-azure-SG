package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "product_package")
public class ProductPackage {

	@Id
	@GeneratedValue
	private int ID;
	
	@NotEmpty(message = "Package Name is required.")
	@Size(min=2, message = "Should be atleast 2 characters")
	@Size(max = 250, message = "Should be less than 250 characters")
	private String packageName;
	
	@NotEmpty(message = "Package Description is required.")
	private String packageDescription;
//	private ArrayList<PackageService> packageServices;
	
	@NotNull(message = "Status is required.")
	private int status;
	
	private float price;
	
	@Column(name = "id")
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	@Column(name = "package_name")
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	@Column(name = "package_desc")
	public String getPackageDescription() {
		return packageDescription;
	}
	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}
	
	@Column(name = "status_code")
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name = "price")
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "ProductPackage [ID=" + ID + ", packageName=" + packageName + ", packageDescription="
				+ packageDescription + ", status=" + status + "]";
	}
	
	//	public ArrayList<PackageService> getPackageServices() {
//		return packageServices;
//	}
//	public void setPackageServices(ArrayList<PackageService> packageServices) {
//		this.packageServices = packageServices;
//	}
	
	
	
}
