package app.service.interfaces;

import app.dto.GuestDto;
import app.dto.InvoiceDetailDto;
import app.dto.InvoiceDto;


import java.util.List;


public interface PartherService {
    public void createGuest(GuestDto guestDto) throws Exception;
    public void createInvoice(InvoiceDto invoiceDto) throws Exception;
    

    public void createInvoiceDetails(List<InvoiceDetailDto> invoiceDetails) throws Exception;
	
}
