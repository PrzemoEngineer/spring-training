package pl.sda.springtraining.domain.visit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.springtraining.web.visit.model.UpdateVisitRq;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;

    public void scheduleVisit(Visit visit) {
        //sprawddzenie godzin

        //sprawdzić czy lekarz nie ma wizyty - bo to walidacje więc logika biznesowa - więc w domain
        visitRepository.create(visit);
    }

    public void updateVisit(UpdateVisitRq rq) {
        Optional<Visit> visit = visitRepository.findById(rq.getId());
        visit.ifPresent(existingVisit ->{
            existingVisit.updateVisit(rq);
            //walidacje jak w create
            visitRepository.update(existingVisit);
        }
        );
    };

}
