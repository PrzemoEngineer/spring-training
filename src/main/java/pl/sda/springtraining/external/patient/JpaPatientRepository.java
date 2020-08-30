package pl.sda.springtraining.external.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaPatientRepository extends JpaRepository<PatientEntity, Integer> { // przyjmuje dwie wartości - encję i typ klucza
    //SELECT * FROM patients WHERE insurance_no = ?
    Optional<PatientEntity> findByInsuranceNo(String insuranceNo);

//    //select * from patients where name = ? and surname = ?
//    List<Patient> findAllByNameAndSurname(String name, String surname);
//    //select * from patients where name like "?%"
//    List<Patient> findAllByNameStartsWith(String namePrefix);

}
