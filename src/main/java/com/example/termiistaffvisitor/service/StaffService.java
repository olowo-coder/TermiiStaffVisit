package com.example.termiistaffvisitor.service;

import com.example.termiistaffvisitor.model.Staff;

import java.util.List;

public interface StaffService {

    List<Staff> fetchAllStaffs();

    Staff save(Staff staff);

    Staff getById(Long staffId);
}
