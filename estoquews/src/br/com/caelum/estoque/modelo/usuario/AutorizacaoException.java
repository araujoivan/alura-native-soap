/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.estoque.modelo.usuario;

import javax.xml.ws.WebFault;

/**
 *
 * @author eder
 */

//RuntimeException or unchecked exceptions are not describe in portType of wsdl file 

@WebFault(name = "AutorizacaoFault")
public class AutorizacaoException extends Exception {

    public AutorizacaoException(String token_Invalido) {
        super(token_Invalido);
    }
    
    //shows in the fault details response 
    public String getFaultInfo() {
        return "Este token não é valido";
    }
    
}
