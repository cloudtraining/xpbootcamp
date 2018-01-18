package demo.repository;




////@RunWith(SpringRunner.class)
////@WebMvcTest(controllers = PersonRepository.class, secure=false)
////@SpringBootTest //webEnvironment = SpringBootTest.WebEnvironment.MOCK)
////@ContextConfiguration("PersonRepository")
////@RunWith(SpringJUnit4ClassRunner.class)
////@SpringApplicationConfiguration(classes = Application.class)
////@BootstrapWith(value=org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTestContextBootstrapper.class)
////@AutoConfigureWebMvc
////@AutoConfigureMockMvc


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest         //Instanciates MockMvc
@AutoConfigureMockMvc   // MockMvc AutoConfiguration Eliminates need for Builder
@ActiveProfiles("unit.test")
public class PersonRepositoryTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get("/persons")).andExpect( status().isOk());
    }

    @Test
    public void testPost() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/persons")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content("{ \"firstName\" : \"John\", \"lastName\" : \"Borys\" }"))
        .andExpect( status().is(201))
        .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("Z" + content + "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");


        //.andDo(print())  //prints out request/response details to console
    }


}
