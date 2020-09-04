package pl.sda.springtraining.external.doctor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.springtraining.domain.doctor.Doctor;
import pl.sda.springtraining.domain.doctor.DoctorRepository;
import pl.sda.springtraining.web.doctor.SearchParams;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DatabaseDoctorRepository implements DoctorRepository {


    private final JpaDoctorRepository jpaDoctorRepository;

    @Override
    public List<Doctor> findByParams(SearchParams searchParams) {
        return jpaDoctorRepository.findWithSearchParams(searchParams)
                .stream()
                .map(mapToDomain())
                .collect(Collectors.toList());
    }

    @Override
    public void create(Doctor doctor) {
        DoctorEntity entity = DoctorEntity.builder().name(doctor.getName())
                            .surname(doctor.getSurname())
                            .specialization(doctor.getSpecialization())
                            .hireDate(LocalDate.now())
                            .hourRate(doctor.getHourRate())
                            .build();

        jpaDoctorRepository.save(entity);
    }

    @Override
    public void update(Doctor doctor) {
        jpaDoctorRepository.findById(doctor.getId())
                .ifPresent(ent -> {
                    ent.updateFromDomain(doctor);
                    jpaDoctorRepository.save(ent);
                });
    }

    @Override
    public void delete(int id) {
        jpaDoctorRepository.deleteById(id);
    }

    @Override
    public Optional<Doctor> getOne(int id) {
        return jpaDoctorRepository.findById(id).map(mapToDomain());
    }


    @Override
    public List<Doctor> getAll() {
        return jpaDoctorRepository
                .findAll()
                .stream()
                .map(mapToDomain())
                .collect(Collectors.toList());
    }

    private Function<DoctorEntity, Doctor> mapToDomain() {

        return ent -> Doctor.builder()
                .id(ent.getId())
                .name(ent.getName())
                .surname(ent.getSurname())
                .hourRate(ent.getHourRate())
                .hireDate(ent.getHireDate())
                .specialization(ent.getSpecialization())
                .build();
    }
}
