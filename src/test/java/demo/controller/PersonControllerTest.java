package demo.controller;

import static demo.fixtures.ModelBuilder.createPerson;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import demo.model.Person;
import demo.repository.PersonRepository;

/**
 * Mockito based unit tests.
 */
@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonController personController;

    @Test
    public void testFindAll() throws Exception {
        List<Person> mockPersons = new ArrayList<Person>();
        mockPersons.add( createPerson(0, "JUnit1",  "Tester1") );
        mockPersons.add( createPerson(0, "JUnit2",  "Tester2") );

        when(personRepository.findAll()).thenReturn(mockPersons);

        Iterable<Person> actualPersons = personController.findAll();

        assertNotNull(actualPersons);
        
        Iterator<Person> iter = actualPersons.iterator();
        Person firstPerson = iter.next();
        assertEquals("JUnit1", firstPerson.getFirstName());
        
        Person secondPerson = iter.next();
        assertEquals("Tester2", secondPerson.getLastName());
    }
}
