package pl.sda.springtraining.external.doctor;

import org.springframework.data.repository.NoRepositoryBean;
import pl.sda.springtraining.web.doctor.SearchParams;

import java.util.List;


@NoRepositoryBean // info dla springa że dla tego nie ma tworzyć implementacji
public interface CustomDoctorRepository {


    default List<DoctorEntity> findWithSearchParams(SearchParams searchParams) {
        return null;
    }

}
