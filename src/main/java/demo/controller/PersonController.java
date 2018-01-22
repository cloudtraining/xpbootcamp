package demo.controller;


import io.swagger.annotations.Api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Person;
import demo.repository.PersonRepository;

//@Api("personcontroller")
@RestController
public class PersonController {

    //@Autowired 		<-- not autowired to allow MockMvc testing
    private PersonRepository personRepository;
    
	public PersonController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

    @GetMapping("/personcontroller/findAll")
    public Iterable<Person> findAll(){
        return personRepository.findAll();
    }
    
    @GetMapping("/personcontroller/findByLastName")
    public Person findByLastName(@RequestParam("lastName") String lastName){
    	return personRepository.findByLastName(lastName);
    }

}
