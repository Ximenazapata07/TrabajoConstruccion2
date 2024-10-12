package app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonDto {
	private long id;
	private long document;
	private String name;
	private long cellnumber;
	
	
}
