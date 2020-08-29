package pl.sda.springtraining.web.patient;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.springtraining.domain.patient.Patient;
import pl.sda.springtraining.domain.patient.PatientService;

import java.util.List;

@RestController // klasa zwracająca dane a nie widok - nasze api - kontrolery dostęp do naszej apki
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientEndpoint {

    private final PatientService patientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createPatient(@RequestBody Patient patient) {
        patientService.create(patient);
    }

    @PutMapping
    void updatePatient(@RequestBody Patient patient) {
        patientService.update(patient);
    }
    //!!!!!!!!!! 3 adnotacje do wkucia - @RequestBody, @RequestParam, @PathVariable
    // inne przydatne: @ResponseStatus

    @GetMapping
    List<Patient> getAll() {
        return patientService.getAll(); // spring z automatu zwróci nam JSON'a :D
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@RequestParam int id) {
        patientService.delete(id);
    }

    @GetMapping("/{id}")
    Patient getByID(@PathVariable int id) {
        return patientService.getOne(id);
    }

}
