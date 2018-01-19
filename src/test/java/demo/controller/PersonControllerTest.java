package demo.controller;

import demo.model.Person;
import demo.model.PersonTest;
import demo.repository.PersonRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static demo.fixtures.ModelBuilder.createPerson;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonController personController;

    @Test
    public void testFindAll() throws Exception {
        List<Person> mockPersons = new ArrayList<Person>();
        mockPersons.add( createPerson(0, "Alice",  "Apple") );
        mockPersons.add( createPerson(0, "Bob",  "Banana") );

        when(personRepository.findAll()).thenReturn(mockPersons);

        Iterable<Person> actualPersons = personController.findAll();

        assertNotNull(actualPersons);
        
        Iterator<Person> iter = actualPersons.iterator();
        Person firstPerson = iter.next();
        assertEquals("Alice", firstPerson.getFirstName());
        
        Person secondPerson = iter.next();
        assertEquals("Banana", secondPerson.getLastName());
    }
}
