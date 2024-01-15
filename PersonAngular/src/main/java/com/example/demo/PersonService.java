package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	 @Autowired
	    private PersonRepository dataRepository;

	    public List<Person> getAllPersons() {
	        return dataRepository.findAll();
	    }

	    public boolean isDuplicate(Person person) {
	        return dataRepository.existsByNameAndAge(person.getName(), person.getAge());
	    }

	    public void savePerson(Person person) {
	        dataRepository.save(person);
	    }
	    
	    
	    public Person getPersonById(Long id) {
	    	return dataRepository.findById(id).get();
	    	
	    }
	    
	    public Person savePersonFirst(Person person) {
	    	System.out.println(person.getAge());
	    	Person p = dataRepository.save(person);
	        return p;
	    }
}
