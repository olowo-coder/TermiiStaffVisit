package com.example.termiistaffvisitor.service;

import com.example.termiistaffvisitor.model.Visitor;

import java.util.List;

public interface VisitorService{

    List<Visitor> fetchVisitors();

    Visitor save(Visitor visitor);

    Visitor getById(Long visitorId);
}
