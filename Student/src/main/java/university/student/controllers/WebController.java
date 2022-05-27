package university.student.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String get() {

		return "index";
	}

	@GetMapping("/register")
	public String add() {

		return "register";
	}

	@GetMapping("/read")
	public String read() {

		return "read";
	}

	@GetMapping("/update")
	public String update() {

		return "update";
	}

	@GetMapping("/delete")
	public String delete() {

		return "delete";
	}

	@GetMapping("/login")
	public String login() {

		return "login";
	}

}
