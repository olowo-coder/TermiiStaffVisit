package com.example.termiistaffvisitor.service.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.termiistaffvisitor.dto.VisitRequest;
import com.example.termiistaffvisitor.model.Staff;
import com.example.termiistaffvisitor.model.Visit;
import com.example.termiistaffvisitor.model.Visitor;
import com.example.termiistaffvisitor.repository.StaffRepository;
import com.example.termiistaffvisitor.repository.VisitRepository;
import com.example.termiistaffvisitor.repository.VisitorRepository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {LogVisitServiceImpl.class})
@ExtendWith(SpringExtension.class)
class LogVisitServiceImplTest {
    @Autowired
    private LogVisitServiceImpl logVisitServiceImpl;

    @MockBean
    private StaffRepository staffRepository;

    @MockBean
    private VisitRepository visitRepository;

    @MockBean
    private VisitorRepository visitorRepository;

    @Test
    void testLogVisit() {
        Visitor visitor = new Visitor();
        visitor.setAddress("42 Main St");
        visitor.setEmail_address("42 Main St");
        visitor.setPhone_number("4105551212");
        visitor.setVisitor_id(1L);
        visitor.setVisitor_name("Visitor name");
        Optional<Visitor> ofResult = Optional.of(visitor);
        when(this.visitorRepository.findById((Long) any())).thenReturn(ofResult);

        Staff staff = new Staff();
        staff.setAddress("42 Main St");
        staff.setEmail_address("42 Main St");
        staff.setPhone_number("4105551212");
        staff.setStaff_id(1L);
        staff.setStaff_name("Staff name");

        Visitor visitor1 = new Visitor();
        visitor1.setAddress("42 Main St");
        visitor1.setEmail_address("42 Main St");
        visitor1.setPhone_number("4105551212");
        visitor1.setVisitor_id(1L);
        visitor1.setVisitor_name("Visitor name");

        Visit visit = new Visit();
        visit.setDate_of_visit("2020-03-01");
        visit.setReason_for_visit("Just cause");
        visit.setStaff(staff);
        visit.setVisit_id(1L);
        visit.setVisitor(visitor1);
        when(this.visitRepository.save((Visit) any())).thenReturn(visit);

        Staff staff1 = new Staff();
        staff1.setAddress("42 Main St");
        staff1.setEmail_address("42 Main St");
        staff1.setPhone_number("4105551212");
        staff1.setStaff_id(1L);
        staff1.setStaff_name("Staff name");
        Optional<Staff> ofResult1 = Optional.of(staff1);
        when(this.staffRepository.findById((Long) any())).thenReturn(ofResult1);

        VisitRequest visitRequest = new VisitRequest();
        visitRequest.setDate_of_visit("2020-03-01");
        visitRequest.setReason_for_visit("Just cause");
        visitRequest.setStaff_id(1L);
        visitRequest.setVisitor_id(1L);
        assertEquals("Logged visit successfully", this.logVisitServiceImpl.logVisit(visitRequest).getStatus());
        verify(this.visitorRepository).findById(any());
        verify(this.visitRepository).save(any());
        verify(this.staffRepository).findById(any());
    }

    @Test
    void testLogVisit2() {
        Visitor visitor = new Visitor();
        visitor.setAddress("42 Main St");
        visitor.setEmail_address("42 Main St");
        visitor.setPhone_number("4105551212");
        visitor.setVisitor_id(1L);
        visitor.setVisitor_name("Visitor name");
        Optional<Visitor> ofResult = Optional.of(visitor);
        when(this.visitorRepository.findById((Long) any())).thenReturn(ofResult);
        when(this.visitRepository.save((Visit) any())).thenThrow(new IllegalStateException("foo"));

        Staff staff = new Staff();
        staff.setAddress("42 Main St");
        staff.setEmail_address("42 Main St");
        staff.setPhone_number("4105551212");
        staff.setStaff_id(1L);
        staff.setStaff_name("Staff name");
        Optional<Staff> ofResult1 = Optional.of(staff);
        when(this.staffRepository.findById((Long) any())).thenReturn(ofResult1);

        VisitRequest visitRequest = new VisitRequest();
        visitRequest.setDate_of_visit("2020-03-01");
        visitRequest.setReason_for_visit("Just cause");
        visitRequest.setStaff_id(1L);
        visitRequest.setVisitor_id(1L);
        assertThrows(IllegalStateException.class, () -> this.logVisitServiceImpl.logVisit(visitRequest));
        verify(this.visitorRepository).findById(any());
        verify(this.visitRepository).save(any());
        verify(this.staffRepository).findById(any());
    }

}

