
package hr.tvz.wauj.vjezbe.app.course;


import hr.tvz.wauj.vjezbe.app.student.Student;
import hr.tvz.wauj.vjezbe.app.student.StudentCommand;
import hr.tvz.wauj.vjezbe.app.student.StudentDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class CourseServiceImpl implements CourseService {


    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseRepository.findAll().stream().map(this::mapCourseToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<CourseDTO> findByName(final String name) {
       Course course = courseRepository.findByName(name).get();
        if (course == null) {
            return Optional.empty();
        } else {
            CourseDTO courseDTO = mapCourseToDTO(course);
            return Optional.of(courseDTO);
        }
    }

    @Override
    public Optional<CourseDTO> findByID(int ID) {
        return Optional.empty();
    }


    @Override
    public Optional<CourseDTO> save(final CourseCommand courseCommand) {
     Course course = courseRepository.save(mapCommandToCourse(courseCommand)).get();

        CourseDTO courseDTO = mapCourseToDTO(course);
        return Optional.of(courseDTO);

    }

    @Override
    public Optional<CourseDTO> update(final String id, final CourseCommand updatedCourseCommand) {
        courseRepository.update( id, updatedCourseCommand.getName(), updatedCourseCommand.getNumberOfECTS());
        return findByName(id);
    }

    @Override
    public void deleteByName(final String name) {
       courseRepository.deleteByName(name);
    }

    private Course mapCommandToCourse(final CourseCommand courseCommand) {

        return new Course(courseCommand.getId(), courseCommand.getName(), courseCommand.getNumberOfECTS());
    }

    private CourseDTO mapCourseToDTO(final Course course){
        return new CourseDTO(course.getName());
    }


}

