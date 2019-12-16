package com.example.baike;

import com.example.baike.controller.LoginController;
import com.example.baike.controller.RegisterController;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class BaikeApplicationTests {
	private MockMvc mvc;
	private MockHttpSession session;

	@Autowired
	private LoginController loginController;
	@Autowired
	private RegisterController registerController;

	@BeforeEach
	public void setup(){
		mvc = MockMvcBuilders.standaloneSetup(loginController).build();
	}

	RequestBuilder request = null;
	@Test
	void loginTest() throws Exception {
		String json = "{\"account\":\"550847434@qq.com\", \"password\":\"abcd1234\"}";
		request = post("/api/login")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(json.getBytes()); //传json参数
		mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.message").value("success"));
	}

	@Test
	@Transactional
	void registerTest() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(registerController).build();
		String json = "{\"account\":\"555@qq.com\", \"password\":\"abcd1234\", \"nickName\":\"me\"}";
		request = post("/api/register")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(json.getBytes()); //传json参数
		mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.message").value("success"));
	}

}
