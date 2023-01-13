package com.lucas.findmyart.resource.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter @Setter
public class ScheduleForm {

    @NotEmpty(message = "The event name must not be empty")
    private String eventName;

    @NotNull(message = "the band username cannot be null here")
    private String bandUsername;

    @NotNull(message = "the pub username cannot be null here")
    private String pubUsername;

    private String momentOfEvent;
    private LocalDateTime momentOfScheduleRegistered;

    public ScheduleForm() {
        momentOfScheduleRegistered = LocalDateTime.now();
    }

}
