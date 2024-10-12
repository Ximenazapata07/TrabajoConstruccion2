package app.dto;

import java.sql.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class PartherDto {
	private long id;
	private PersonDto personId;
	private UserDto userId;
	private long availableFunds;
	private String subscriptionType;
	private Date membersphipDate;
	
	
}
