package com.ziggle.controller;

import com.ziggle.services.MongoDBJDBC;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring-context-mvc.xml", "classpath:spring-context.xml"})
public class HelloControllerTest {

    @Autowired
    private WebApplicationContext wac;

    MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void testServices() throws Exception {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.request(HttpMethod.GET, "/hello/success");
        mockMvc.perform(mockHttpServletRequestBuilder).andExpect(status().isOk())
                .andDo(print());

        System.out.println("alfjsf");

    }

    @Test
    public void returnSuccess() throws Exception {
        MongoDBJDBC d = new MongoDBJDBC();
        d.GetClient();
    }


    @Test
    public void getHeaderTest() throws Exception {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.request(HttpMethod.GET, "/hello/findUser/1");
        mockMvc.perform(mockHttpServletRequestBuilder).andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void getHeaderCookieTest() throws Exception {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.request(HttpMethod.GET, "/hello/findHeader");
        mockMvc.perform(mockHttpServletRequestBuilder).andExpect(status().isOk())
                .andDo(print());
    }


}