package com.company.plannertest.web.screens.session;

import com.company.plannertest.service.SessionService;
import com.haulmont.cuba.gui.components.Calendar;
import com.haulmont.cuba.gui.components.EditorScreenFacet;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.plannertest.entity.Session;

import javax.inject.Inject;
import java.time.LocalDateTime;

@UiController("plannertest_Session.browse")
@UiDescriptor("session-browse.xml")
@LookupComponent("sessionsTable")
@LoadDataBeforeShow
public class SessionBrowse extends StandardLookup<Session> {
    @Inject
    private EditorScreenFacet<Session, SessionEdit> sessionEditDialog;

    @Inject
    private SessionService sessionService;

    @Inject
    private CollectionContainer<Session> sessionsDc;

    @Subscribe("sessionCalendar")
    public void onSessionCalendarCalendarEventClick(Calendar.CalendarEventClickEvent<LocalDateTime> event) {
        sessionEditDialog.setEntityProvider(() -> (Session) event.getEntity());
        sessionEditDialog.show();
    }

    @Subscribe("sessionCalendar")
    public void onSessionCalendarCalendarEventMove(Calendar.CalendarEventMoveEvent<LocalDateTime> event) {
        Session session = sessionService.rescheduleSession((Session) event.getEntity(), event.getNewStart());
        sessionsDc.replaceItem(session);
    }
}