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
public class SenhaEConfirmacaoDeSenhaDiferentesException extends Exception{
    private String message;
    
    public SenhaEConfirmacaoDeSenhaDiferentesException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}