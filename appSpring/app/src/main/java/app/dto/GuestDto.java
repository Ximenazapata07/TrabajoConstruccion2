package app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor


public class GuestDto {
	private long id;
	private PersonDto personId;
	private UserDto userId;
	private PartherDto partherId;
	private Boolean guestStatus;
	
}
