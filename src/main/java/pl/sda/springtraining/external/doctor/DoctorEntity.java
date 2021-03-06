package pl.sda.springtraining.external.doctor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.sda.springtraining.domain.doctor.Doctor;
import pl.sda.springtraining.external.visits.VisitEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "doctors")
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String specialization;
    private LocalDate hireDate;
    private BigDecimal hourRate;

    @OneToMany(mappedBy = "doctor")
    private Set<VisitEntity> visits;

    void updateFromDomain(Doctor doctor) {
        this.specialization = doctor.getSpecialization();
        this.hourRate = doctor.getHourRate();
    }
}
