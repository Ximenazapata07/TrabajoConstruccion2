package app.controller.validator;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
public class AvailableFundsValidator extends CommonsValidator {
	
	public long validFunds(String funds) throws Exception{
		return super.isValidLong("El fondo del socio ", funds);
	}
	
	
}

