package com.ziggle.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.ziggle.services.impl.MongoClientServiceImpl;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/mongo/*")
public class MongoController {
    private static final Logger logger = Logger.getLogger(MongoController.class);

    @Autowired
    private MongoClientServiceImpl mongoClient;

    @RequestMapping("/m")
    @ResponseBody
    public List<String> getMongo() {
        MongoCollection<Document> collection = mongoClient.getMongoClient().getDatabase("test").getCollection("articles");
        MongoCursor<Document> cursor = collection.find().iterator();
        List<String> s = new ArrayList<String>();
        try {
            while (cursor.hasNext()) {
//                Document doc = cursor.next();
                s.add(cursor.next().toJson());
//                System.out.println(cursor.next().toJson());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
        }
        return s;
    }
}
