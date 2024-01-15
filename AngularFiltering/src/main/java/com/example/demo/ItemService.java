package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

//src/main/java/com/example/demo/service/ItemService.java

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

import java.util.List;

@Service
public class ItemService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<String> filterItems(String userInput) {
    	
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("FilterItems");
        storedProcedure.registerStoredProcedureParameter("userInput", String.class, jakarta.persistence.ParameterMode.IN);
        storedProcedure.setParameter("userInput", userInput);

        // Execute the stored procedure
        
        	storedProcedure.execute();

        // Retrieve the result set
        System.out.println(storedProcedure.getResultList());
        return storedProcedure.getResultList();
    }
    
    
    @Autowired
    private StoredProcRepository storedProcRepository;

    public List<String> filterItemsUsingJPA(String userInput) {
        return storedProcRepository.filterItems(userInput);
    }
    
    
    
}

