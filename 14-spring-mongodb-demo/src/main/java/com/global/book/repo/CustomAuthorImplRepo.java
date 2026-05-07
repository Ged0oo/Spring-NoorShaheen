package com.global.book.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.mongodb.client.result.UpdateResult;
import com.global.book.entity.Author;

@Repository
public class CustomAuthorImplRepo implements CustomeAuthorRepo {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void updateEmail(String name, String email, String phone) {
        Query query = new Query(Criteria.where("email").is(email));

        Update update = new Update();
        update.set("name", name);
        update.set("email", email);
        update.set("phone", phone);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Author.class);

        if (result.getMatchedCount() == 0) {
            System.out.println("Update failed: No author found with email: " + email);
        } else {
            System.out.println("Successfully updated");
        }
    }
}