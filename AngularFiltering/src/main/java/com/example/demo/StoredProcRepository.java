package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface StoredProcRepository extends JpaRepository<Item, String> {

//	 @Query(value = "CALL FilterItems(:userInput)", nativeQuery = true)
//	    List<String> filterItems(String userInput);
//	 
	
	@Query(value = "CALL FilterItems(:userInput)", nativeQuery = true)
	List<String> filterItems(@Param("userInput") String userInput);

	 
}