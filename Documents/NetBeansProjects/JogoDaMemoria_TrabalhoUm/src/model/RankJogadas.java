/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author NildoJunior
 */
public class RankJogadas implements Comparable<RankJogadas>{
    private Usuario usuario;
    private int numeroJogadas;

    public RankJogadas(Usuario usuario, int numeroJogadas) {
        this.usuario = usuario;
        this.numeroJogadas = numeroJogadas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public int getNumeroJogadas() {
        return numeroJogadas;
    }

    @Override
    public int compareTo(RankJogadas o) {
        if(this.numeroJogadas < o.getNumeroJogadas()){
            return -1;
        }
        else if(this.numeroJogadas > o.getNumeroJogadas()){
            return 1;
        }
        else{
            return 0;
        }
    }
}