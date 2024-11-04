/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao.jpaInterface;

import app.dto.InvoiceDetailDto;
import app.model.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ximez
 */
@Repository
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long> {

    public void save(InvoiceDetailDto invoiceDetailDto);
    
}
