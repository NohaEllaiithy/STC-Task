package com.stc.calendar_conflict_optimizer.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EventRequestDTO {
    private String title;
    private String startTime;
    private String endTime;
}
