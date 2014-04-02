/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.repaircafemodel.service.exceptions;

/**
 *
 * @author deketelw
 */
public class UserServiceException extends Exception
{
    /**
     * Deze exception wordt gesmeten wanneer iets fout gaat met gebruikers
     * Bijvoorbeeld: fout password of foute gebruikersnaam
     * @param message 
     */
    public UserServiceException(String message)
    {
        super(message);
    }
}
