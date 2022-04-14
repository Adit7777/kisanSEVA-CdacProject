package com.farmsystem.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.farmsystem.backend.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>
{
	@Query( nativeQuery = true,value="select * from products where crop=:crop")
	public List<Product> findProduct(@Param("crop") String item);
	
	@Query( nativeQuery = true,value="select quantity from products where fid=:fid And crop=:crop")
	public double getQuantity(@Param("fid") int fid ,@Param("crop") String crop);
	
	@Modifying
	@Transactional
	@Query( nativeQuery = true,value="delete from products where fid=:fid And crop=:crop")
	public void deleteQuantityCompletly(@Param("fid") int fid  ,@Param("crop") String crop);
	
	@Modifying
	@Transactional
	@Query( nativeQuery = true,value="update products set quantity =:quantitRemains where fid=:fid And crop=:crop")
	public void deductQuantity(@Param("fid") int fid ,@Param("quantitRemains") double quantitRemains ,@Param("crop") String crop);

	@Query( nativeQuery = true,value="select * from products where fid=:fid")
	public List<Product> findByFid(@Param("fid") int fid);
}
