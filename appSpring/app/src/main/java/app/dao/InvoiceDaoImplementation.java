/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import app.dao.interfeces.InvoiceDao;
import app.dao.jpaInterface.InvoiceRepository;
import app.dto.InvoiceDto;
import app.helpers.Helper;
import app.model.Invoice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public InvoiceDto createInvoice(InvoiceDto invoiceDto) throws Exception {
        Invoice invoice = Helper.parse(invoiceDto);
        return (Helper.parse(invoiceRepository.save(invoice)));
    }
    
    

    

 
    
}
