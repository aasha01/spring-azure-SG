package com.example.demo.repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ProductPackage;

@Repository
public interface PackageRepository extends JpaRepository<ProductPackage, Long>{

	//JPA Query
	@Query("SELECT PP FROM ProductPackage PP WHERE PP.id=?1")
	ProductPackage findPackageById(@Param("id") int id);
	
	@Query("SELECT PP FROM ProductPackage PP WHERE PP.status=?1")
	ArrayList<ProductPackage> selectAllActivePackages(int status);
	
	@Query(
			value = "SELECT pck.* FROM product_package pck WHERE id = :id AND package_name like :name%", 
			nativeQuery = true)
	ProductPackage findPackageByIdAndName(int id, String name);
	
	@Query(
			value = "SELECT pck.* FROM product_package pck WHERE package_name like %:name% OR package_description like %:description%", 
			nativeQuery = true)
	ArrayList<ProductPackage> searchPackageAdvanced(@Param("name") String name, @Param("description") String description);
	
	@Query(
			value = "SELECT pck.* FROM product_package pck WHERE package_name like %:name%", 
			nativeQuery = true)
	ArrayList<ProductPackage> searchPackageByName(@Param("name") String name);
	
	@Query(
			value = "SELECT pck.* FROM product_package pck WHERE package_description like %:description%",
			nativeQuery = true)
	ArrayList<ProductPackage> searchPackageByDesc(@Param("description") String description);
	

}
