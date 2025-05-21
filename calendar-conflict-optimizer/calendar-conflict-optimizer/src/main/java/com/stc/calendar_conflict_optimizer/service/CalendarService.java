package com.stc.calendar_conflict_optimizer.service;

import com.stc.calendar_conflict_optimizer.dto.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CalendarService {
    public CalendarResponse process(CalendarRequest request) {
        List<EventRequestDTO> events = request.getEvents();
        ZoneId zoneId = ZoneId.of(request.getTimeZone());

        // Convert working hours to ZonedDateTime range
        LocalDate date = ZonedDateTime.parse(events.get(0).getStartTime()).toLocalDate();
        ZonedDateTime workStart = ZonedDateTime.of(date, LocalTime.parse(request.getWorkingHours().getStart()), zoneId);
        ZonedDateTime workEnd = ZonedDateTime.of(date, LocalTime.parse(request.getWorkingHours().getEnd()), zoneId);

        events.sort(Comparator.comparing(e -> ZonedDateTime.parse(e.getStartTime())));

        List<ConflictSlot> conflicts = new ArrayList<>();
        List<FreeSlot> freeSlots = new ArrayList<>();

        ZonedDateTime lastEnd = workStart;

        for (int i = 0; i < events.size(); i++) {
            EventRequestDTO current = events.get(i);
            ZonedDateTime currentStart = ZonedDateTime.parse(current.getStartTime());
            ZonedDateTime currentEnd = ZonedDateTime.parse(current.getEndTime());

            // Free slot before current event
            if (lastEnd.isBefore(currentStart)) {
                freeSlots.add(new FreeSlot(lastEnd, currentStart));
            }

            // Check conflicts
            for (int j = i + 1; j < events.size(); j++) {
                ZonedDateTime nextStart = ZonedDateTime.parse(events.get(j).getStartTime());
                ZonedDateTime nextEnd = ZonedDateTime.parse(events.get(j).getEndTime());

                if (currentEnd.isAfter(nextStart)) {
                    ZonedDateTime overlapStart = nextStart.isAfter(currentStart) ? nextStart : currentStart;
                    ZonedDateTime overlapEnd = currentEnd.isBefore(nextEnd) ? currentEnd : nextEnd;

                    conflicts.add(new ConflictSlot(current.getTitle(), events.get(j).getTitle(), overlapStart, overlapEnd));
                } else {
                    break;
                }
            }

            lastEnd = currentEnd.isAfter(lastEnd) ? currentEnd : lastEnd;
        }

        // Free slot after last event
        if (lastEnd.isBefore(workEnd)) {
            freeSlots.add(new FreeSlot(lastEnd, workEnd));
        }

        return new CalendarResponse(conflicts, freeSlots);
    }
}
