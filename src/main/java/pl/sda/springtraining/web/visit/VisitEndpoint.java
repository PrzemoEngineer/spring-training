package pl.sda.springtraining.web.visit;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.springtraining.domain.visit.Visit;
import pl.sda.springtraining.domain.visit.VisitService;

import javax.validation.Valid;

@RestController
@RequestMapping("/visit")
@RequiredArgsConstructor
public class VisitEndpoint {

    private final VisitService visitService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createVisit(@RequestBody @Valid Visit visit) {
        visitService.create(visit);
    }

//    {"roomNumber": "1",
//    "visitDate" : "2020-09-10",
//        hour
//        patient
//        doctor
//    }
}
