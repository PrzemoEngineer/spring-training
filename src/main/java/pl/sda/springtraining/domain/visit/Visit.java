package pl.sda.springtraining.domain.visit;

import lombok.*;
import pl.sda.springtraining.web.validator.Hour;
import pl.sda.springtraining.web.visit.model.UpdateVisitRq;

import java.time.LocalDate;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Visit {
    private Integer id;
    private String roomNumber;
    private LocalDate visitDate;
    @Hour
    private int hour;
    private int patient;
    private int doctor;

    public void updateVisit(UpdateVisitRq rq) {
        this.visitDate = rq.getVisitDate();
        this.hour = rq.getHour();
    }
}
