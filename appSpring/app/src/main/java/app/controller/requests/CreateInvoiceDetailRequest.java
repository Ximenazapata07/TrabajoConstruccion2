/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller.requests;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ximez
 */

@Getter
@Setter
public class CreateInvoiceDetailRequest {
    private String amount;
    private String description;
}
