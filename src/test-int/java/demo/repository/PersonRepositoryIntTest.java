package demo.repository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@SpringBootTest         //Instanciates MockMvc
@AutoConfigureMockMvc   // MockMvc AutoConfiguration Eliminates need for Builder
@ActiveProfiles("unit.test")
public class PersonRepositoryIntTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPersonsGet() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/persons"))
                .andExpect( status().isOk())
                //.andExpect(MockMvcResultMatchers.jsonPath("$._embedded",org.hamcrest.Matchers.is("{\"persons\"") ))
                .andReturn();
        String actualJson = mvcResult.getResponse().getContentAsString();
        Assert.assertTrue(actualJson.contains("Banana"));
//        String outJSON = "{\n" +
//                "  \"_embedded\" : {\n" + "    \"persons\" : [ ]\n" + "  },\n" +
//                "  \"_links\" : {\n" + "    \"self\" : {\n" +
//                "      \"href\" : \"http://localhost/persons\"\n" + "    },\n" + "    \"profile\" : {\n" +
//                "      \"href\" : \"http://localhost/profile/persons\"\n" + "    }\n" + "  }\n" + "}";
//        assertEquals(outJSON, mvcResult.getResponse().getContentAsString());
//        JSONAssert.assertEquals(outJSON,mvcResult.getResponse().getContentAsString(), JSONCompareMode.LENIENT);
    }

    @Test
    public void testPersonsPost() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/persons")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content("{ \"firstName\" : \"John\", \"lastName\" : \"Borys\" }"))
        .andExpect( status().is(201))
        .andDo(print())
        .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
    }


}
