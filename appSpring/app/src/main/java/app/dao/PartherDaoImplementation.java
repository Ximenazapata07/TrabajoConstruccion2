package app.dao;



import org.springframework.beans.factory.annotation.Autowired;

import app.dao.interfeces.PartherDao;
import app.dao.jpaInterface.PartherRepository;
import app.dto.PartherDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.helpers.Helper;
import app.model.Parther;
import app.model.Person;
import app.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Getter
@Setter

public class PartherDaoImplementation implements PartherDao {
	@Autowired
	PartherRepository partherRepository;
	
	@Override 
	public void createParther(PartherDto partherDto ) throws Exception{
		Parther parther = Helper.parse(partherDto);
		partherRepository.save(parther);
	}
	@Override 
	public void deleteParther(PartherDto partherDto) throws Exception{
		Parther parther= Helper.parse(partherDto);
		partherRepository.delete(parther);
		
	}
	
	@Override
	public boolean existsById(PartherDto partherDto) throws Exception{
		return partherRepository.existsById(partherDto.getId());
		
	}
	
       /* @Override
        public PartherDto findById(PartherDto partherDto) throws Exception {
            Parther parther = partherRepository.findById(partherDto.getId());
            return Helper.parse(parther);
    }
*/

    @Override
    public PartherDto findById(PartherDto partherDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
	
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
