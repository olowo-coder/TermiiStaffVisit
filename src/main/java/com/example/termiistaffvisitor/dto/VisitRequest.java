package com.example.termiistaffvisitor.dto;

import com.example.termiistaffvisitor.model.Staff;
import com.example.termiistaffvisitor.model.Visitor;
import lombok.Data;

import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
public class VisitRequest {

    private Long staff_id;

    private Long visitor_id;

    private String date_of_visit;

    private String reason_for_visit;
}
