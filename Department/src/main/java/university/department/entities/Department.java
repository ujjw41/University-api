package university.department.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	String name;
	String city;
	String faculty;
}
