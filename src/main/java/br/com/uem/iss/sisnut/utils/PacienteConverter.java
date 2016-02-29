package br.com.uem.iss.sisnut.utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.uem.iss.sisnut.modelo.Paciente;
import br.com.uem.iss.sisnut.servico.PacienteServico;

@Component
@FacesConverter("pacienteConverter")
public class PacienteConverter implements Converter {

	@Autowired
	private PacienteServico pacienteServico;

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if(value != null && value.trim().length() > 0) {
            try {
            	System.out.println("teste converter01 paciente "+value);
<<<<<<< HEAD
            	Paciente paciente = new Paciente(); //pacienteServico.findPacienteById(Integer.parseInt(value));
=======
            	Paciente paciente = service.findPacienteById(Integer.parseInt(value));
>>>>>>> 2da9b508379e66d19595b1ae8b06d8fe965437eb
            	System.out.println("teste converter paciente "+Integer.parseInt(value));
                return paciente;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de Convers�o "+e, "Paciente inv�lido."));
            }
        }
        else {
            return null;
        }
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if ((object != null) && (object instanceof Paciente)) {
			return String.valueOf(((Paciente) object).getCod());
        }
        else {
            return null;
        }
	}

}
