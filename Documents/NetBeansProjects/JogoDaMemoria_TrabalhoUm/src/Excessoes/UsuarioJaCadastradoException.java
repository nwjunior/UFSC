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
public class UsuarioJaCadastradoException extends Exception{
    private String message;
    
    public UsuarioJaCadastradoException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}