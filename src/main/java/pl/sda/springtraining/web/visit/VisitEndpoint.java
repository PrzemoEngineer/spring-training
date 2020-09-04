package pl.sda.springtraining.web.visit;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.springtraining.domain.visit.Visit;
import pl.sda.springtraining.domain.visit.VisitService;

@RestController
@RequestMapping("/visit")
@RequiredArgsConstructor
public class VisitEndpoint {

    private final VisitService visitService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createVisit(@RequestBody Visit visit) {
        visitService.create(visit);
    }
}