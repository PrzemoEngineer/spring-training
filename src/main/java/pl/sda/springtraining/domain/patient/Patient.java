package pl.sda.springtraining.domain.patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.springtraining.web.validator.NameLength;
import pl.sda.springtraining.web.validator.ValidInsuranceNo;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ValidInsuranceNo
@NameLength
public class Patient {
    private Integer id;
    private String name;
    private String surname;
    private String insuranceNo;
    private String nationality;
}
