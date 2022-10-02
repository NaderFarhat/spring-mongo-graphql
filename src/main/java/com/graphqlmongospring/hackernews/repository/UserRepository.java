package com.graphqlmongospring.hackernews.repository;

import com.graphqlmongospring.hackernews.model.Link;
import com.graphqlmongospring.hackernews.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    public User findByEmail(String email);

//    public User findById(String id) {
//        Document doc = users.find(eq("_id", new ObjectId(id))).first();
//        return user(doc);
//    }

//    public User saveUser(User user) {
//        Document doc = new Document();
//        doc.append("name", user.getName());
//        doc.append("email", user.getEmail());
//        doc.append("password", user.getPassword());
//        users.insertOne(doc);
//        return new User(
//                doc.get("_id").toString(),
//                user.getName(),
//                user.getEmail(),
//                user.getPassword());
//    }

//    private User user(Document doc) {
//        if (doc == null) {
//            return null;
//        }
//        return new User(
//                doc.get("_id").toString(),
//                doc.getString("name"),
//                doc.getString("email"),
//                doc.getString("password"));
//    }
}
