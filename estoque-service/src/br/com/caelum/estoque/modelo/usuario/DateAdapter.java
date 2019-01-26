/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.estoque.modelo.usuario;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author eder
 */
public class DateAdapter extends XmlAdapter<String, Date> {
    
    private String pattern = "dd/MM/yyyy";

    @Override
    public Date unmarshal(String v) throws Exception {
        return new SimpleDateFormat(pattern).parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return new SimpleDateFormat(pattern).format(v);
    }  
}
