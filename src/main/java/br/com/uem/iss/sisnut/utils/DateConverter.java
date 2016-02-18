package br.com.uem.iss.sisnut.utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

@FacesConverter(value="jodaDataTimeConverter")
public class DateConverter implements Converter {
	
private static final String PATTERN = "dd/MM/yyyy";
	
	
	public String format1(String data){
		if(data.contains("T")){
			return data.substring(0,  10 );
		}else return data;
	}
	
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		
		return DateTimeFormat.forPattern(PATTERN).parseDateTime(format1(String.valueOf(value)));
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent component, Object value) {
		
		DateTime dateTime = (DateTime) value; 

		return  dateTime.toString(PATTERN);
	}	
}
