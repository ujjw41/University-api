package university.student.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import university.student.entities.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
