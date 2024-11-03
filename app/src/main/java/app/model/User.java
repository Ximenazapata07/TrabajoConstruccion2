package app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
public class User {
	@Column(name="id")
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	@Column(name="personid")
	private Person personId;
	@Column(name="password")
	private String password;
	@Column(name="username")
	private String userName;
	@Column(name="role")
	private String role;
	
	
}
