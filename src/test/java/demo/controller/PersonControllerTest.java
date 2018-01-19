package demo.controller;

import demo.model.Person;
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
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonController personController;

    @Before
    public void setup() {
        //personController = new PersonController();
    }

    @Test
    public void testFindAll() throws Exception {
        List<Person> mockPersons = new ArrayList<Person>();
        Person p = new Person();
        p.setFirstName("foo");
        p.setLastName("bar");
        mockPersons.add(p);

        when(personRepository.findAll()).thenReturn(mockPersons);

        Iterable<Person> actualPersons = personController.findAll();

        assertNotNull(actualPersons);
        Person firstPerson = actualPersons.iterator().next();
        assertEquals("foo", firstPerson.getFirstName());
    }
}
