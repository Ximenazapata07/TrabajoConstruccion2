package app.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
	private long id;
	@OneToOne
	@JoinColumn(name="personid")
	private Person personId;
	@OneToOne
	@JoinColumn(name="userid")
	private User userId;
	@Column(name="amount")
	private long availableFunds;
	@Column(name="type")
	private String subscriptionType;
	@Column(name="creationdate")
	private Date membersphipDate;
	

}
