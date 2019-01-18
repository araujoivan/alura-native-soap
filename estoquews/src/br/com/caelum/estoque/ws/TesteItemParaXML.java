/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.estoque.ws;

import br.com.caelum.estoque.modelo.item.Item;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author eder
 */
public class TesteItemParaXML {
    
    public static void main(String[] args) throws JAXBException {
        
        Item item = new Item.Builder().comCodigo("33").comNome("Asus").comTipo("Notebook").comQuantidade(3).build();
        
        JAXBContext context = JAXBContext.newInstance(Item.class);
        
        Marshaller marshaller = context.createMarshaller();
        
        marshaller.marshal(item, new File("item.xml"));

    }
    
}
