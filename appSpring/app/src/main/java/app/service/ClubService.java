package app.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.PersonDaoImplementation;
import app.dao.UserDaoImplementation;
import app.dao.interfeces.GuestDao;
import app.dao.interfeces.InvoiceDao;
import app.dao.interfeces.PartherDao;
import app.dao.interfeces.PersonDao;
import app.dao.interfeces.UserDao;
import app.dto.GuestDto;
import app.dto.InvoiceDto;
import app.dto.PartherDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.helpers.Helper;
import app.model.Guest;
import app.model.Parther;
import app.service.interfaces.AdminService;
import app.service.interfaces.LoginService;
import app.service.interfaces.PartherService;
import app.dao.GuestDaoImplementation;
import app.dao.PartherDaoImplementation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Service
@Getter
@Setter
@NoArgsConstructor

public class ClubService implements LoginService,AdminService,PartherService{
	@Autowired
	private UserDao userDao;
	@Autowired
	private PersonDao personDao;
	private InvoiceDao invoiceDao;
	@Autowired
	private static UserDto user;
	@Autowired
	private PartherDao partherDao;
	@Autowired
	private GuestDao guestDao;
        
        
	
	@Override
	public void createGuest(GuestDto guestDto) throws Exception {
		this.personDao.createPerson(guestDto.getUserId().getPersonId());
		guestDto.getUserId().setPersonId(this.personDao.findByDocument(guestDto.getUserId().getPersonId()));
		this.userDao.createUser(guestDto.getUserId());
		UserDto userDto= userDao.findByUserName(guestDto.getUserId());
		guestDto.setUserId(userDto);
                //va el id del socio 
                //guestDto.setPartherId(this.partherDao.existsById(user));
		try {
			
			this.guestDao.createGuest(guestDto);
		
		}catch (SQLException e) {
			this.personDao.deletePerson(userDto.getPersonId());
			throw new Exception ("No se puede crear el invitado");
		}
		
	}
	@Override
	public void createInvoice(InvoiceDto invoiceDto) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void createParther(PartherDto partherDto) throws Exception{
		this.personDao.createPerson(partherDto.getUserId().getPersonId());
		partherDto.getUserId().setPersonId(this.personDao.findByDocument(partherDto.getUserId().getPersonId()));
		PersonDto personDto = partherDto.getUserId().getPersonId();
		this.userDao.createUser(partherDto.getUserId());
		UserDto userDto= userDao.findByUserName(partherDto.getUserId());
		userDto.setPersonId(personDto);
		partherDto.setUserId(userDto);
		try {
 			this.partherDao.createParther(partherDto);
		
		}catch (SQLException e) {
			this.personDao.deletePerson(userDto.getPersonId());
			throw new Exception ("No se puedo crear el socio");
		}
		
	}
	@Override
	public void createPromotion() throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Login(UserDto userDto) throws Exception {
		UserDto validateDto= userDao.findByUserName(userDto);
		if (validateDto ==null) {
			throw new Exception  ("No existe usuario registrado");
			
		}
		if (!userDto.getPassword().equals(validateDto.getPassword())) {
			throw new Exception ("Usuario o contraseña inconrrecto");
			
		}
		userDto.setRole(validateDto.getRole());
		user =validateDto;
		
		
	}
	@Override
	public void logout() {
		user=null;
		System.out.println("Se ha cerrado sesion");
		
	}

	
	
}
