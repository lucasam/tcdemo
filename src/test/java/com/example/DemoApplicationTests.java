package com.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.example.controller.HelloController;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class DemoApplicationTests {


	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setupMock() {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
		webApplicationContext.getServletContext();
	}
    @Test
	public void newSimpleTest() throws Exception {
		mockMvc.perform(get("/").contentType("application/json")).andExpect(status().isOk());
	}
    @Test
	public void newSuperSimpleTest() throws Exception {
		HelloController c = new HelloController();
		c.testNonBlocker();
	}

}
