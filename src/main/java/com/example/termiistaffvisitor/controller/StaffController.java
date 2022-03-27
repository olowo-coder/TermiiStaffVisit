package com.example.termiistaffvisitor.controller;

import com.example.termiistaffvisitor.model.Staff;
import com.example.termiistaffvisitor.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Staff> addStaff(@RequestBody final Staff staff){
        return ResponseEntity.ok(staffService.save(staff));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getById(@PathVariable final Long id){
        return ResponseEntity.ok(staffService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Staff>> fetchAll(){
        return ResponseEntity.ok(staffService.fetchAllStaffs());
    }
}
