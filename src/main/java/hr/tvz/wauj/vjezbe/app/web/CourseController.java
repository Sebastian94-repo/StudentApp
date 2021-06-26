package hr.tvz.wauj.vjezbe.app.web;

import hr.tvz.wauj.vjezbe.app.course.CourseDTO;
import hr.tvz.wauj.vjezbe.app.course.CourseService;
import hr.tvz.wauj.vjezbe.app.course.CourseCommand;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

Sebastian
@RestController
@RequestMapping("course")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses(){
        return courseService.findAll();
    }

    @GetMapping("/{ID}")
    public ResponseEntity<CourseDTO> getCourseByID(@PathVariable final Integer ID){
        return courseService.findByID(ID)
                .map(ResponseEntity::ok)
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }

    @PostMapping
    public ResponseEntity<CourseDTO> save(@Valid @RequestBody final CourseCommand command) {
        return courseService.save(command)
                .map(
                        courseDTO -> ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(courseDTO)
                )
                .orElseGet(
                        () -> ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .build()
                );

    }

    @PutMapping ("/{ID}")
    public ResponseEntity<CourseDTO> update (@PathVariable String ID, @Valid @RequestBody final CourseCommand updateCourseCommand) {
        return courseService.update(ID, updateCourseCommand)
                .map(ResponseEntity::ok)
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{ID")
    public void delete(@PathVariable String ID){
        courseService.deleteByID(ID);
    }

}
