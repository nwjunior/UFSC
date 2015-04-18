/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excessoes;

/**
 *
 * @author NildoJunior
 */
public class SenhaIncorretaException extends Exception{
    private String message;
    
    public SenhaIncorretaException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
