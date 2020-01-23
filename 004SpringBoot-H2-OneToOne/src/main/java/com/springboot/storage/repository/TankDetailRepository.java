package com.springboot.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.storage.entity.TankDetail;

public interface TankDetailRepository extends JpaRepository<TankDetail, Integer>{

}
