package com.company.plannertest.web.screens.session;

import com.haulmont.cuba.gui.screen.*;
import com.company.plannertest.entity.Session;

@UiController("plannertest_Session.browse")
@UiDescriptor("session-browse.xml")
@LookupComponent("sessionsTable")
@LoadDataBeforeShow
public class SessionBrowse extends StandardLookup<Session> {
}