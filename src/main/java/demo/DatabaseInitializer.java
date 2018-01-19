package demo;

import demo.model.Person;
import demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DatabaseInitializer {

    @Autowired
    private PersonRepository personRepository;

    @PostConstruct
    public void initTestData() {

        Person p1 = new Person();
        p1.setFirstName("Alice");
        p1.setLastName("Apple");
        personRepository.save(p1);

        Person p2 = new Person();
        p2.setFirstName("Bob");
        p2.setLastName("Banana");
        personRepository.save(p2);

        Person p3 = new Person();
        p3.setFirstName("Carl");
        p3.setLastName("Cantelope");
        personRepository.save(p3);

        System.err.println("Added two persons to the db.");
    }

}