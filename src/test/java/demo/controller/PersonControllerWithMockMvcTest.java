package demo.controller;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import demo.fixtures.ModelBuilder;
import demo.model.Person;
import demo.repository.PersonRepository;

/**
 * Unit tests using mockMvc to initiate calls to the PersonController, underlying services are mocked with Mockito.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerWithMockMvcTest {

	@Autowired
	private PersonController personController;
	
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonRepository personRepository;

	@Test
	public void testFindAll() throws Exception {

		List<Person> persons = new ArrayList<>();
		persons.add( ModelBuilder.createPerson(0, "JUnit", "Tester") );
		BDDMockito.given(personRepository.findAll()).willReturn(persons);
		
        MvcResult mvcResult = mockMvc.perform(get("/personcontroller/findAll"))
                .andExpect( status().isOk())
                .andReturn();
        
        String returnedJson = mvcResult.getResponse().getContentAsString();

        assertTrue(returnedJson.contains("JUnit"));
        assertTrue(returnedJson.contains("Tester"));
		
	}
	
	@Test
	public void testByLastNamePerson() throws Exception {
		
		BDDMockito.given(personRepository.findByLastName(Mockito.isA(String.class))).willReturn( ModelBuilder.createPerson(0, "JUnit", "Tester") );

		MvcResult mvcResult = mockMvc.perform(get("/personcontroller/findByLastName?lastName=Tester"))
		         .andExpect( status().isOk())
		         .andReturn();
		
	        String returnedJson = mvcResult.getResponse().getContentAsString();
	        
	        assertTrue(returnedJson.contains("JUnit"));
	        assertTrue(returnedJson.contains("Tester"));
	}

}
