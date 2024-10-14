package app.dao.interfeces;

import app.dto.InvoiceDto;

public interface InvoiceDao {
    public void createInvoice(InvoiceDto invoice) throws Exception;
    public InvoiceDto findById(InvoiceDto invoiceDto) throws Exception;
    
}
