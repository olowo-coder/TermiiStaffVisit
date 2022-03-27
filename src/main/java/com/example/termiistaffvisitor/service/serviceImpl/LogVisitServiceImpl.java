package com.example.termiistaffvisitor.service.serviceImpl;

import com.example.termiistaffvisitor.dto.LogVisitDto;
import com.example.termiistaffvisitor.dto.VisitRequest;
import com.example.termiistaffvisitor.model.Staff;
import com.example.termiistaffvisitor.model.Visit;
import com.example.termiistaffvisitor.model.Visitor;
import com.example.termiistaffvisitor.repository.StaffRepository;
import com.example.termiistaffvisitor.repository.VisitRepository;
import com.example.termiistaffvisitor.repository.VisitorRepository;
import com.example.termiistaffvisitor.service.LogVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogVisitServiceImpl implements LogVisitService {
    private final VisitRepository visitRepository;
    private final StaffRepository staffRepository;
    private final VisitorRepository visitorRep;

    @Autowired
    public LogVisitServiceImpl(VisitRepository visitRepository,
                               StaffRepository staffRepository,
                               VisitorRepository visitorRep) {
        this.visitRepository = visitRepository;
        this.staffRepository = staffRepository;
        this.visitorRep = visitorRep;
    }

    @Override
    public LogVisitDto logVisit(VisitRequest request) {
        Visit visit = new Visit();
        Staff staff = staffRepository.findById(request.getStaff_id())
                .orElseThrow(() -> new IllegalStateException("staff does not exist"));

        Visitor visitor = visitorRep.findById(request.getVisitor_id())
                .orElseThrow(() -> new IllegalStateException("Visitor does not exist"));

        visit.setStaff(staff);
        visit.setVisitor(visitor);
        visit.setDate_of_visit(request.getDate_of_visit());
        visit.setReason_for_visit(request.getReason_for_visit());
        visitRepository.save(visit);
        return LogVisitDto.builder().status("Logged visit successfully").build();
    }
}
