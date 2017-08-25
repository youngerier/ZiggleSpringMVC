package com.ziggle.services.impl;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.ziggle.services.IMongoClientService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MongoClientServiceImpl implements IMongoClientService {
    @Scope
    public MongoClient getMongoClient() {
        String user = "root";
        String database = "admin";
        char[] password = new char[]{'w', 'a', 'n', 'g', 'p', 'i', 'n', 'g'};
        MongoCredential credential = MongoCredential.createCredential(user, database, password);
        MongoClientOptions options = MongoClientOptions.builder().sslEnabled(false).build();
        return new MongoClient(new ServerAddress("192.168.101.190", 27017),
                Arrays.asList(credential),
                options);
    }
}
