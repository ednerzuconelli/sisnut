package br.com.uem.iss.sisnut.converter;

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

@Service
@FacesConverter(value="pacienteConverter")
public class PacienteConverter implements Converter {

	@Autowired
	private PacienteServico pacienteServico;

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if(value != null && value.trim().length() > 0) {
            try {
            	System.out.println("teste converter01 paciente "+value);

            	Paciente paciente = pacienteServico.findPacienteById(Integer.parseInt(value));
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
