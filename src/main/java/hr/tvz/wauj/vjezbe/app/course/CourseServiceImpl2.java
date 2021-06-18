/*

package hr.tvz.wauj.vjezbe.app.course;


import hr.tvz.wauj.vjezbe.app.student.Student;
import hr.tvz.wauj.vjezbe.app.student.StudentDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class StudentServiceImpl implements CourseService {


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
        Course course = courseRepository.findByName(name).get(0);
        if (course == null) {
            return Optional.empty();
        } else {
            CourseDTO courseDTO = mapCourseToDTO(course);
            return Optional.of(courseDTO);
        }
    }

    @Override
    public Optional<CourseDTO> save(final String name) {
        return courseRepository.save(mapCommandToCourse(name)).map(this::mapCourseToDTO);
    }

    @Override
    public Optional<CourseDTO> update(final String name, Integer numberOfECTS) {
        return courseRepository.update(numberOfECTS, mapCommandToCourse(name)).map(this::mapCourseToDTO);
    }

    @Override
    public void deleteByJMBAG(final String JMBAG) {
        courseRepository.deleteByName(String name);
    }

    private Course mapCommandToCourse(final String name) {

        return new Course(Course.getName(), Course.getNumberOfECTS());
    }

    private CourseDTO mapCourseToDTO(final Course course){
        return new CourseDTO(course.getName());
    }


}

*/
