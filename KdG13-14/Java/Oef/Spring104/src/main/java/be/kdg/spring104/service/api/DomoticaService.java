/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.spring104.service.api;

import be.kdg.spring104.model.Meting;
import java.util.List;

/**
 *
 * @author wouter
 */
public interface DomoticaService
{
    public List<Meting> getMetingen(String kamer);
    public List<String> getKamers();
}
