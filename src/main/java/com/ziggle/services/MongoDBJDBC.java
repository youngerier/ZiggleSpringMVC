package com.ziggle.services;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;

public class MongoDBJDBC {
    public static Document doc = new Document("name", "MongoDB")
            .append("type", "database")
            .append("count", 1)
            .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
            .append("info", new Document("x", 203).append("y", 102));

    public static void GetClient() {
        MongoClient client = new MongoClient(new ServerAddress("127.0.0.1", 27017));
        MongoDatabase db = client.getDatabase("MyDb");
        MongoCollection<Document> collection = db.getCollection("test");
        collection.insertOne(doc);
    }
}
