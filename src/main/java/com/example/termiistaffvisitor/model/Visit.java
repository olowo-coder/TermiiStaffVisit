package com.example.termiistaffvisitor.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Visit{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long visit_id;

    @ManyToOne
    private Staff staff;

    @ManyToOne
    private Visitor visitor;

    private String date_of_visit;

    private String reason_for_visit;
}
