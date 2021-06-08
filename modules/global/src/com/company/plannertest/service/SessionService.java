package com.company.plannertest.service;

import com.company.plannertest.entity.Session;

import java.time.LocalDateTime;

public interface SessionService {
    String NAME = "plannertest_SessionService";

    Session rescheduleSession(Session session, LocalDateTime newStartDate);
}