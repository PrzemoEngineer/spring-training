package pl.sda.springtraining.domain.visit;

import lombok.*;
import pl.sda.springtraining.web.validator.Hour;

import java.time.LocalDate;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Visit {

    private String roomNumber;
    @Hour
    private int hour;
    private LocalDate date;
    private int patientId;
    private int doctorId;
}
