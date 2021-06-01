package project.hrms.entities.concretes;




import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Table(name="candidates")

public class Candidate extends User {

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	@Size(min = 11,max= 11)
	@Column(name="nationality_id")
	private String nationalityId;
	
	
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	
	public Candidate(int id, String email, String password,String firstName, String lastName,String nationalityId,LocalDate dateOfBirth) {
		super(id, email, password);
		this.firstName=firstName;
		this.lastName=lastName;
		this.nationalityId=nationalityId;
		this.dateOfBirth=dateOfBirth;
		
	}

	@JsonIgnore
	@OneToOne(mappedBy = "candidate")
	private Cv cv;
	
	
	
}
