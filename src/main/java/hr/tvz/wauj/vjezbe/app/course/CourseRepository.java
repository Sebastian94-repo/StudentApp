package hr.tvz.wauj.vjezbe.app.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
@Repository
public interface CourseRepository {

    Set<Course> findAll();

    Optional<Course> findByName(String name);

    Optional<Course> save (Course course);

    Optional<Course> update(String id, String updatedCourse, int ECTS);


    void deleteByName(String JMBAG);


}
