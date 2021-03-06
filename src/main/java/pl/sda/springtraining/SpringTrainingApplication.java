package pl.sda.springtraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import pl.sda.springtraining.config.FacilityConfiguration;

@SpringBootApplication
@EnableConfigurationProperties({FacilityConfiguration.class})
//Jeśli chcemy zmienić pakiet bazowy dla nasz appki Springowej
//@ComponentScan(basePackages = "pl.sda")

public class SpringTrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTrainingApplication.class, args);
    }

}
