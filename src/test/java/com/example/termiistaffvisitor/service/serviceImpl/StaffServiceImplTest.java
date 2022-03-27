package com.example.termiistaffvisitor.service.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.termiistaffvisitor.model.Staff;
import com.example.termiistaffvisitor.repository.StaffRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StaffServiceImpl.class})
@ExtendWith(SpringExtension.class)
class StaffServiceImplTest {
    @MockBean
    private StaffRepository staffRepository;

    @Autowired
    private StaffServiceImpl staffServiceImpl;

    @Test
    void testFetchAllStaffs() {
        ArrayList<Staff> staffList = new ArrayList<>();
        when(this.staffRepository.findAll()).thenReturn(staffList);
        List<Staff> actualFetchAllStaffsResult = this.staffServiceImpl.fetchAllStaffs();
        assertSame(staffList, actualFetchAllStaffsResult);
        assertTrue(actualFetchAllStaffsResult.isEmpty());
        verify(this.staffRepository).findAll();
    }

    @Test
    void testSave() {
        Staff staff = new Staff();
        staff.setAddress("42 Main St");
        staff.setEmail_address("42 Main St");
        staff.setPhone_number("08097896578");
        staff.setStaff_id(1L);
        staff.setStaff_name("Ben");
        when(this.staffRepository.save(any())).thenReturn(staff);

        Staff staff1 = new Staff();
        staff1.setAddress("42 Main St");
        staff1.setEmail_address("42 Main St");
        staff1.setPhone_number("08097896578");
        staff1.setStaff_id(1L);
        staff1.setStaff_name("Ben");
        assertSame(staff, this.staffServiceImpl.save(staff1));
        verify(this.staffRepository).save(any());
    }

    @Test
    void testGetById() {
        Staff staff = new Staff();
        staff.setAddress("42 Main St");
        staff.setEmail_address("42 Main St");
        staff.setPhone_number("08097896578");
        staff.setStaff_id(1L);
        staff.setStaff_name("Ben");
        Optional<Staff> ofResult = Optional.of(staff);
        when(this.staffRepository.findById(any())).thenReturn(ofResult);
        assertSame(staff, this.staffServiceImpl.getById(123L));
        verify(this.staffRepository).findById(any());
    }
}

