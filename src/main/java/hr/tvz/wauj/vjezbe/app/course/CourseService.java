package hr.tvz.wauj.vjezbe.app.course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<CourseDTO> findAll();

    Optional<CourseDTO> findByName(String name);
    Optional<CourseDTO> findByID(int ID);

    Optional<CourseDTO> save(CourseCommand courseCommand);

    Optional<CourseDTO> update(String id, CourseCommand updatedCourseCommand);

    void deleteByName(String Name);
}
