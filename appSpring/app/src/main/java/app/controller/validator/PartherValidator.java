package app.controller.validator;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
public class PartherValidator extends CommonsValidator {
	
	
	
	public long validAvailableFunds(String availableFunds) throws Exception{
		return super.isValidLong("Fondos disponibles del socio", availableFunds);
	}
	
	public void validSubscriptionType(String subscriptionType ) throws Exception {
		super.isValidString("El tipo de suscripcion del socio", subscriptionType);
	}
	
	
}
