package com.example.termiistaffvisitor.service;

import com.example.termiistaffvisitor.dto.LogVisitDto;
import com.example.termiistaffvisitor.dto.VisitRequest;

public interface LogVisitService {

    LogVisitDto logVisit(VisitRequest VisitRequest);
}
