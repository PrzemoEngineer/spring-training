package pl.sda.springtraining.domain.doctor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.springtraining.web.doctor.SearchParams;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public List<Doctor> findByParams(SearchParams searchParams) {
        return doctorRepository.findByParams(searchParams);
    }

    public void create(Doctor doctor) {
        doctorRepository.create(doctor);
    }

    public void update(Doctor doctor) {
        doctorRepository.update(doctor);
    }

    public Doctor getOne(Integer id) {
        return doctorRepository.getOne(id)
                .orElseThrow(() -> new IllegalArgumentException("Doctor with given id not exists"));
    }

    public List<Doctor> getAll() {
        return doctorRepository.getAll();
    }
    public void delete(int id) {
        doctorRepository.delete(id);
    }

}
