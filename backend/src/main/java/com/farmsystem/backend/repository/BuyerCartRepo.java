package com.farmsystem.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmsystem.backend.entity.BuyerCart;


public interface BuyerCartRepo extends JpaRepository<BuyerCart, Integer> {

}
