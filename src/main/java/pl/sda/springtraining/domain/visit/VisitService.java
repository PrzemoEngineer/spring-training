package pl.sda.springtraining.domain.visit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;

    public void create(Visit visit) {
        visitRepository.create(visit);
    }

}
