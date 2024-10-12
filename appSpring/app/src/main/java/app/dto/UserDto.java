package app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor

public class UserDto {
	
	private long id;
	private PersonDto personId;
	private String password;
	private String userName;
	private String role;
	
	

}
