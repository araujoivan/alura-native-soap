/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.estoque.cliente;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author eder
 */
public class Cliente {
    
    
    public static void main(String[] args) throws Exception {

        secondAlternative();
    }
    
     public static void secondAlternative() throws MalformedURLException {
         
         URL url = new URL("http://localhost:8080/estoquews-web/EstoqueWSImpl?wsdl");
      
         
         QName qname = new QName("http://ws.estoque.caelum.com.br/", "EstoqueWSImplService");
         
         Service service = Service.create(url, qname);
         
         EstoqueWS cliente = service.getPort(EstoqueWS.class);
         
         ListaItens lista = cliente.todosOsItens(getFiltros());
        
         System.out.println(lista.getItem());
         
     }
    
    public static void firstAlternative() {
                                       //Fab design pattern
        EstoqueWS cliente = new EstoqueWSImplService().getEstoqueWSImplPort();
               
        ListaItens lista = cliente.todosOsItens(getFiltros());
        
        System.out.println(lista.getItem());
    }
    
    public static Filtros getFiltros() {
        Filtro filtro = new Filtro();
        
        filtro.setNome("IPhone");
        filtro.setTipo(TipoItem.CELULAR.name());
        
        Filtros filtros = new Filtros();
        
        filtros.getFiltro().add(filtro);
        
        return filtros;
    }
    
}
