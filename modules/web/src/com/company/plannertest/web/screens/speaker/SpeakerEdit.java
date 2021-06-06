package com.company.plannertest.web.screens.speaker;

import com.haulmont.cuba.gui.screen.*;
import com.company.plannertest.entity.Speaker;

@UiController("plannertest_Speaker.edit")
@UiDescriptor("speaker-edit.xml")
@EditedEntityContainer("speakerDc")
@LoadDataBeforeShow
public class SpeakerEdit extends StandardEditor<Speaker> {
}