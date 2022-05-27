package university.student.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	String name;

	@Email
	@Column(unique = true)
	String email;

	String department;

//	@NotBlank(message = "username is required")
	@Column(unique = true, nullable = false)
	String username;

//	@NotBlank(message = "password is required")
	@Column(nullable = false)
	String password;

	@Column(columnDefinition = "varchar(255) default 'USER'")
	String role = "USER";

	@Column(columnDefinition = "boolean default true")
	Boolean enabled = true;
}
