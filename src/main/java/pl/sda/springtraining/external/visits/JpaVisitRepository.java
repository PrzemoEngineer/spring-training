package pl.sda.springtraining.external.visits;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaVisitRepository extends JpaRepository<VisitEntity, Integer> {

}
