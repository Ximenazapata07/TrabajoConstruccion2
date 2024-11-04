/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao.jpaInterface;

import app.dto.InvoiceDto;
import app.model.Invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ximez
 */
@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceDto, Long>{

    public void save(Invoice invoices);

    
    
}
