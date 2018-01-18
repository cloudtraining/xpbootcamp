package demo.controller;


import demo.model.Person;
import demo.repository.PersonRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("personcontroller")
@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/personcontroller/findAll")
    public Iterable<Person> findAll(){
        return personRepository.findAll();
    }

}
