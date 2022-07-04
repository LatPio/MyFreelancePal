package pl.edu.wszib.MyFreelancePal.util;


import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class Utilities {


    public Long workTimeInMinutes(LocalDateTime startTime, LocalDateTime endTime) throws NullPointerException{


        Long time = null;
        if (startTime != null & endTime != null) {
            Duration diffTimeMilliseconds = Duration.between(startTime, endTime);
            time = Math.abs(diffTimeMilliseconds.toMinutes());
            return time;
        } else {
            return time;
        }

    }


}
