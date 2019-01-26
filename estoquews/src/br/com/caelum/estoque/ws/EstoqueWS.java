/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.estoque.ws;

import br.com.caelum.estoque.modelo.usuario.AutorizacaoException;
import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ListaItens;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;
import br.com.caelum.estoque.modelo.usuario.Usuario;
import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * SOAP is a standard or a protocol that defines the XML which go through between Client and Server
 * when the we server is executed
 * 
 * SOAP Message consist in three part : SOAP-Env: Envelop
 *                                      SOAP-Env: Header  if exist, must be the first element
 *                                      SOAP-Env: Body
 * 
 * SOAP runs over HTTP but it doest depends on it. 
 * 
 * 
 * JAX-WS is a JAVAEE especification that works with SOAP within java, which is embeded into JRE since 1.6
 *                      
 * 
 * JAX-RS, especificação para criar serviços web baseado no REST
 * JAX-B, especificação para mapear (binding) XML para objetos Java
 * JAX-RPC, antigo padrão de serviços web, o nome antigo do JAX-WS
 * JAX-P, especificação para ler e escrever XML (processing)
 * 
 * 
 * to generate wsdl go to build/classes and execute
 * wsgen -wsdl -inlineSchemas -cp . br.com.caelum.estoque.ws.EstoqueWS
 * 
 * 
 * to generate artifacts
 * 
 * wsgen -verbose -keep -cp . br.com.caelum.estoque.ws.EstoqueWS
 * 
 *
 * @author eder
 */
// this annotation change the structure of SOAP Envelop
// ParameterStyle.BARE define that the soap envelop dont contains a wrapper for the itens
// use lnly with Style.DOCUMENT
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.BARE)
@WebService  //this annotation indicates that this class is a webservice
public class EstoqueWS {
    
    private ItemDao dao = new ItemDao();
  
//    //@WebMethod(operationName = "todosOsItem")
//    @WebResult(name = "item")
//    
//    // change the method name...similar to @RequestWrapper() in response SOAP
//    @ResponseWrapper(localName = "nomeDoResponse")
//    // change the method name...similar to @RequestWrapper() in request SOAP
//    @RequestWrapper(localName="nomeDoRequest")
//    public List<Item> getItems(@WebParam(name = "filtros") Filtros filtros) {
//        
//        List<Filtro> lista = filtros.getLista();
//        
//        return dao.todosItens(lista);
//  
//    }
    
    
    @WebMethod(operationName = "CadastrarItem")
    @WebResult(name = "item")
    public Item cadastrarItem(@WebParam(name = "tokenUsuario", header=true)  TokenUsuario tokenUsuario, @WebParam(name = "item") Item item) throws AutorizacaoException {
        
        System.out.println(tokenUsuario.getDataValidade());
        
        boolean valido = new TokenDao().ehValido(tokenUsuario);
        
        if(!valido) {
            throw new AutorizacaoException("A autorizacao falhou!");
        }
         
        dao.cadastrar(item);
        return item;
    }
    //action=CadastrarItemDoisAction  is used when thre are more than one method with same parameters. It will show at header as SoapAction
    /*
    avoiding
    
    S:Fault xmlns:ns4="http://www.w3.org/2003/05/soap-envelope">
         <faultcode>S:Client</faultcode>
         <faultstring>Cannot find dispatch method for Request=[SOAPAction="",Payload={http://ws.estoque.caelum.com.br/}item]</faultstring>
      </S:Fault>
    
    if there is more than one method that receives the same parameter list and.
    This happens only when using parameterStyle = ParameterStyle.BARE
    
    */
    
    @WebMethod(action="CadastrarItemDoisAction", operationName = "CadastrarItemDois")
    @WebResult(name = "item")
    public Item cadastrarItemDois(@WebParam(name = "tokenUsuario", header=true)  TokenUsuario tokenUsuario, @WebParam(name = "item") Item item) throws AutorizacaoException {
        
        System.out.println(tokenUsuario.getDataValidade());
        
        boolean valido = new TokenDao().ehValido(tokenUsuario);
        
        if(!valido) {
            throw new AutorizacaoException("A autorizacao falhou!");
        }
         
        dao.cadastrar(item);
        return item;
    }
    
    @Oneway //indicates this method doesn'' have a return 
    @WebMethod(operationName = "GerarRelatorio")
    public void gerarRelatorio() {
        
    }
    
    /*
    @WebResult(name = "items")
    @RequestWrapper(localName="nomeDoRequest")
    public ListaItens getItems(Filtros filtros) {
        
        List<Filtro> lista = filtros.getLista();
        
        List<Item> resultados = dao.todosItens(lista);
        
        return new ListaItens(resultados);
    } */
    
}
