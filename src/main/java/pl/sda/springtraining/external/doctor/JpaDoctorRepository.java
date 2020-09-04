package pl.sda.springtraining.external.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface JpaDoctorRepository extends JpaRepository<DoctorEntity, Integer>, CustomDoctorRepository{

    Optional<DoctorEntity> findById(int id);

//    //PRACTICE
//
//    //1. Będziemy chceili pobrać lekarzy któzy mają stawkę w pewnych widełkach
//    List<DoctorEntity> findByHourRateBetween(BigDecimal min, BigDecimal max);
//
//    //2. Chcemy pobrać lekarza który pracuje u nas najdłużej (rzeźba - nie zbyt dobre rozwiązanie)
//    Optional<DoctorEntity> findFirstByHireDateBeforeOrderByHireDateDesc(LocalDate hireDate);
//
//    //3. Chcemy pobrać wszystkich lekarzy którzy będą mieli wizytę konkretnego dnia
//    List<DoctorEntity> findByVisits_visitDate(LocalDate visitDate); // underscore pozwala na wejście do jakiejś innej encji
//
//    //4. Chcemy pobrać wszystkich lekarzy zatrudnionych po jakiejś dacie
//    List<DoctorEntity> findByHireDateAfter(LocalDate hireDate);
//
//    //5. Chcemy znaleźć wszystkich lekarzy którzy mają jedną z podanych spesjalizacji
//    List<DoctorEntity> findBySpecializationIn(List<String> specializations);
//
//    //6. Chcemy zwrócić wszystki unikalne specjalizacje naszych lekarzy
//    @Query("select distinct dr.specialization from DoctorEntity dr")
//    List<String> findUniqueSpecializations();
//
//    //7. Chcemy zwrócić średnią stawkę godzinową dla podanej specjalizacji
//    @Query("select avg(dr.hourRate) from DoctorEntity dr " +
//            "where  dr.specialization = :specialization + " +
//            "group by dr.specialization")
//    BigDecimal findAverageEarningsInSpecialization(@Param("specialization") String specialization);
//
//    //8. Polecenie jak w 3. ale przy pomocy Hibernate Query Language (HQL)
//    @Query("select dr from DoctorEntity dr " +
//            "join dr.visits vt " +
//            "where vt.visitDate = :visitDate")
//    List<DoctorEntity> findAllByVisitDate(@Param("visitDate") LocalDate visitDate);
//
//    //querymethod - tylko za pomocą nazwy metody
//    //9. znajdź lekarzy których nazwisko zawieta podany jako parametr ciąg znaków
//    List<DoctorEntity> findBySurnameContains(String text);
//    List<DoctorEntity> findBySurnameLike(String text);
//
//    //10. Znajdź lekarzy, któzych stawka godzinowa jest wyższa niż podany parametr
//    List<DoctorEntity> findByHourRateGreaterThan(BigDecimal hireRate);
//
//    //11. Znajdź najlepiej zarabiającego lekarza w podanej jako parametr specializacji
//    Optional<DoctorEntity> findFirstBySpecializationInOrderByHourRateDesc(String specialization);
//
//    //12. Znajdź lekarzy któzy zostali zatrudnieni po podanej dacie i mają konkretną specjalizację
//    List<DoctorEntity> findByHireDateAfterAndSpecialization(LocalDate hireDate, String specialization);
//
//    //13. Policz ilu lekrzy mamy w podanej jaki parametr specjalizacji (countBy)
//    Long countBySpecialization(String specialization);
//
//    //14. Napisz metodę która usunie wszystkich zarabiających lepiej niż parametr (deleteby)
//    void deleteByHourRateGreaterThan(BigDecimal hourRate);
//
//    //query w HQL
//    //15. Pobierz maksymalną stawkę godzinową wśród wszystkich lekarzy
//    @Query("select max(dr.hourRate) from DoctorEntity dr group by dr.id")
//    Optional<BigDecimal> findHighestHourRate();
//
//    //16. Znajdź lekarzy któzy mają wizytę umówioną z pacjentką o podanym imieniu
//    @Query("select dr from DoctorEntity " +
//            "join dr.visits vt" +
//            "join vt.patient pt" +
//            "where pt.name = :name")
//    Optional<List<DoctorEntity>> findAllWhoHasVisitWithGivenPatient(@Param("patientName") String name);
//
//    //17. Znajdz lekarza który ma najwiekszą ilość wizyt - HW
//    //18. Pobierz maksymalną kworę zarobków wśród lekarzy podanej jako param - HW



}
