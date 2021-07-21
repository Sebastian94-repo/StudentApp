/*
package hr.tvz.wauj.vjezbe.app.course;


import hr.tvz.wauj.vjezbe.app.student.Student;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer numberOfECTS;

    @ManyToMany(targetEntity = Student.class, mappedBy = "courses")
    private List<Student> students;

    public Course(Long id, String name, Integer numberOfECTS) {
        this.id = id;
        this.name = name;
        this.numberOfECTS = numberOfECTS;
    }


    public Course() {

    }

    public String getName(){return name;}
    public Integer getNumberOfECTS(){return numberOfECTS;}





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) && Objects.equals(name, course.name) && Objects.equals(numberOfECTS, course.numberOfECTS) && Objects.equals(students, course.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, numberOfECTS, students);
    }
}
*/
