package app.dto;

//import java.sql.Date;

import java.sql.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor

public class InvoiceDto {
	private long id;
	private PersonDto personId;
	private PartherDto partherId;
	private Date consumptionDate;
	private double total;
	private boolean status;
	
	
}

