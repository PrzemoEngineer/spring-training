package pl.sda.springtraining.domain.patient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository repository; // loose coupling - poczytać

//    @Autowired //- ten sam efekt co adnotacja @RequiredArgsConstructor przy klasie
//    public PatientService(PatientRepository repository) {
//        this.repository = repository;
//    }

    public void create(Patient patient) {
        repository.getByInsuranceNo(patient.getInsuranceNo())
                .ifPresent(pat ->
                    {throw new IllegalStateException("Patient with same insuranceNo already exists");});

        repository.create(patient);
    }

    public void update (Patient patient) {
        repository.getByInsuranceNo(patient.getInsuranceNo())
                .filter(pat -> !pat.getId().equals(patient.getId()))
                .ifPresent(pat ->
                {throw new IllegalStateException("Patient with same insuranceNo already exists");});

        repository.update(patient);
    }

    public Patient getOne(Integer id) {
        return repository.getDoctorByID(id)
                .orElseThrow(() -> new IllegalArgumentException("Patient with given id not exists"));
    }

    public List<Patient> getAll() {
        return repository.getAll();
    }

    public void delete(int id) {
        repository.delete(id);
    }
}
