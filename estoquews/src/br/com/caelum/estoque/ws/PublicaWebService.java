/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.estoque.ws;

import javax.xml.ws.Endpoint;

/**
 *WSDL means Web Service Description Language 
 * 
 * @author eder
 */
public class PublicaWebService {
    
    public static void main(String[] args) {
        final EstoqueWS service = new EstoqueWS();
        final String url = "http://localhost:8080/estoquews";
        
        //responsable for associating the webservice with a url
         Endpoint.publish(url, service);
        
        
    }
    
}
