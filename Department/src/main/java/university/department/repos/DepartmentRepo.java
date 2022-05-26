package university.department.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import university.department.entities.Department;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
	List<Department> findAllByName(String name);
}
