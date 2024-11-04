package app.dao.interfeces;

import app.dto.InvoiceDto;

public interface InvoiceDao {
    public long createInvoice(InvoiceDto invoice) throws Exception;
   
    
}
