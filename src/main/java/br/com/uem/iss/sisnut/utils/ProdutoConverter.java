package br.com.uem.iss.sisnut.utils;

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
                Produto produto = servico.getById(Integer.parseInt(value));
                return produto;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de Conversão "+e, "Produto inválido."));
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

