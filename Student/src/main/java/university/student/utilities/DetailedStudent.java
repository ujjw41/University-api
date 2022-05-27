package university.student.utilities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailedStudent {
	Long id;

	String name;

	String email;

	Department department;

	String username;

	String password;

	String role;

	Boolean enabled;
}
