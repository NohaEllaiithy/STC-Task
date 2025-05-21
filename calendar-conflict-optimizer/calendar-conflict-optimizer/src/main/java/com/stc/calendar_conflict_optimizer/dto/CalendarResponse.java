package com.stc.calendar_conflict_optimizer.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class CalendarResponse {
    private List<ConflictSlot> conflicts;
    private List<FreeSlot> freeSlots;

    public CalendarResponse(List<ConflictSlot> conflicts, List<FreeSlot> freeSlots) {
        this.conflicts = conflicts;
        this.freeSlots = freeSlots;
    }
}
