package demo.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {

	public static Person createMockPerson(long id, String firstName, String lastName) 
	{
		Person person = new Person();
		person.setId(id);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		return person;
	}

	@Test
	public void testPerson() throws Exception {
		Person person = PersonTest.createMockPerson(99L, "Bob", "Banana");
        assertEquals(99L, person.getId());
        assertEquals("Bob", person.getFirstName());
		assertEquals("Banana" ,person.getLastName());
	}


}


