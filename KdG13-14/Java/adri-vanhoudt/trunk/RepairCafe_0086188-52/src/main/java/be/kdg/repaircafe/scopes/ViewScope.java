/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.repaircafe.scopes;

/**
 * Custom made scope
 * 
 * This custom made "View" Scope class gives support for 
 * a Spring Scope equivalent of the JSF View Scope. 
 * 
 * This can be used for wizards. A Viewscoped Bean stays in memory
 * as long as the view doesn't change.
 * 
 * @author wouter
 */
import java.util.Map;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class ViewScope implements Scope
{

    @Override
    public Object get(String name, ObjectFactory objectFactory)
    {
        Map<String, Object> viewMap = FacesContext.getCurrentInstance().getViewRoot().getViewMap();

        if (viewMap.containsKey(name))
        {
            return viewMap.get(name);
        }
        else
        {
            Object object = objectFactory.getObject();
            viewMap.put(name, object);

            return object;
        }
    }

    @Override
    public Object remove(String name)
    {
        return FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove(name);
    }

    @Override
    public String getConversationId()
    {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback)
    {
        //Not supported
    }

    @Override
    public Object resolveContextualObject(String key)
    {
        return null;
    }
}
