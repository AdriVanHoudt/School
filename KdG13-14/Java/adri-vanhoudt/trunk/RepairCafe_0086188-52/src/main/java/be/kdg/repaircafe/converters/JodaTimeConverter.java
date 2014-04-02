package be.kdg.repaircafe.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Adri
 */
@FacesConverter("jodaConverter")
public class JodaTimeConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        DateTimeFormatter fmt = (DateTimeFormatter)DateTimeFormat.forPattern("MM/dd/yy");
        return fmt.parseDateTime(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       DateTimeFormatter fmt = (DateTimeFormatter)DateTimeFormat.forPattern("MM/dd/yy");
       String str = fmt.print((DateTime)value);
       
       return str;
    }
}
