package com.springboot.storage.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.storage.entity.TankDetail;
import com.springboot.storage.entity.WaterTank;
import com.springboot.storage.repository.TankDetailRepository;
import com.springboot.storage.repository.WaterTankRepository;

@RestController
@RequestMapping("/api")
public class TankRestController {
	
	@Autowired
	private WaterTankRepository waterTankRepository;
	
	@Autowired
	private TankDetailRepository tankDetailRepository;
	
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
	@PostMapping(value = "/watertank/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	
	public List<WaterTank> addWaterTank(@RequestBody WaterTank waterTank) {
		//System.out.println(waterTank.getTankDetail().getLocation());
		TankDetail td = new TankDetail();
		td.setLocation(waterTank.getTankDetail().getLocation());
		waterTank.setTankDetail(td);
		System.out.println(waterTank.getCapacity());
		System.out.println(waterTank.getStatus());
		System.out.println(waterTank.getTankType());
		System.out.println(waterTank.getTankDetail().getLocation());
		waterTankRepository.save(waterTank);
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
	
	@PostMapping("/tanklocation/add")
	public List<TankDetail> addTankLocation(@RequestBody TankDetail td){
		tankDetailRepository.saveAndFlush(td);
		return tankDetailRepository.findAll();
	}
	
	
}
