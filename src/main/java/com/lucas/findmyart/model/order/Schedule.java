package com.lucas.findmyart.model.order;

import com.lucas.findmyart.model.entities.Band;
import com.lucas.findmyart.model.entities.Pub;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "schedules")
@Getter @Setter @NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventName;

    private LocalDateTime momentOfScheduleRegistered;

    private LocalDateTime momentOfEvent;

    private boolean active;

    @ManyToOne
    @JoinColumn(name = "band_id")
    private Band band;

    @ManyToOne
    @JoinColumn(name = "pub_id")
    private Pub pub;

}
