package com.example.demo;

//src/main/java/com/example/demo/controller/ItemController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/api/items/filter")
    public List<String> filterItems(@RequestParam String userInput) {
//    	if (userInput == null || userInput.isEmpty()) 
//    	    throw new IllegalArgumentException("String must not be empty or null");
        return itemService.filterItems(userInput);
    }
    
  //http://localhost:9111/api/items/filter?userInput=a

    @GetMapping("/api/items/filter/jpa")
    public List<String> filterItemsUsingJpa(@RequestParam String userInput) {
        return itemService.filterItems(userInput);
    }
}
