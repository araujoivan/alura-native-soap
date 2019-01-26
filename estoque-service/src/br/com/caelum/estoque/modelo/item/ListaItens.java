package br.com.caelum.estoque.modelo.item;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ListaItens {

    @XmlElement(name="item")
    private List<Item> itens;

    
    public ListaItens(List<Item> itens) {
        this.itens = itens;
    }

    //a contructor without attributes is mandatory
    //when using jax-b
    ListaItens() {
    }

   
    public List<Item> getItens() {
        return itens;
    }

}
