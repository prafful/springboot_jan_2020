package com.springboot.storage.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.storage.entity.WaterTank;
import com.springboot.storage.repository.WaterTankRepository;

@RestController
@RequestMapping("/api")
public class TankRestController {
	
	@Autowired
	private WaterTankRepository waterTankRepository;
	
	@RequestMapping("/")
	public String welcome() {
		return "Hello from Spring Boot!";
	}

	//http://localhost:8080/api/watertank/all
	@RequestMapping("/watertank/all")
	public List<WaterTank> getAllWaterTanks() {
		return waterTankRepository.findAll();
	}
	
	//@RequestMapping(value = "/watertank/add", 
	//				method = RequestMethod.POST)
	@PostMapping("/watertank/add")
	public List<WaterTank> addWaterTank(@RequestBody WaterTank wt) {
		waterTankRepository.saveAndFlush(wt);
		return waterTankRepository.findAll();
	}
	
	@GetMapping("/watertank/get/{id}")
	public WaterTank getWaterTankById(@PathVariable Integer id) {
		return waterTankRepository
				.findById(id)
				.orElse(new WaterTank());
		
		
	}
	
	@GetMapping("/watertank/status/{status}")
	public List<WaterTank> getWaterTankByStatus(@PathVariable String status) {
		System.out.println(status);
		return waterTankRepository.findByStatus(status);
	}
	
	@GetMapping("/watertank/status/custom/{status}")
	public List<WaterTank> getWaterTankByStatusCustom(@PathVariable String status) {
		System.out.println(status);
		return waterTankRepository.customFindByStatus(status);
	}
	
	
}
