package university.student.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.web.bind.annotation.*;
import university.student.entities.Student;
import university.student.services.ApiService;
import university.student.utilities.DetailedStudent;
import university.student.utilities.Response;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiController {

	@Autowired
	ApiService apiService;

	@ResponseBody
	@WriteOperation
	@PostMapping("/student/register")
	public Response register(@RequestBody Student student) {
		apiService.save(student);
		return new Response("success", "thank you");
	}

	@GetMapping(value = {"/student/read/{id}"})
	public DetailedStudent read(@PathVariable("id") Optional<Long> id) {

		return apiService.get(id.get());

	}

//	@GetMapping("/student/api/read")
//	public Student read(@RequestParam("id") Long id) {
//
//		return studentService.get(id);
//	}

	@ReadOperation
	@GetMapping("/student/readall")
	public List<DetailedStudent> readAll() {
		return apiService.getAll();
	}

	@ResponseBody
	@DeleteOperation
	@DeleteMapping("/student/delete")
	public Response delete(@RequestBody Student student) {
		apiService.delete(student);

		return new Response("success", "DELETED");
	}

	@ResponseBody
	@WriteOperation
	@PutMapping("/student/update")
	public Response update(@RequestBody Student student) {

		apiService.update(student);

		return new Response("success", "UPDATED");
	}
}
