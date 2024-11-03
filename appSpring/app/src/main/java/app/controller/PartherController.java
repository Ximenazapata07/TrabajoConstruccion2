package app.controller;

import app.controller.requests.CreateGuestRequests;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
	

	
	@Override 
	public void session() throws Exception {
	
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
        @PostMapping("/guest")
	private ResponseEntity createGuest(@RequestBody CreateGuestRequests requestGuest) {
            
                try{
		String name= requestGuest.getName();
		personValidator.validName(name);
		long document= personValidator.validDocument(requestGuest.getDocument());
		long cellnumber= personValidator.validCellnumber(requestGuest.getCellphone());
		
		String userName=requestGuest.getUserName();
		userValidator.validUserName(userName);
		
		String password=requestGuest.getPassword();
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
                
                PartherDto partherDto = new PartherDto();
                partherDto.setId(personValidator.isValidLong("Id del socio", requestGuest.getPartherId()));
                guestDto.setPartherId(partherDto);
                
                
                
	
		this.service.createGuest(guestDto);
		return new ResponseEntity<>("Se ha creado el invitado exitosamente",HttpStatus.OK);
                }catch (Exception e){
                    return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
                }
		
		
		
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
		
	
	
	
