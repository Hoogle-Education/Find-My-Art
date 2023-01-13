package com.lucas.findmyart.service;

import com.lucas.findmyart.model.entities.Band;
import com.lucas.findmyart.model.entities.Pub;
import com.lucas.findmyart.model.order.Schedule;
import com.lucas.findmyart.model.user.User;
import com.lucas.findmyart.repository.BandRepository;
import com.lucas.findmyart.repository.PubRepository;
import com.lucas.findmyart.repository.ScheduleRepository;
import com.lucas.findmyart.resource.form.ScheduleForm;
import com.lucas.findmyart.service.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.*;

@Service
@AllArgsConstructor
public class ScheduleService {

    private BandRepository bandRepository;
    private PubRepository pubRepository;

    private ScheduleRepository scheduleRepository;

    private Schedule toSchedule(ScheduleForm scheduleForm)
            throws UserNotFoundException {
        Schedule schedule = new Schedule();
        Band band = bandRepository
                .findByUsername(scheduleForm.getBandUsername())
                        .orElseThrow(() -> new UserNotFoundException("Cannot find a band with this username"));

        Pub pub = pubRepository
                .findByUsername(scheduleForm.getPubUsername())
                .orElseThrow(() -> new UserNotFoundException("Cannot find a pub with this username"));

        schedule.setEventName(scheduleForm.getEventName());
        schedule.setBand(band);
        schedule.setPub(pub);
        schedule.setMomentOfScheduleRegistered(scheduleForm.getMomentOfScheduleRegistered());
        schedule.setActive(true);

        return schedule;
    }

    public List<Schedule> getEvents() {
        List<Schedule> schedules = scheduleRepository.findAll();
        schedules.sort(comparing(Schedule::getMomentOfEvent));
        return schedules;
    }

    public List<Schedule> getCanceledEvents() {
        return getEvents()
                .stream()
                .filter(e -> !e.isActive())
                .toList();
    }

    public List<Schedule> getActiveEvents() {
        return getEvents()
                .stream()
                .filter(Schedule::isActive)
                .toList();
    }

    public Schedule registerNewEvent(ScheduleForm scheduleForm)
            throws UserNotFoundException {
        Schedule scheduleToRegister = toSchedule(scheduleForm);
        return scheduleRepository.save(scheduleToRegister);
    }

    private Schedule cancelEvent() {
        // TODO
        return null;
    }

}
