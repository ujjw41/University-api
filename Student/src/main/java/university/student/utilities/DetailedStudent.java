package university.student.utilities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailedStudent {
	Long id;

	String name;

	String email;

	Department department;
}
