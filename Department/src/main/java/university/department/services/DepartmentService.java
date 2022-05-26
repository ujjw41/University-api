package university.department.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import university.department.entities.Department;
import university.department.repos.DepartmentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepo departmentRepo;

	public void save(Department department) {
		departmentRepo.save(department);
	}

	public Department get(Long id) {
		Optional<Department> optional = departmentRepo.findById(id);

		return optional.orElse(null);
	}

	public void delete(Department department) {
		departmentRepo.delete(department);

	}

	public void update(Department department) {
		departmentRepo.save(department);
	}

	public List<Department> getAll() {
		return departmentRepo.findAll();
	}

	public Department getByName(String name) {

		List<Department> departmentList = departmentRepo.findAllByName(name);
		if (departmentList.isEmpty()){
			Department newDepartment = new Department();
			newDepartment.setName(name);
			return newDepartment;
		}
		return departmentList.get(0);
	}

}
