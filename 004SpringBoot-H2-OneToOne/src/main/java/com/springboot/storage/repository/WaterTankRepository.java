package com.springboot.storage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.storage.entity.WaterTank;

public interface WaterTankRepository extends JpaRepository<WaterTank, Integer> {
	
	List<WaterTank> findByStatus(String status);
	
	//use native query to find water tanks by status!
	@Query("from WaterTank where status like %:st%")
	List<WaterTank> customFindByStatus(String st);
	
}
