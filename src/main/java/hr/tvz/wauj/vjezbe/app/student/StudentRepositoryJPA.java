package hr.tvz.wauj.vjezbe.app.student;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Primary
@Repository
public interface StudentRepositoryJPA extends JpaRepository<Student, Long> {

    List<Student> findByLastName(String lastName);
    List<Student> findByJmbag(String jmbag);

  //  List<Student> findAll();
   // List<Student> save();
  @Modifying
  @Query("update Student s set s.firstName = ?1, s.lastName = ?2, s.dateOfBirth = ?3, s.numberOfECTS = ?4 where s.jmbag = ?5")
    void update(String firstName, String lastName, LocalDate dateOfBirth, Integer numberOfECTS, String jmbag);
    void deleteByJmbag(String jmbag);

}
