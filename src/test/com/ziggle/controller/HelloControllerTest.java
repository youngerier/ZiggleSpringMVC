package com.ziggle.controller;

import com.ziggle.services.MongoDBJDBC;
import org.junit.Test;

import static org.junit.Assert.*;

public class HelloControllerTest {
    @Test
    public void testServices() throws Exception {


    }

    @Test
    public void returnSuccess() throws Exception {
        MongoDBJDBC d = new MongoDBJDBC();
        d.GetClient();
    }

}