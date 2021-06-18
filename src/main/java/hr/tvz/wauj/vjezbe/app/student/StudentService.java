package hr.tvz.wauj.vjezbe.app.student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    
    List<StudentDTO> findAll();
    
    Optional<StudentDTO> findByJmbag(String JMBAG);
    
    Optional<StudentDTO> save(StudentCommand studentCommand);
    
    Optional<StudentDTO> update(String JMBAG, StudentCommand updatedStudentCommand);
    
    void deleteByJmbag(String JMBAG);
}
