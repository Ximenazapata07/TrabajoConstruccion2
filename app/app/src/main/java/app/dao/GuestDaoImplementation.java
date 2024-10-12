package app.dao;

import org.springframework.beans.factory.annotation.Autowired;


import app.dao.interfeces.GuestDao;
import app.dao.jpaInterface.GuestRepository;
import app.dto.GuestDto;
import app.dto.UserDto;
import app.helpers.Helper;
import app.model.Guest;
import app.model.Parther;
import app.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;


@Service
@NoArgsConstructor
@Getter
@Setter

public class GuestDaoImplementation implements GuestDao {
	@Autowired
	GuestRepository guestRepository;
	
	@Override
	public void createGuest(GuestDto guestDto) throws Exception{
		Guest guest = Helper.parse(guestDto);
		guestRepository.save(guest);
	}
	@Override
	public boolean existById(GuestDto guestDto) throws Exception {
		return guestRepository.existsById(guestDto.getId());
	}
	public void deleteGuest (GuestDto guestDto) throws Exception{
		Guest guest = Helper.parse(guestDto);
		guestRepository.delete(guest);
	}
	
	public GuestDto finById(GuestDto guestDto) throws Exception{
		Guest guest = guestRepository.findById(guestDto.getId());
		return Helper.parse(guest);
		
	}
	public GuestRepository getGuestRepository() {
		return guestRepository;
	}
	public void setGuestRepository(GuestRepository guestRepository) {
		this.guestRepository = guestRepository;
	}
	
}
