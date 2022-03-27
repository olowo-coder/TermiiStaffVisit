package com.example.termiistaffvisitor.service.serviceImpl;

import com.example.termiistaffvisitor.model.Staff;
import com.example.termiistaffvisitor.repository.StaffRepository;
import com.example.termiistaffvisitor.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;

    @Autowired
    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public List<Staff> fetchAllStaffs() {
        return staffRepository.findAll();
    }

    @Override
    public Staff save(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Staff getById(Long staffId) {
        return staffRepository.findById(staffId).orElse(null);
    }
}
