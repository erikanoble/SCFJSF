package edu.umt.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeConverter implements Converter{
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2){
		SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
		if(arg2== null || arg2.length()==0){
			return null;
		}
		try{
			Date timeAsDate = sdf.parse(arg2);
			return new Time(timeAsDate.getTime());
		}catch(ParseException pe){
			pe.printStackTrace();
		}
		return null;
	}
	
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2){
		SimpleDateFormat sdf = new SimpleDateFormat ("MMMM d, yyyy");
		if(arg2 != null){
			return sdf.format(arg2);
		}else{
			return "";
		}
	}
		
}
