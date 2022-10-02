package com.graphqlmongospring.hackernews.resolver;

import com.graphqlmongospring.hackernews.input.AuthData;
import com.graphqlmongospring.hackernews.model.Link;
import com.graphqlmongospring.hackernews.model.User;
import com.graphqlmongospring.hackernews.payload.SigninPayload;
import com.graphqlmongospring.hackernews.repository.LinkRepository;
import com.graphqlmongospring.hackernews.repository.UserRepository;
import graphql.GraphQLException;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final LinkRepository linkRepository;
    private final UserRepository userRepository;

    public UserResolver(LinkRepository linkRepository, UserRepository userRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
    }

//    public Link createLink(String url, String description) {
//        Link newLink = new Link(url, description);
//        linkRepository.save(newLink);
//        return newLink;
//    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public User createUser(String name, AuthData auth) {
        User newUser = new User(name, auth.getEmail(), auth.getPassword());
        userRepository.save(newUser);
        return newUser;
    }

    public SigninPayload signinUser(AuthData auth) throws IllegalAccessException {
        User user = userRepository.findByEmail(auth.getEmail());
        if (user.getPassword().equals(auth.getPassword())) {
            return new SigninPayload(user.getId(), user);
        }
        throw new GraphQLException("Invalid credentials");
    }
}
