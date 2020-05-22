package com.example.demo.omreon.model;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScUserlogRepository extends JpaRepository<ScUserlog, Integer>{

	@Query(value = "select min(log_time) from sc_userlog", nativeQuery = true )
	Date min();
	@Query(value = "select max(log_time) from sc_userlog", nativeQuery = true)
	Date max();
	
	//void updateDay();
	
}
