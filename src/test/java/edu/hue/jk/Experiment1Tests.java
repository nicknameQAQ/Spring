package edu.hue.jk;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import edu.hue.jk.model.Emp;
import java.sql.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Experiment1Tests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Emp emp;

    @Test
    public void helloEndpointReturnsExpectedText() throws Exception {
        mockMvc.perform(get("/chapter1/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!"));
    }

    @Test
    public void employeePropertiesAreBoundFromYaml() {
        assertEquals(Integer.valueOf(12), emp.getEmpno());
        assertEquals("qwxu", emp.getEname());
        assertEquals(Date.valueOf("2020-12-15"), emp.getHiredate());
    }
}