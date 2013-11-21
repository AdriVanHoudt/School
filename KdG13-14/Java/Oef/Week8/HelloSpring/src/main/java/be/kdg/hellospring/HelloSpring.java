/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.kdg.hellospring;

import javax.inject.Named;

/**
 *
 * @author Adri
 */
@Named("hello")
public class HelloSpring implements Hello{
    
    public void print(String string){
        System.out.println(string);
    }
    
}
