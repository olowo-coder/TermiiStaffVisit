package com.example.termiistaffvisitor.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long staff_id;
    private String staff_name;
    private String phone_number;
    @Column(unique = true, nullable = false)
    private String email_address;
    private String address;
}
