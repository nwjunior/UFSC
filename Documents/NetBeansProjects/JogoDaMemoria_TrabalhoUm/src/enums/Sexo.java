/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author NildoJunior
 */
public enum Sexo {
    
    MASCULINO(1, "Masculino"),
    FEMININO(2, "Feminino");
    
    private int id;
    private String nome;
    
    private Sexo(int id, String nome){
        this.id = id;
        this.nome = nome;
    }
    
    public String getDescricao(){
        return this.nome;
    }
    
    public static String getDescricao(int id){
        switch(id){
            case 1:
                return FEMININO.getDescricao();
            case 2:
                return MASCULINO.getDescricao();
            default:
                return null;
        }
    }
}
