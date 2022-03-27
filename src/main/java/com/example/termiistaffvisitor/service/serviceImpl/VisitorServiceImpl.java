package com.example.termiistaffvisitor.service.serviceImpl;

import com.example.termiistaffvisitor.model.Visitor;
import com.example.termiistaffvisitor.repository.VisitorRepository;
import com.example.termiistaffvisitor.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorServiceImpl implements VisitorService {
    private final VisitorRepository visitorRepository;

    @Autowired
    public VisitorServiceImpl(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @Override
    public List<Visitor> fetchVisitors() {
        return visitorRepository.findAll();
    }

    @Override
    public Visitor save(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    @Override
    public Visitor getById(Long visitorId) {
        return visitorRepository.findById(visitorId).orElse(null);
    }
}
