package app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="partner")
@Getter
@Setter
@NoArgsConstructor

public class Parther {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="id")
	private long id;
        
	private Person personId;
        @Column(name="userid")
	private User userId;
        @Column (name="amount")
	private long availableFunds;
        @Column(name="Type")
	private String subscriptionType;
        @Column (name="creationdate")
	private Date membersphipDate;
	
}
