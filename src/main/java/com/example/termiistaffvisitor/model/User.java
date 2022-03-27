package com.example.termiistaffvisitor.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long user_id;
    @Column(unique = true, nullable = false)
    private String username;
    private String password;
}
