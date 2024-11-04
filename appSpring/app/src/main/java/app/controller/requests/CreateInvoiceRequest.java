/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller.requests;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ximez
 */

@Getter
@Setter
public class CreateInvoiceRequest {
    private String personId;
    private String partherId;
    private String total;
    private List<CreateInvoiceDetailRequest> details;
}
