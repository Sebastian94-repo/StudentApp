/*
package hr.tvz.wauj.vjezbe.app.course;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
@Primary
@Repository
public interface CourseRepository {

    Set<Course> findAll();

    Optional<Course> findByName(String name);

    Optional<Course> save (Course course);

    Optional<Course> update(String id, String updatedCourse, int ECTS);

    void deleteByID(String ID);

    @Modifying
      @Query("update Course s set s.id = ?1, s.name = ?2, s.numberOfECTS = ?3")
    void update(String id, String name, String numberOfECTS);

}
*/
