package com.graphqlmongospring.hackernews.resolver;

import com.graphqlmongospring.hackernews.model.Link;
import com.graphqlmongospring.hackernews.repository.LinkRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class LinkResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private LinkRepository linkRepository;

    public String testingApp(){
        return "Test in progress...";
    }

    public List<Link> allLinks() {
        return linkRepository.findAll();
    }

    public Link createLink(String url, String description) {
        Link newLink = new Link(url, description);
        linkRepository.save(newLink);
        return newLink;
    }

}