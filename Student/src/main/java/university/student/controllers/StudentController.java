package university.student.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.web.bind.annotation.*;
import university.student.entities.Student;
import university.student.services.StudentService;
import university.student.utilities.DetailedStudent;
import university.student.utilities.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@ResponseBody
	@WriteOperation
	@PostMapping("/student/api/add")
	public Response add(@RequestBody Student student) {
		studentService.save(student);
		return new Response("success", "thank you");
	}

	@GetMapping(value = {"/student/api/read/{id}"})
	public DetailedStudent read(@PathVariable("id") Optional<Long> id) {

		return studentService.get(id.get());

	}

//	@GetMapping("/student/api/read")
//	public Student read(@RequestParam("id") Long id) {
//
//		return studentService.get(id);
//	}

	@ReadOperation
	@GetMapping("/student/api/readall")
	public List<DetailedStudent> readAll() {
		return studentService.getAll();
	}

	@ResponseBody
	@DeleteOperation
	@DeleteMapping("/student/api/delete")
	public Response delete(@RequestBody Student student) {
		studentService.delete(student);

		return new Response("success", "DELETED");
	}

	@ResponseBody
	@WriteOperation
	@PutMapping("/student/api/update")
	public Response update(@RequestBody Student student) {

		studentService.update(student);

		return new Response("success", "UPDATED");
	}
}
