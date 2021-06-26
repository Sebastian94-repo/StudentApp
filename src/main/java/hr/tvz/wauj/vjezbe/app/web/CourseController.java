package hr.tvz.wauj.vjezbe.app.web;

import hr.tvz.wauj.vjezbe.app.student.StudentCommand;
import hr.tvz.wauj.vjezbe.app.student.StudentDTO;
import hr.tvz.wauj.vjezbe.app.student.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("course")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<StudentDTO> getAllCourses(){
        return courseService.findAll();
    }

    @GetMapping("/{ID}")
    public ResponseEntity<StudentDTO> getCourseByID(@PathVariable final String ID){
        return courseService.findByID(ID)
                .map(ResponseEntity::ok)
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }


}
