package app.controller.validator;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
public class InvoiceValidator extends CommonsValidator {
	

	
	public void validItems(String items) throws Exception {
		super.isValidString("Items de la factura", items);
	}
	
	public double validAmount(String amount) throws Exception {
		return super.isValidDouble("El total de la factura", amount);
	}
        
        public int validItem(String items) throws Exception{
            return super.isValidInteger("Items de la factura ", items);
        }

    public long validId(String nextLine) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
