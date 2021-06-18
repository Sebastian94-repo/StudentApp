package hr.tvz.wauj.vjezbe.app.course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface CourseRepository {

    Set<Course> findAll();

    Optional<Course> findByName(String name);

    Optional<Course> save (Course course);

    Optional<Course> update(String id, Course updatedCourse, String name);


    void deleteByName(String JMBAG);


}
