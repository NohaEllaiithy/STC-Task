package com.stc.calendar_conflict_optimizer.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
@Setter
@Getter
public class FreeSlot {
    private ZonedDateTime start;
    private ZonedDateTime end;

    public FreeSlot(ZonedDateTime start, ZonedDateTime end) {
        this.start = start;
        this.end = end;
    }
}
