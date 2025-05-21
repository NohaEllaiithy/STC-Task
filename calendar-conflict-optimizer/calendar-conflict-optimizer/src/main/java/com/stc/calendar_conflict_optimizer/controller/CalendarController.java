package com.stc.calendar_conflict_optimizer.controller;

import com.stc.calendar_conflict_optimizer.dto.CalendarRequest;
import com.stc.calendar_conflict_optimizer.dto.CalendarResponse;
import com.stc.calendar_conflict_optimizer.service.CalendarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calendar")
public class CalendarController {
    private final CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @PostMapping("/optimizeConflict")
    public ResponseEntity<CalendarResponse> optimize(@RequestBody CalendarRequest request) {
        CalendarResponse response = calendarService.process(request);
        return ResponseEntity.ok(response);
    }
}
