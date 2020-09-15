package pl.sda.springtraining.web.visit.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateVisitRq {
    private int id;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate visitDate;
    private int hour;
}
