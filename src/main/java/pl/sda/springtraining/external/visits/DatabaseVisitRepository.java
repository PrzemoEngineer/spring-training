package pl.sda.springtraining.external.visits;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.springtraining.domain.visit.Visit;
import pl.sda.springtraining.domain.visit.VisitRepository;
import pl.sda.springtraining.external.doctor.JpaDoctorRepository;
import pl.sda.springtraining.external.patient.JpaPatientRepository;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class DatabaseVisitRepository implements VisitRepository {

    private final JpaVisitRepository visitRepository;
    private final JpaDoctorRepository doctorRepository;
    private final JpaPatientRepository patientRepository;


    @Override
    public void create(Visit visit) {
        VisitEntity entity = VisitEntity.builder()
                .doctor(doctorRepository.findById(visit.getDoctor())
                        .orElseThrow(() -> new IllegalStateException("Doctor does not exists.")))
                .hour(visit.getHour())
                .patient(patientRepository.findById(visit.getPatient())
                        .orElseThrow(() -> new IllegalStateException("Patient does not exists.")))
                .visitDate(visit.getVisitDate())
                .roomNumber(visit.getRoomNumber())
                .build();

        visitRepository.save(entity);

    }

    @Override
    public Optional<Visit> findById(int id) {
        return visitRepository.findById(id)
                .map(ent -> Visit.builder()
                    .id(ent.getId())
                    .doctor(ent.getDoctor().getId())
                    .patient(ent.getPatient().getId())
                    .roomNumber(ent.getRoomNumber())
                    .hour(ent.getHour())
                    .build());
    }

    @Override
    public void update(Visit visit) {
        VisitEntity entity = visitRepository.findById(visit.getId())
                .orElseThrow(() -> new IllegalStateException("Visit not exists"));
        entity.changeVisitTime(visit.getVisitDate(), visit.getHour());
    }

}
