package com.company.plannertest.web.screens.speaker;

import com.haulmont.cuba.gui.screen.*;
import com.company.plannertest.entity.Speaker;

@UiController("plannertest_Speaker.browse")
@UiDescriptor("speaker-browse.xml")
@LookupComponent("speakersTable")
@LoadDataBeforeShow
public class SpeakerBrowse extends StandardLookup<Speaker> {
}