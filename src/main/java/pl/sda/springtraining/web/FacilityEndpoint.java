package pl.sda.springtraining.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.springtraining.config.FacilityConfiguration;

@RestController
@RequiredArgsConstructor
@RequestMapping("/facility")
public class FacilityEndpoint {
    private final FacilityConfiguration facilityConfiguration;

    @GetMapping
    String getFacilityInfo() {
        return String.format("Open from %d to %d",
                facilityConfiguration.getOpeningHour(),
                facilityConfiguration.getClosingHour());
    }
}
