package pl.sda.springtraining.domain.patient;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Patient {
    private Integer id;
    private String name;
    private String surname;
    private String insuranceNo;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getInsuranceNo() {
        return insuranceNo;
    }
}
