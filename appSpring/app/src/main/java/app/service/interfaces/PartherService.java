package app.service.interfaces;

import app.dto.GuestDto;
import app.dto.InvoiceDetailDto;


import java.util.List;


public interface PartherService {
	public void createGuest(GuestDto guestDto) throws Exception;
	public void createInvoice(List<InvoiceDetailDto> invoices) throws Exception;
	
	
}
