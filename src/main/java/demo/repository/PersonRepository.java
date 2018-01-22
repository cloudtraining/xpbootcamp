package demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import demo.model.Person;


//curl -i -X POST -H "Content-Type:application/json" -d '{ "firstName" : "John", "lastName" : "Borys" }' localhost:8080/persons

@RepositoryRestResource
public interface PersonRepository extends CrudRepository<Person, Long> {

	public Person findByLastName(String lastName);
	
}
