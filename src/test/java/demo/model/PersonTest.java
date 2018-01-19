package demo.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {

	//curl -i -X POST -H "Content-Type:application/json" -d '{ "firstName" : "John", "lastName" : "Borys" }' localhost:8080/persons

	@Test
	public void testGetFirstName(){
		Person person = new Person();
        person.setFirstName("bob");
        assertEquals("bob",person.getFirstName());
	}

	@Test
	public void testGetLastName(){
		Person person = new Person();
		person.setLastName("last_name_xi");
		assertEquals("last_name_xi",person.getLastName());
	}

}


