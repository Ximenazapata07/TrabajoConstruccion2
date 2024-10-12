package app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;


import app.controller.validator.UserValidator;
import app.dto.UserDto;
import app.service.ClubService;
import app.service.interfaces.LoginService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Controller
@Getter
@Setter

public class LoginController implements ControllerInterface {
	@Autowired
	private UserValidator userValidator;
	@Autowired
	private LoginService service;
	private static final String MENU= "ingrese la opcion que desea: \n 1. para iniciar sesion. \n 2. para detener la ejecucion.";
	private Map<String,ControllerInterface>roles;
	
	public LoginController(AdminController adminController, PartherController partherController, GuestController guestController) {
		this.roles= new HashMap<String,ControllerInterface>();
		roles.put("admin", adminController);
		roles.put("parther", partherController);
		roles.put("guest",guestController);
		
	}
	@Override
	public void session() throws Exception{
		boolean session = true ;
		while (session) {
			session = menu();
			
		}
	}
	
	private boolean menu() {
		try {
			System.out.println(MENU);
			String option =Utils.getReader().nextLine();
			return options(option);
			
		}catch (Exception e ) {
			System.out.println(e.getMessage());
			return true;
			
		}
	}
	
	private boolean options (String option ) throws Exception {
		switch (option) {
		case "1": {
			this.login();
			return true ;
			
		}
		case "2":{
			System.out.println("Se detiene el programa");
			return false;
			
		}
		default :{
			System.out.println("Ingrese una opcion valida");
			return true;
			
		}
		}
		
			
		}

	private void login() throws Exception {
		System.out.println("Ingrese el usuario");
		String userName= Utils.getReader().nextLine();
		userValidator.validUserName(userName);
		System.out.println("Ingrese la contraseña");
		String password= Utils.getReader().nextLine();
		userValidator.validPassword(password);
		UserDto userDto = new UserDto();
		userDto.setPassword(password);
		userDto.setUserName(userName);
		this.service.Login(userDto);
		if (roles.get(userDto.getRole())==null) {
			throw new Exception ("Rol invalido");
			
		}
		roles.get(userDto.getRole()).session();
	}
	public UserValidator getUserValidator() {
		return userValidator;
	}
	public void setUserValidator(UserValidator userValidator) {
		this.userValidator = userValidator;
	}
	public LoginService getService() {
		return service;
	}
	public void setService(LoginService service) {
		this.service = service;
	}
	public Map<String, ControllerInterface> getRoles() {
		return roles;
	}
	public void setRoles(Map<String, ControllerInterface> roles) {
		this.roles = roles;
	}
	public static String getMenu() {
		return MENU;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
