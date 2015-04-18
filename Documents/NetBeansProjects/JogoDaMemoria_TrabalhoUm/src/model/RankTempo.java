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
public class RankTempo implements Comparable<RankTempo>{
    private Usuario ususario;
    private long tempoJogo;

    public RankTempo(Usuario ususario, long tempoJogo) {
        this.ususario = ususario;
        this.tempoJogo = tempoJogo;
    }

    public Usuario getUsusario() {
        return ususario;
    }

    public long getTempoJogo() {
        return tempoJogo;
    }

    @Override
    public int compareTo(RankTempo o) {
            if(this.tempoJogo < o.getTempoJogo()){
            return -1;
        }
        else if(this.tempoJogo > o.getTempoJogo()){
            return 1;
        }
        else{
            return 0;
        }
    }
}