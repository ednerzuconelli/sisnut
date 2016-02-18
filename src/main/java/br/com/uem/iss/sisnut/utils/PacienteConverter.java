package br.com.uem.iss.sisnut.utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uem.iss.sisnut.modelo.Paciente;
import br.com.uem.iss.sisnut.servico.PacienteServico;

@Service
@FacesConverter("pacienteConverter")
public class PacienteConverter implements Converter {

	@Autowired
	private PacienteServico service;

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if(value != null && value.trim().length() > 0) {
            try {
            	System.out.println("teste converter01 paciente "+value);
            	service = (PacienteServico) fc.getExternalContext().getApplicationMap().get("serviceConverter");
            	System.out.println("teste converter02 paciente "+service);
            	Paciente paciente = service.findPacienteById(Integer.parseInt(value));
            	System.out.println("teste converter paciente "+Integer.parseInt(value));
                return paciente;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de Conversão "+e, "Paciente inválido."));
            }
        }
        else {
            return null;
        }
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if(object != null) {
			return String.valueOf(((Paciente) object).getCod());
        }
        else {
            return null;
        }
	}

}
