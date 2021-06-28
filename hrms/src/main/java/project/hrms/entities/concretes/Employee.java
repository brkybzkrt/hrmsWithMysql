package project.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employees")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends User{

	
	
	@NotBlank
	@Column(name="first_name")
	private String firstName;
	@NotBlank
	@Column(name="last_name")
	private String lastName;
	
	
	@OneToMany(mappedBy = "employee")
	private List<ConfirmedEmployerByEmployee> confirmedEmployerByEmployees;
	
	
	public Employee(int id, String firstName, String lastName, String email,String password) {
		super(id,email,password);
		this.firstName = firstName;
		this.lastName = lastName;
	}
}