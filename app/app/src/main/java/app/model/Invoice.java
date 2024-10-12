package app.model;

//import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="invoice")
@Getter
@Setter
@NoArgsConstructor

public class Invoice {
	private long id;
	private Person personId;
	private Parther partherId;
	//private Date consumptionDate;
	private double total;
	private boolean status;
	private String items;
	
	
}
