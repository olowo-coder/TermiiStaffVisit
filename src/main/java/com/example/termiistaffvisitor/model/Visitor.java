package com.example.termiistaffvisitor.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Visitor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long visitor_id;
    private String visitor_name;
    private String phone_number;
    @Column(unique = true, nullable = false)
    private String email_address;
    private String address;
}
