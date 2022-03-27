package com.example.termiistaffvisitor.controller;

import com.example.termiistaffvisitor.dto.LogVisitDto;
import com.example.termiistaffvisitor.dto.VisitRequest;
import com.example.termiistaffvisitor.model.Visitor;
import com.example.termiistaffvisitor.service.LogVisitService;
import com.example.termiistaffvisitor.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VisitorController {

    private final VisitorService visitorService;
    private final LogVisitService logVisitService;

    @Autowired
    public VisitorController(VisitorService visitorService,
                             LogVisitService logVisitService) {
        this.visitorService = visitorService;
        this.logVisitService = logVisitService;
    }

    @PostMapping("/visitor")
    public ResponseEntity<Visitor> addVisitor(@RequestBody final Visitor visitor){
        return new ResponseEntity<>(visitorService.save(visitor), HttpStatus.CREATED);
    }

    @GetMapping("/visitors")
    public ResponseEntity<List<Visitor>> fetchVisitors(){
        return ResponseEntity.ok(visitorService.fetchVisitors());
    }

    @GetMapping("/visitor/{id}")
    public ResponseEntity<Visitor> getById(@PathVariable final Long id){
        return ResponseEntity.ok(visitorService.getById(id));
    }

    @PostMapping("/visit")
    public ResponseEntity<LogVisitDto> loggingVisit(@RequestBody final VisitRequest request){
        return ResponseEntity.ok(logVisitService.logVisit(request));
    }
}
