package app.controller;

import app.controller.requests.CreateGuestRequests;
import app.controller.requests.CreateInvoiceDetailRequest;
import app.controller.requests.CreateInvoiceRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.controller.validator.PersonValidator;
import app.controller.validator.UserValidator;
import app.dto.GuestDto;
import app.dto.InvoiceDto;
import app.dto.PersonDto;
import app.dto.UserDto;
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
	
        @PostMapping("/billing")
	public ResponseEntity billing(@RequestBody CreateInvoiceRequest invoiceRequest) throws Exception {
            InvoiceDto invoiceDto = new InvoiceDto();
            invoiceDto.setConsumptionDate(new Date(System.currentTimeMillis()));
		
            PartherDto partherDto = new PartherDto();
            partherDto.setId(personValidator.isValidLong("Id del socio", invoiceRequest.getPartherId()));
            invoiceDto.setPartherId(partherDto);
		
            PersonDto personDto = new PersonDto();
            personDto.setId(personValidator.isValidLong("Id de la persona", invoiceRequest.getPersonId()));
            invoiceDto.setPersonId(personDto);
		
		// falta validador del total 
           
            invoiceDto.setTotal(Double.parseDouble(invoiceRequest.getTotal()));
		
            service.createInvoice(invoiceDto);
		
            int detailsCount = 0;
            List<InvoiceDetailDto> invoiceDetails = new ArrayList<InvoiceDetailDto>();
		
            for(CreateInvoiceDetailRequest invoiceDetailRequest: invoiceRequest.getDetails()) {
                InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
                invoiceDetailDto.setAmount(Double.parseDouble(invoiceDetailRequest.getAmount()));
                invoiceDetailDto.setDescription(invoiceDetailRequest.getDescription());
                invoiceDetailDto.setItem(++detailsCount);
                invoiceDetails.add(invoiceDetailDto);
                invoiceDetailDto.setInvoiceid(invoiceDto);
		}
		
            service.createInvoiceDetails(invoiceDetails);
		
            return new ResponseEntity<>("Se ha creado la factura exitosamente", HttpStatus.OK);
		
	}
        }     
		
	
	

