package app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.interfeces.UserDao;
import app.dao.jpaInterface.UserRepository;
import app.dto.UserDto;
import app.helpers.Helper;
import app.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Service
@NoArgsConstructor
@Getter
@Setter

public class UserDaoImplementation implements UserDao {
	@Autowired
	UserRepository userRepository;
	
	@Override 
	public UserDto findByUserName(UserDto userDto) throws Exception {
		User user= userRepository.findByUserName(userDto.getUserName());
		return Helper.parse(user);

	}
	@Override 
	public boolean existsByUserName(UserDto userDto) throws Exception {
		return userRepository.existsByUserName(userDto.getUserName());
	}
	
	@Override 
	public void createUser(UserDto useDto) throws Exception{
		User user = Helper.parse(useDto);
		userRepository.save(user);
		
	}
	public UserRepository getUserRepository() {
		return userRepository;
	}
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	
	
	
	
	
	
	
	
}
