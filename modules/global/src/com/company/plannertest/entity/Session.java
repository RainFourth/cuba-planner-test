package com.company.plannertest.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@NamePattern("%s|topic")
@Table(name = "PLANNERTEST_SESSION")
@Entity(name = "plannertest_Session")
public class Session extends StandardEntity {
    private static final long serialVersionUID = 6285274969287847126L;

    @NotNull
    @Column(name = "TOPIC", nullable = false)
    private String topic;

    @NotNull
    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SPEAKER_ID")
    private Speaker speaker;

    @NotNull
    @Positive
    @Column(name = "DURATION", nullable = false)
    private Integer duration;

    @Lob
    @Column(name = "DESCRIPTION")
    private String description;




    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    @Transient // создание вычисляемого поля
    @MetaProperty(related = {"startDate", "duration"}) // создание вычисляемого поля
    public LocalDateTime getEndDate() {
        return startDate!=null && duration!=null ? startDate.plusHours(duration) : null;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}