package app.dao.interfeces;

import app.dto.PartherDto;
import app.dto.UserDto;


public interface PartherDao {
	public void createParther(PartherDto partherDto) throws Exception;
	public PartherDto existsById(PartherDto partherDto) throws Exception;
	public void deleteParther(PartherDto partherDto) throws Exception;
	
}
