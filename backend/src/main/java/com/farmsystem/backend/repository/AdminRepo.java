package com.farmsystem.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmsystem.backend.entity.Admin;


public interface AdminRepo extends JpaRepository<Admin, Integer>
{
	
}
