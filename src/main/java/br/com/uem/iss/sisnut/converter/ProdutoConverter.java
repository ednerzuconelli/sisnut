package br.com.uem.iss.sisnut.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uem.iss.sisnut.modelo.Produto;
import br.com.uem.iss.sisnut.servico.ProdutoServico;

@Service
@FacesConverter("produtoConverter")
public class ProdutoConverter implements Converter {
	
	@Autowired
	private ProdutoServico servico;

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
            	System.out.println("Teste do produto inserindo ");
                Produto produto = new Produto(); //servico.getById(Integer.parseInt(value));
                //System.out.println("Teste do produto inserindo "+ produto.getProduto().toString());
                return produto;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de Convers�o "+e, "Produto inv�lido."));
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Produto) object).getId());
        }
        else {
            return null;
        }
    }   
}     

