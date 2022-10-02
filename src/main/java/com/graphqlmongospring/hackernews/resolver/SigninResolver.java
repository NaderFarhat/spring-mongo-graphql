package com.graphqlmongospring.hackernews.resolver;

import com.graphqlmongospring.hackernews.input.AuthData;
import com.graphqlmongospring.hackernews.model.User;
import com.graphqlmongospring.hackernews.payload.SigninPayload;
import com.graphqlmongospring.hackernews.repository.LinkRepository;
import com.graphqlmongospring.hackernews.repository.UserRepository;
import graphql.GraphQLException;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;

public class SigninResolver implements GraphQLResolver<SigninPayload> {

    @Autowired
    private UserRepository userRepository;

    public User user(SigninPayload payload) {
        return payload.getUser();
    }

    public SigninPayload signinUser(AuthData auth) throws IllegalAccessException {
        User user = userRepository.findByEmail(auth.getEmail());
        if (user.getPassword().equals(auth.getPassword())) {
            return new SigninPayload(user.getId(), user);
        }
        throw new GraphQLException("Invalid credentials");
    }
}
