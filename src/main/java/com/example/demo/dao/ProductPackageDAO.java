package com.example.demo.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ProductPackage;
import com.example.demo.repository.PackageRepository;
import com.example.demo.util.CodeSet;

@Service
public class ProductPackageDAO {

    @Autowired
    PackageRepository packageRepository;

    public ProductPackage createPackage(ProductPackage prdPackage) {
        return packageRepository.save(prdPackage);
    }
    
    public ProductPackage findPackageById(int searchPackageId) {
        return packageRepository.findPackageById(searchPackageId);
    }
    
    public ArrayList<ProductPackage> selectAllActivePackages() {
        return packageRepository.selectAllActivePackages(CodeSet.STATUS_ACTIVE); //Active status code = 1 
    }
    
    public ProductPackage findPackageByIdAndName(int searchPackageId, String name) {
        return packageRepository.findPackageByIdAndName(searchPackageId, name);
    }
    
    public ArrayList<ProductPackage> searchPackageAdvanced(String name, String description){
    	return packageRepository.searchPackageAdvanced(name, description);
    }
    
    public ArrayList<ProductPackage> searchPackageByName(String name){
    	return packageRepository.searchPackageByName(name);
    }
    
    public ArrayList<ProductPackage> searchPackageByDesc(String description){
    	return packageRepository.searchPackageByDesc(description);
    }
}
