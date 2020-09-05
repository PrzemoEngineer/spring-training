package pl.sda.springtraining.external.visits;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.springtraining.domain.visit.Visit;
import pl.sda.springtraining.domain.visit.VisitRepository;
import pl.sda.springtraining.external.doctor.JpaDoctorRepository;
import pl.sda.springtraining.external.patient.JpaPatientRepository;


@Component
@RequiredArgsConstructor
public class DatabaseVisitRepository implements VisitRepository {

    private final JpaVisitRepository visitRepository;
    private final JpaDoctorRepository doctorRepository;
    private final JpaPatientRepository patientRepository;


    @Override
    public void create(Visit visit) {
        VisitEntity entity = VisitEntity.builder()
                .doctor(doctorRepository.findById(visit.getDoctorId())
                        .orElseThrow(() -> new IllegalStateException("Doctor does not exists.")))
                .hour(visit.getHour())
                .patient(patientRepository.findById(visit.getPatientId())
                        .orElseThrow(() -> new IllegalStateException("Patient does not exists.")))
                .visitDate(visit.getDate())
                .roomNumber(visit.getRoomNumber())
                .build();

        visitRepository.save(entity);

    }

}
