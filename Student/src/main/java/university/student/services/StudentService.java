package university.student.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import university.student.entities.Student;
import university.student.repos.StudentRepo;
import university.student.utilities.Department;
import university.student.utilities.DetailedStudent;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
	@Autowired
	StudentRepo studentRepo;
	@Autowired
	RestTemplate restTemplate;

	public void save(Student student) {
		studentRepo.save(student);
	}

	public DetailedStudent get(Long id) {
		Optional<Student> optional = studentRepo.findById(id);

		Student student = optional.get();

		HttpHeaders httpHeaders = new HttpHeaders();

		httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

		HttpEntity httpEntity = new HttpEntity<>(httpHeaders);

		Department department = restTemplate.exchange("http://DEPARTMENT-SERVICE/department/api/getname?name=" +
				student.getDepartment(), HttpMethod.GET, httpEntity, Department.class).getBody();

		DetailedStudent detailedStudent = new DetailedStudent();
		detailedStudent.setId(student.getId());
		detailedStudent.setName(student.getName());
		detailedStudent.setEmail(student.getEmail());
		detailedStudent.setDepartment(department);

		return detailedStudent;
	}

	public List<DetailedStudent> getAll() {
		List<Student> studentList = studentRepo.findAll();

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
		HttpEntity httpEntity = new HttpEntity<>(httpHeaders);

		List<DetailedStudent> detailedStudentList = new ArrayList<>();
		studentList.forEach( student -> {
			Department department = restTemplate.exchange("http://DEPARTMENT-SERVICE/department/api/getname?name=" +
					student.getDepartment(), HttpMethod.GET, httpEntity, Department.class).getBody();
			DetailedStudent detailedStudent = new DetailedStudent();
			detailedStudent.setId(student.getId());
			detailedStudent.setName(student.getName());
			detailedStudent.setEmail(student.getEmail());
			detailedStudent.setDepartment(department);

			detailedStudentList.add(detailedStudent);
		});

		return detailedStudentList;
	}

	public void delete(Student student) {
		studentRepo.delete(student);

	}

	public void update(Student student) {
		studentRepo.save(student);
	}


}
