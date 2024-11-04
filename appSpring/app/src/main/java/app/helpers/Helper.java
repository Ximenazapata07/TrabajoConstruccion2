package app.helpers;
import app.dto.GuestDto;
import app.dto.InvoiceDetailDto;
import app.dto.InvoiceDto;
import app.dto.PartherDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.model.Guest;
import app.model.Invoice;
import app.model.InvoiceDetail;
import app.model.Parther;
import app.model.Person;
import app.model.User;



public abstract class Helper {
	
	public static PersonDto parse(Person person) {
		PersonDto personDto = new PersonDto();
		personDto.setId(person.getId());
		personDto.setDocument(person.getDocument());
		personDto.setCellnumber(person.getCellnumber());
		personDto.setName(person.getName());
		return personDto;
	}
	
	public static Person parse(PersonDto personDto) {
		Person person= new Person();
		person.setId(personDto.getId());
		person.setCellnumber(personDto.getCellnumber());
		person.setDocument(personDto.getDocument());
		person.setName(personDto.getName());
		return person;
	}
	
	public static UserDto parse (User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setPassword(user.getPassword());
		userDto.setPersonId(parse(user.getPersonId()));
		userDto.setRole(user.getRole());
		userDto.setUserName(user.getUserName());
		return userDto;
		
	}
	
	public static User parse(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setPassword(userDto.getPassword());
		user.setPersonId(parse(userDto.getPersonId()));
		user.setRole(userDto.getRole());
		user.setUserName(userDto.getUserName());
		return user;
	}
	public static PartherDto parse (Parther parther) {
		PartherDto partherDto = new PartherDto();
		partherDto.setId(parther.getId());
		partherDto.setSubscriptionType(parther.getSubscriptionType());
		partherDto.setAvailableFunds(parther.getAvailableFunds());
		partherDto.setMembersphipDate(parther.getMembersphipDate());
		partherDto.setUserId(parse(parther.getUserId()));
		return partherDto;
		
	}
	
	public static Parther parse (PartherDto partherDto) {
		Parther parther = new Parther();
		parther.setId(partherDto.getId());
		parther.setSubscriptionType(partherDto.getSubscriptionType());
		parther.setAvailableFunds(partherDto.getAvailableFunds());
		parther.setMembersphipDate(partherDto.getMembersphipDate());
		parther.setUserId(parse(partherDto.getUserId()));
		return parther;
		
	}
	
	public static Guest parse(GuestDto guestDto) {
		Guest guest = new Guest();
		guest.setId(guestDto.getId());
		guest.setUserId(parse(guestDto.getUserId()));
		guest.setPartherId(parse(guestDto.getPartherId()));
		guest.setGuestStatus(guestDto.getGuestStatus());
		return guest;
		
	}

	public static GuestDto parse(Guest guest) {
		GuestDto guestDto = new GuestDto();
		guestDto.setId(guest.getId());
		guestDto.setPartherId(parse(guest.getPartherId()));
		guestDto.setUserId(parse(guest.getUserId()));
		guestDto.setGuestStatus(guest.getGuestStatus());
		return guestDto;
				
		
	}
        
        public static Invoice parse(InvoiceDto invoiceDto){
            Invoice invoice = new Invoice();
            invoice.setConsumptionDate(invoiceDto.getConsumptionDate());
            invoice.setPartherId(parse(invoiceDto.getPartherId()));
            invoice.setPersonId(parse(invoiceDto.getPersonId()));
            invoice.setTotal(invoiceDto.getTotal());
            invoice.setId(invoiceDto.getId());
            return invoice;
            
        }
        
        public static InvoiceDto parse (Invoice invoice){
            InvoiceDto invoiceDto = new InvoiceDto();
            invoiceDto.setConsumptionDate(invoice.getConsumptionDate());
            invoiceDto.setPartherId(parse(invoice.getPartherId()));
            invoiceDto.setPersonId(parse(invoice.getPersonId()));
            invoiceDto.setTotal(invoice.getTotal());
            invoiceDto.setId(invoice.getId());
            return invoiceDto;
        }
        
        public static InvoiceDetail parse (InvoiceDetailDto invoiceDetailDto){
            InvoiceDetail invoiceDetail = new InvoiceDetail();
            invoiceDetail.setItem(invoiceDetailDto.getItem());
            invoiceDetail.setAmount(invoiceDetailDto.getAmount());
            invoiceDetail.setInvoiceid(parse(invoiceDetailDto.getInvoiceid()));
            invoiceDetail.setDescription(invoiceDetailDto.getDescription());
            invoiceDetail.setInvoiceid(Helper.parse(invoiceDetailDto.getInvoiceid()));
            invoiceDetail.setId(invoiceDetailDto.getId());
            return invoiceDetail;
          
        }
        
        public static InvoiceDetailDto parse(InvoiceDetail invoiceDetail){
            InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
            invoiceDetailDto.setItem(invoiceDetail.getItem());
            invoiceDetailDto.setAmount(invoiceDetail.getAmount());
            invoiceDetailDto.setInvoiceid(parse(invoiceDetail.getInvoiceid()));
            invoiceDetailDto.setId(invoiceDetail.getId());
            invoiceDetailDto.setDescription(invoiceDetail.getDescription());
            return invoiceDetailDto;
        }
}
