package app.controller.validator;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
public class GuestValidator extends CommonsValidator {
	
	public void validUserName(String userName) throws Exception{
		super.isValidString("El nombre de usuario", userName);
	}
	

}
