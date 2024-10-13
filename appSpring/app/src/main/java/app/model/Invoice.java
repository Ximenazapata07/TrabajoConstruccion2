package app.model;

//import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="invoice")
@Getter
@Setter
@NoArgsConstructor

public class Invoice {
        @Id
        @Column(name="id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
        @ManyToOne
        @JoinColumn(name="personid")
	private Person personId;
        @ManyToOne
        @JoinColumn(name="partnerid")
	private Parther partherId;
        @Column(name="creationdate" )
	private Date consumptionDate;
        @Column(name="amount")
	private double total;
        @Column(name="status")
	private boolean status;
       
	
}
