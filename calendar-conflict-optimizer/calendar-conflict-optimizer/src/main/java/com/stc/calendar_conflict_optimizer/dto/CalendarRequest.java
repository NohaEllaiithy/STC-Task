package com.stc.calendar_conflict_optimizer.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CalendarRequest {
    private WorkingHours workingHours;
    private String timeZone;
    private List<EventRequestDTO> events;
}
