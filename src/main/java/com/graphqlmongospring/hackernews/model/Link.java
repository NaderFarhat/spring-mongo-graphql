package com.graphqlmongospring.hackernews.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
//import org.springframework.data.mongodb.core.mapping.Document;


//@Document(collection = "authors")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Document(collection = "Link")
public class Link {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;

    private String url;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public Link(String url, String description) {
        this.url = url;
        this.description = description;
    }
}
