package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
 // Additional query methods, if needed
	
	boolean existsByNameAndAge(String name, int age);
}
