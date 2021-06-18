package hr.tvz.wauj.vjezbe.app.student;

import hr.tvz.wauj.vjezbe.app.course.Course;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_Name")
    private String firstName;
    @Column(name = "last_Name")
    private String lastName;
    @Column(name = "jmbag")
    private String jmbag;
    @Column(name = "date_Of_Birth")
    private LocalDate dateOfBirth;
    @Column(name = "number_Of_ECTS")
    private Integer numberOfECTS;

    @ManyToMany(targetEntity = Course.class)
    @JoinTable(
            name = "student_course",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name ="course_id")}
    )
    private List<Course> courses;


    public Student(String firstName, String lastName, String jmbag, LocalDate dateOfBirth, Integer numberOfECTS) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jmbag = jmbag;
        this.dateOfBirth = dateOfBirth;
        this.numberOfECTS = numberOfECTS;
    }

    public Student() {

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getJmbag() {
        return jmbag;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getNumberOfECTS() {
        return numberOfECTS;
    }

    //Helps Hibernate to determine, if Object needs to be updated or created.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return jmbag.equals(student.jmbag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jmbag);
    }
}
