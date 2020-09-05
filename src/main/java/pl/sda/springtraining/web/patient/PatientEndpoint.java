package pl.sda.springtraining.web.patient;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.springtraining.domain.patient.Patient;
import pl.sda.springtraining.domain.patient.PatientService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController // klasa zwracająca dane a nie widok - nasze api - kontrolery dostęp do naszej apki
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientEndpoint {

    private final PatientService patientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity createPatient(@RequestBody @Valid Patient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errMsgs = bindingResult.getAllErrors().stream()
                    .map(err -> err.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.status(400).body(errMsgs);

        }else {
            patientService.create(patient);
            return ResponseEntity.status(201).build();
        }

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
