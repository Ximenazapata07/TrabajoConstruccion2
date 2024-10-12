package app.model;

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
@Table(name="guest")
@Getter
@Setter
@NoArgsConstructor
public class Guest {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	@OneToOne
	@JoinColumn(name="personid")
	private Person personId;
	@OneToOne
	@JoinColumn(name="userid")
	private User userId;
	@OneToOne
	@JoinColumn(name="partnerid")
	private Parther partherId;
	@Column(name="status")
	private Boolean guestStatus;
	
	
}
