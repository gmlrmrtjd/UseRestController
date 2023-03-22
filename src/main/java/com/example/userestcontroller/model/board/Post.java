package com.example.userestcontroller.model.board;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POSTS_SEQ")
    @SequenceGenerator(name = "POSTS_SEQ", sequenceName = "POSTS_SEQ", allocationSize = 1)
    private Long id;
    private String title;
    private String content;
}
