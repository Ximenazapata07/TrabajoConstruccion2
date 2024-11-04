/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import app.dao.interfeces.InvoiceDao;
import app.dao.jpaInterface.InvoiceRepository;
import app.dto.InvoiceDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;


/**
 *
 * @author ximez
 */
@Service
@NoArgsConstructor
@Getter
@Setter


public class InvoiceDaoImplementation implements InvoiceDao {
    InvoiceRepository invoiceRepository;
    @Override
    public long createInvoice(InvoiceDto invoice) throws Exception {
        invoiceRepository.save(invoice);
        return 0;
    }

    

 
    
}
