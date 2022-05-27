package university.department.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.web.bind.annotation.*;
import university.department.entities.Department;
import university.department.services.DepartmentService;
import university.department.utilities.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ApiController {
	@Autowired
	DepartmentService departmentService;

	@ResponseBody
	@WriteOperation
	@PostMapping("/department/add")
	public Response add(@RequestBody Department department) {
		departmentService.save(department);
		return new Response("success", "thank you");
	}

	@GetMapping(value = {"/department/read", "/department/read/{id}"})
	public List<Department> read(@PathVariable("id") Optional<Long> id) {
		if (id.isEmpty()) {
			return departmentService.getAll();
		}
		Department department = departmentService.get(id.get());
		List<Department> list = new ArrayList<>();
		list.add(department);
		return list;
	}

	@ReadOperation
	@GetMapping("/department/readall")
	public List<Department> readAll() {
		return departmentService.getAll();
	}

	@ResponseBody
	@DeleteOperation
	@DeleteMapping("/department/delete")
	public Response delete(@RequestBody Department department) {
		departmentService.delete(department);

		return new Response("success", "DELETED");
	}

	@ResponseBody
	@WriteOperation
	@PutMapping("/department/update")
	public Response update(@RequestBody Department department) {

		departmentService.update(department);

		return new Response("success", "UPDATED");
	}

	@GetMapping(value = {"/department/getname"})
	public Department get(@RequestParam("name") String name) {
		return departmentService.getByName(name);
	}
}
