/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import app.dao.interfeces.InvoiceDetailDao;
import app.dao.jpaInterface.InvoiceDetailRepository;
import app.dto.InvoiceDetailDto;
import app.model.InvoiceDetail;
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
public class InvoiceDetailDaoImplementation implements InvoiceDetailDao{
    @Autowired
    InvoiceDetailRepository invoiceDetailRepository;
    
    @Override
    public void createInvoiceDetail(InvoiceDetailDto invoiceDetailDto) throws Exception {
        invoiceDetailRepository.save(invoiceDetailDto);
    }
    
}
