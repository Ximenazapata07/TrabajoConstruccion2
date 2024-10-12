package app.controller.validator;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
public class UserValidator extends CommonsValidator {
	
	public void validUserName(String userName) throws Exception{
		super.isValidString("El nombre de usuario", userName);
	}
	public void validPassword (String password) throws Exception{
		super.isValidString("La contraseña de usuario", password);
	}
	public void validRole(String role) throws Exception {
		super.isValidString("El rol del usurio", role);
	}

	
}
