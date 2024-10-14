package app.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.controller.validator.PersonValidator;
import app.controller.validator.UserValidator;
import app.dto.GuestDto;
import app.dto.InvoiceDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.service.ClubService;
import app.service.interfaces.PartherService;
import app.controller.validator.InvoiceValidator;
import app.dto.InvoiceDetailDto;
import app.dto.PartherDto;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Controller
@NoArgsConstructor
@Getter
@Setter
public class PartherController implements ControllerInterface{
	@Autowired
	private PersonValidator personValidator;
	@Autowired
	private UserValidator userValidator;
	@Autowired
	private InvoiceValidator invoiceValidator;
	@Autowired 
	private PartherService service;
	
	
	
	
	private static final String MENU= "ingrese la opcion que desea \n 1.Para consultar tus fondos e incrementar  \n 2. Para realizar facturas \n 3. Para crear invitados \n 4. Desactivar invitados \n  5.cerrar sesion ";
	private static final String MENU2= "Ingrese la opcion que desea \n 1. para consultar fondos \n 2. para incremento de fondos \n 3. para volver al menu principal";
	
	@Override 
	public void session() throws Exception {
		boolean session = true ;
		while(session) {
			session= menu();
			
		}
	}
	private boolean menu() {
		try {
			System.out.println(MENU);
			String option= Utils.getReader().nextLine();
			return options(option);
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
		
		
	}
	private boolean options(String option) throws Exception {
		switch (option) {
		case "1":{
			this.menu2();
			return true ;
			
		}
		case "2":{
			//this.billing();
			return true;
		}
		case "3":{
			this.createGuest();
			return true;
		}
		case "4":{
			//this.removerGuest();
		}
		case "5":{
			System.out.println("Se ha cerrado seccion");
			return false;
			}
		default :
			System.out.println("Ingrese una opcion valida");
			return true;
			
		}
		
		
			
			
		}


	
	
	private boolean menu2() {
		try {
			System.out.println(MENU2);
			String option2= Utils.getReader().nextLine();
			return options(option2);
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
		}
	
	//poner la opcion 3 , aun nose como puedo obtener el saldo 
	private boolean availableFunds(String opcion2)throws Exception {
		boolean session2=true;
		while(session2) {
			session2=menu2();
		}
		switch (opcion2) {
		case "1":{
			//System.out.println("saldo actual: "+ obtenersaldo());
			return true;
		}
		case"2":{
			System.out.println("Ingresa la cantidad a agragar : $");
			//long amount= Scanner.nextlong();
			
			//obtenersaldo.add(amount);
			System.out.println("Fondos agregados exitosamente.");
			return true;
			
		}
		case"3":{
			return false;
		}
		default:
			System.out.println("Ingrese una opcion valida");
			return true;
			
				
	}
}
	//cosa que va en el service 
	/*
	public void add(long amount) {
	if(amount>0) {
		obtenersaldo+= amount;
	}else {
		System.out.println("La cantidad debe ser mayor a cero");
	}
	
}*/
	public void createGuest() throws Exception {
		System.out.println("Ingrese el nombre del invitado");
		String name= Utils.getReader().nextLine();
		personValidator.validName(name);
		System.out.println("Ingrese el documento del invitado");
		long document= personValidator.validDocument(Utils.getReader().nextLine());
		System.out.println("Ingrese el numero de telefono del invitado");
		long cellnumber= personValidator.validCellnumber(Utils.getReader().nextLine());
		
		
		System.out.println("Ingrese el nombre de usuario del invitado");
		String userName=Utils.getReader().nextLine();
		userValidator.validUserName(userName);
		System.out.println("Ingrese la contraseña del invitado");
		String password=Utils.getReader().nextLine();
		userValidator.validPassword(password);
		
		
		PersonDto personDto =new PersonDto();
		personDto.setName(userName);
		personDto.setDocument(document);
		personDto.setCellnumber(cellnumber);
		
		
		
		UserDto userDto = new UserDto();
		userDto.setRole("guest");
		userDto.setPersonId(personDto);
		userDto.setUserName(userName);
		userDto.setPassword(password);
		
		
		GuestDto guestDto = new GuestDto();
		guestDto.setGuestStatus(true);
		guestDto.setUserId(userDto);
	
		this.service.createGuest(guestDto);
		System.out.println("Usuario creado exitosamente");
		
		
		
		
	}
	
	/*
	public void billing () throws Exception{
        System.out.println("Ingrese el numero de elementos");
        int items = invoiceValidator.validItem(Utils.getReader().nextLine());
        List<InvoiceDetailDto> invoices = new ArrayList<InvoiceDetailDto>();
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setConsumptionDate(new Date(System.currentTimeMillis()));
        
        
        // asignar el partherId y el personId a la factura
         invoiceDto.setPartherId(invoiceDto.getPartherId());
         invoiceDto.setPersonId(invoiceDto.getPersonId());
        
        double total = 0;
        
        for(int i = 0; i < items; i++) {
        	InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        	invoiceDetailDto.setInvoiceid(invoiceDto);
        	invoiceDetailDto.setItem(i + 1);
        	
        	System.out.println("Ingrese la descripción del item");
        	// agregar un validador para la descripción si es necesario
            String description = Utils.getReader().nextLine();
            
            invoiceDetailDto.setDescription(description);
            
        	System.out.println("Ingrese el monto del item" + description);
            double amount = invoiceValidator.validItem(Utils.getReader().nextLine());
            
            invoiceDetailDto.setAmount(amount);
            invoices.add(invoiceDetailDto);
            
            total += invoiceDetailDto.getAmount();
        }
        
        invoiceDto.setTotal(total);
        
        // llamar al club service para guardar el invoice
        // clubService.createInvoice(invoiceDto)
        
        // debes crear otro método en clubService para guardar los invoice details
        // puede ser que reciba una lista así
        // clubService.createInvoiceDetails(invoices)
        
        // o que reciba solo un dto y lo harías en un for
        /*
        for(InvoiceDetailDto invoiceDetail: invoices) {
        	//clubService.createInvoiceDetail(invoiceDetail)
        
	
        
        
        }
*/
        }     
		
	
	
	
