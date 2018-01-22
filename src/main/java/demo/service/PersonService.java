package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.model.Person;
import demo.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
    public Iterable<Person> findAll(){
        return personRepository.findAll();
    }
    
    public Person findByLastName(String lastName){
    	return personRepository.findByLastName(lastName);
    }
	
}
