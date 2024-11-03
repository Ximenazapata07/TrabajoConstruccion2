/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ximez
 */

@Getter
@Setter
@NoArgsConstructor
public class CreateGuestRequests {
    
    private String partherId;
    private String name;
    private String userName;
    private String cellphone;
    private String document;
    private String password;
}
