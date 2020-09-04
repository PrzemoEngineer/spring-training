package pl.sda.springtraining.external.visits;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.springtraining.config.FacilityConfiguration;
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
    private final FacilityConfiguration facilityConfiguration;

    @Override
    public void create(Visit visit) {
        VisitEntity entity = VisitEntity.builder()
                .doctor(doctorRepository.getOne(visit.getDoctorId()))
                .hour(visit.getHour())
                .patient(patientRepository.getOne(visit.getPatientId()))
                .visitDate(visit.getDate())
                .build();

        if ( entity.getHour() >= facilityConfiguration.getOpeningHour()
                && entity.getHour() < facilityConfiguration.getClosingHour()) {
            visitRepository.save(entity);
        }
    }

    // jak ma wyglądać ta klasa
    // jak ma wyglądać JSON w metodzie post dodający wizytę
    // visyta ma mieć pola: "doctor" i "patient" czy "doctor_id" i "patient_id"
    // mamy nieogarnięte pola?? albo ja ich nie ogarniam.
    // jeśli podana godzina nie mieści się w godzianch otwracia to co wtedy??
    // powtórzyć api exception handler
    // i może to z facility - z application properties
}
