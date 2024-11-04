package app.dao.interfeces;

import app.dto.InvoiceDto;

public interface InvoiceDao {
    public InvoiceDto createInvoice(InvoiceDto invoice) throws Exception;
   
    
}
