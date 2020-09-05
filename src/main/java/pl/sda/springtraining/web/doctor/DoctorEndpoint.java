package pl.sda.springtraining.web.doctor;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.springtraining.domain.doctor.Doctor;
import pl.sda.springtraining.domain.doctor.DoctorService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorEndpoint {
    
    private final DoctorService doctorService;

    @PostMapping("/search")
    List<Doctor> searchByParams(@RequestBody SearchParams searchParams) {
        return doctorService.findByParams(searchParams);
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    void createDoctor(@RequestBody Doctor doctor) {
//        doctorService.create(doctor);
//    }

    @PostMapping
    ResponseEntity createDoctor(@RequestBody @Valid Doctor doctor, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errMsgs = bindingResult.getAllErrors().stream()
                .map(err -> err.getDefaultMessage())
                .collect(Collectors.toList());
            return ResponseEntity.status(400).body(errMsgs);

        }else {
            doctorService.create(doctor);
            return ResponseEntity.status(201).build();
        }
    }

    @PutMapping
    void updateDoctor(@RequestBody Doctor doctor) {
        doctorService.update(doctor);
    }

    @GetMapping
    List<Doctor> getAll() {
        return doctorService.getAll();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteDoctor(@RequestParam int id) {
        doctorService.delete(id);
    }

    @GetMapping("/{id}")
    Doctor getById(@PathVariable int id) {
        return doctorService.getOne(id);
    }
}
