package com.farmsystem.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.farmsystem.backend.entity.Order;


public interface OrderRepo  extends JpaRepository<Order, Integer>
{
	@Query(name="byName", nativeQuery = true,value="select * from orders where fid=:fid")
	public List<Order> findById(@Param("fid") int fid);
	
	@Transactional
	@Modifying
	@Query(name="changeStatus", nativeQuery = true,value="update Orders set status= 'approved' where oid=:oid")
	public int changeStatus(@Param("oid") int oid);
	
	@Query(name="byName", nativeQuery = true,value="select * from orders where bid=:bid && status='approved'")
	public List<Order> findByBId(@Param("bid") int bid);

}
