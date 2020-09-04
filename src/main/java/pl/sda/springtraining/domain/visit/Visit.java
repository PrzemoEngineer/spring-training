package pl.sda.springtraining.domain.visit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visit {
    private String roomNumber;
    private int hour;
    private LocalDate date;
    private Integer patientId;
    private Integer doctorId;
}
