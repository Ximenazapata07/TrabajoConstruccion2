package app.controller.validator;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
public class PersonValidator extends CommonsValidator{
	
	
	
	public void validName(String name) throws Exception{
		super.isValidString("El nombre de la persona", name);
	}
	public long validDocument(String document) throws Exception{
		return super.isValidLong("La cedula de la persona", document);
	}
	public long validCellnumber(String cellnumber) throws Exception{
		return super.isValidLong("El numero de celular de la persona", cellnumber);
	}

}

