package app.controller;




import app.controller.requests.CreateUserRequests;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.controller.validator.PersonValidator;
import app.controller.validator.UserValidator;
import app.dto.PartherDto;
import app.dto.PersonDto;
import app.dto.UserDto;

import app.service.interfaces.AdminService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;



@RestController
@NoArgsConstructor
@Getter
@Setter

public class AdminController implements ControllerInterface {
    @Autowired
    private PersonValidator personValidator;
    @Autowired 
    private UserValidator userValidator;
    @Autowired 
    private AdminService service;
	
    private static final String MENU ="ingrese la opcion que desea \n 1.para crear socio \n 2. visualización de facturas  \n 3. para promocion VIP \n  4. para cerrar sesion";

	
	@Override
	public void session() throws Exception {
		
	}
	
        @PostMapping("/partner")
	private ResponseEntity createParther(@RequestBody CreateUserRequests request ) {
            try{
            String name = request.getName();
            personValidator.validName(name);
            long document= personValidator.validDocument(request.getDocument());
            long cellnumber= personValidator.validCellnumber(request.getCellphone());
            String userName = request.getUserName();
            userValidator.validUserName(userName);
            String password = request.getPassword();
            userValidator.validPassword(password);
	
            PersonDto personDto = new PersonDto();
            personDto.setName(name);
            personDto.setDocument(document);
            personDto.setCellnumber(cellnumber);
		
            UserDto userDto= new UserDto();
            userDto.setRole("parther");
            userDto.setPassword(password);
            userDto.setUserName(userName);
            userDto.setPersonId(personDto);
            
            PartherDto partherDto = new PartherDto();
            partherDto.setMembersphipDate(new Date(System.currentTimeMillis()));
            partherDto.setUserId(userDto);
            partherDto.setAvailableFunds(50000);
            partherDto.setSubscriptionType("regulares");
            
            this.service.createParther(partherDto);
            return new ResponseEntity<>("Se ha creado el usuario exitosamente",HttpStatus.OK);
            }catch (Exception e ){
                return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
            }
		
	
        }
	
	
        @GetMapping("/")
        
        public String vive (){
            return "vive";
        }
        
		
	}

		
			
		
		
			
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

