package com.ziggle.controller;

import com.ziggle.services.MongoDBJDBC;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:"})
public class HelloControllerTest {

    @Resource
    WebAppConfiguration ctx;


    MockMvc mockMvc;
    @Test
    public void testServices() throws Exception {


    }

    @Test
    public void returnSuccess() throws Exception {
        MongoDBJDBC d = new MongoDBJDBC();
        d.GetClient();
    }

}