package com.springboot.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.storage.entity.TankLocation;

public interface TankLocationRepository extends JpaRepository<TankLocation, Integer>{

}
