package pl.sda.springtraining.external.patient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.sda.springtraining.domain.patient.Patient;
import pl.sda.springtraining.external.visits.VisitEntity;

import javax.persistence.*; // korzystamy z tych adnotacji - takie same są
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "patients")
public class PatientEntity { // klasa nie może być final bo hibernate korzysta z proxy i lazy loading nie zadziała
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String surname;

    @Column(length = 20, unique = true)
    private String insuranceNo;

    @OneToMany(mappedBy = "patient")
    private Set<VisitEntity> visits;

    public void updateFromDomain(Patient patient) {
        this.name = patient.getName();
        this.surname = patient.getSurname();
        this.insuranceNo = patient.getInsuranceNo();
    }
}
