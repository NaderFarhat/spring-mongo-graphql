package com.graphqlmongospring.hackernews.repository;

import com.graphqlmongospring.hackernews.model.Link;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface LinkRepository extends MongoRepository<Link, String> {
}
