package com.example.termiistaffvisitor.service.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.termiistaffvisitor.model.Visitor;
import com.example.termiistaffvisitor.repository.VisitorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {VisitorServiceImpl.class})
@ExtendWith(SpringExtension.class)
class VisitorServiceImplTest {
    @MockBean
    private VisitorRepository visitorRepository;

    @Autowired
    private VisitorServiceImpl visitorServiceImpl;

    @Test
    void testFetchVisitors() {
        ArrayList<Visitor> visitorList = new ArrayList<>();
        when(this.visitorRepository.findAll()).thenReturn(visitorList);
        List<Visitor> actualFetchVisitorsResult = this.visitorServiceImpl.fetchVisitors();
        assertSame(visitorList, actualFetchVisitorsResult);
        assertTrue(actualFetchVisitorsResult.isEmpty());
        verify(this.visitorRepository).findAll();
    }

    @Test
    void testSave() {
        Visitor visitor = new Visitor();
        visitor.setAddress("42 Main St");
        visitor.setEmail_address("42 Main St");
        visitor.setPhone_number("09078675432");
        visitor.setVisitor_id(1L);
        visitor.setVisitor_name("abraham");
        when(this.visitorRepository.save(any())).thenReturn(visitor);

        Visitor visitor1 = new Visitor();
        visitor1.setAddress("42 Main St");
        visitor1.setEmail_address("42 Main St");
        visitor1.setPhone_number("09078675432");
        visitor1.setVisitor_id(1L);
        visitor1.setVisitor_name("abraham");
        assertSame(visitor, this.visitorServiceImpl.save(visitor1));
        verify(this.visitorRepository).save(any());
    }

    @Test
    void testGetById() {
        Visitor visitor = new Visitor();
        visitor.setAddress("42 Main St");
        visitor.setEmail_address("42 Main St");
        visitor.setPhone_number("09078675432");
        visitor.setVisitor_id(1L);
        visitor.setVisitor_name("abraham");
        Optional<Visitor> ofResult = Optional.of(visitor);
        when(this.visitorRepository.findById(any())).thenReturn(ofResult);
        assertSame(visitor, this.visitorServiceImpl.getById(123L));
        verify(this.visitorRepository).findById(any());
    }
}

