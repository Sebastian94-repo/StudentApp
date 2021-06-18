package hr.tvz.wauj.vjezbe.app.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class StudentServiceImpl implements StudentService {

    private static final int YEARS_AFTER_WHICH_TUITION_SHOULD_BE_PAYED = 26;

    private final StudentRepositoryJPA studentRepository;

    public StudentServiceImpl(StudentRepositoryJPA studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDTO> findAll() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Student s : studentList) {
            studentDTOList.add(mapStudentToDTO(s));

        }
        return studentDTOList;

    }

    @Override
    public Optional<StudentDTO> findByJmbag(final String JMBAG) {
        Student student = studentRepository.findByJmbag(JMBAG).get(0);
        if (student == null) {
            return Optional.empty();
        } else {
            StudentDTO studentDTO = mapStudentToDTO(student);
            return Optional.of(studentDTO);
        }
    }

    @Override
    public Optional<StudentDTO> save(final StudentCommand studentCommand) {
        Student student = studentRepository.save(mapCommandToStudent(studentCommand));

        StudentDTO studentDTO = mapStudentToDTO(student);
        return Optional.of(studentDTO);

    }

    @Override
    public Optional<StudentDTO> update(final String JMBAG, final StudentCommand updatedStudentCommand) {
        studentRepository.update(updatedStudentCommand.getFirstName(), updatedStudentCommand.getLastName(), updatedStudentCommand.getDateOfBirth(), updatedStudentCommand.getNumberOfECTS(), JMBAG);
        return findByJmbag(JMBAG);


    }

    @Override
    public void deleteByJmbag(final String JMBAG) {
        studentRepository.deleteByJmbag(JMBAG);
    }

    private Student mapCommandToStudent(final StudentCommand studentCommand) {
        return new Student(studentCommand.getFirstName(), studentCommand.getLastName(), studentCommand.getJmbag(), studentCommand.getDateOfBirth(), studentCommand.getNumberOfECTS());
    }

    private StudentDTO mapStudentToDTO(final Student student) {
        return new StudentDTO(student.getJmbag(), student.getNumberOfECTS(), shouldTuitionBePayed(student.getDateOfBirth()), student.getDateOfBirth());
    }

    private boolean shouldTuitionBePayed(LocalDate dateOfBirth) {
        return dateOfBirth.plusYears(YEARS_AFTER_WHICH_TUITION_SHOULD_BE_PAYED).isBefore(LocalDate.now());
    }
}
