package pl.sda.springtraining.domain.doctor;


import pl.sda.springtraining.web.doctor.SearchParams;

import java.util.List;
import java.util.Optional;


public interface DoctorRepository {
    List<Doctor> findByParams(SearchParams searchParams);

    void create(Doctor doctor);

    void update(Doctor doctor);

    void delete(int id);

    Optional<Doctor> getOne(int id);

    List<Doctor> getAll();

}
