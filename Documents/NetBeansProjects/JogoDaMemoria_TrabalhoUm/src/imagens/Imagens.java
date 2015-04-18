/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagens;

/**
 *
 * @author NildoJunior
 */
public enum Imagens {
    
    LUFFY(1, Caminho.base + "Luffy.png", "Luffy"),
    ACE(2, Caminho.base + "ace.png", "Ace"),
    BROOK(3, Caminho.base + "brook.png", "Brook"),
    CHOPPER(4, Caminho.base + "chopper.png", "Chopper"),
    FRANKY(5, Caminho.base + "franky.png", "Franky"),
    NAMI(6, Caminho.base + "nami.png", "Nami"),
    ROBIN(7, Caminho.base + "robin.png", "Robin"),
    SANJI(8, Caminho.base + "sanji.png", "Sanji"),
    USOPP(9, Caminho.base + "usopp.png", "Usopp"),
    ZORO(10, Caminho.base + "zoro.png", "Zoro"),
    ONE_PIECE(11, Caminho.base + "One_Piece_Logo.png", "One piece"),
    TREASURE(12, Caminho.base + "Treasure_Chest.png", "Treasure");
    
    private int id;
    private String caminho;
    private String nome;

    private Imagens(int id, String caminho, String nome){
        this.id = id;
        this.caminho = caminho;
        this.nome = nome;
    }

    public int getId(){
        return this.id;
    }
    public String getCaminho(){
        return this.caminho;
    }

    public String getNome(){
        return this.nome;
    }
    
    public class Caminho{public static final String base = "/imagens/";}
}