package pl.edu.wszib.MyFreelancePal.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Event {

    private String title;

    private LocalDateTime start;

    private LocalDateTime end;

    private String color;


}
