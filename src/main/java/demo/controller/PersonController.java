package demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Person;
import demo.service.PersonService;

//@Api("personcontroller")
@RestController
public class PersonController {

    //@Autowired 		<-- not autowired to allow MockMvc testing
    private PersonService personService;
    
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

    @GetMapping("/personcontroller/findAll")
    public Iterable<Person> findAll(){
        return personService.findAll();
    }
    
    @GetMapping("/personcontroller/findByLastName")
    public Person findByLastName(@RequestParam("lastName") String lastName){
    	return personService.findByLastName(lastName);
    }

}
