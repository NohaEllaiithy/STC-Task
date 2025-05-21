package com.stc.calendar_conflict_optimizer.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
@Setter
@Getter
public class ConflictSlot {
    private String event1;
    private String event2;
    private ZonedDateTime overlapStart;
    private ZonedDateTime overlapEnd;

    public ConflictSlot(String event1, String event2, ZonedDateTime overlapStart, ZonedDateTime overlapEnd) {
        this.event1 = event1;
        this.event2 = event2;
        this.overlapStart = overlapStart;
        this.overlapEnd = overlapEnd;
    }
}
