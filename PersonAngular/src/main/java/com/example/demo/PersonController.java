package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/persons")
public class PersonController {

 @Autowired
 private PersonService personService;

 @GetMapping("/getAllPersons")
 public List<Person> getAllPersons() {
     return personService.getAllPersons();
 }

 @PostMapping("/savePersonNew")
 public ResponseEntity<String> savePerson(@RequestBody Person person) {
     if (personService.isDuplicate(person)) {
         return ResponseEntity.status(400).body("DuplicateNameAndAge");
     } else {
    	 personService.savePerson(person);
         return ResponseEntity.ok("Person saved successfully");
     }
 }
 
 
 @GetMapping("/getPerson/{id}")
 public Person getAllPersons(@PathVariable Long id) {
	 System.out.println("get");
     return personService.getPersonById(id);
 }
 
 
 @PostMapping("/savePerson")
 public Person savePersonFirst(@RequestBody Person person) {
	 System.out.println("here");
	 System.out.println(person.getAge());
	 System.out.println(person.getName());
	 return personService.savePersonFirst(person);
 }

 
}
