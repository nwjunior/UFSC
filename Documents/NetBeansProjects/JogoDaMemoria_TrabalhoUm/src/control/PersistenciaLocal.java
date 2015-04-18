/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Excessoes.UsuarioJaCadastradoException;
import Excessoes.UsuarioNaoCadastradoException;
import enums.Sexo;
import java.util.Collections;
import java.util.LinkedList;
import model.RankJogadas;
import model.RankTempo;
import model.Usuario;

/**
 *
 * @author NildoJunior
 */
public class PersistenciaLocal implements Persistencia{
    private LinkedList<Usuario> listaDeUsuarios;
    private LinkedList<RankJogadas> rankDeJogadas;
    private LinkedList<RankTempo> rankDeTempos;
    
    public PersistenciaLocal(){
        listaDeUsuarios = new LinkedList<>();
        listaDeUsuarios.addLast(new Usuario("admin", "123456", "admin", "877.000.000-00", "02/12/1994", Sexo.MASCULINO));
        rankDeJogadas = new LinkedList<>();
        rankDeTempos = new LinkedList<>();
    }
    
    @Override
    public boolean existeUsuario(String login) {
        for(Usuario u : listaDeUsuarios){
            if(u.getLogin().equals(login))
                return true;
        }
        return false;
    }

    @Override
    public Usuario getUsuario(String login) throws UsuarioNaoCadastradoException {
        for(Usuario u : listaDeUsuarios){
            if(u.getLogin().equals(login))
                return u;
        }
        throw new UsuarioNaoCadastradoException("Usuário " + login + " não está cadastrado.");
    }

    @Override
    public boolean adicionarUsuario(String login, String senha, String nome, String cpf, String dataDeNascimento, Sexo sexo) throws UsuarioJaCadastradoException {
        if(!this.existeUsuario(login)){
            Usuario aux;
            aux = new Usuario(login, senha, nome, cpf, dataDeNascimento, sexo);
            this.listaDeUsuarios.addLast(aux);
            return true;
        }
        else{
            throw new UsuarioJaCadastradoException("Usuário " + login + "já está cadastrado");
        }
    }

    @Override
    public boolean removerUsuario(String login) throws UsuarioNaoCadastradoException{
        for(Usuario u : listaDeUsuarios){
            if(u.getLogin().equals(login)){
                this.listaDeUsuarios.remove(u);
                return true;
            }
        }
        throw new UsuarioNaoCadastradoException("Usuário " + login + " não está cadastrado.");
    }

    @Override
    public RankJogadas[] getRankDeJogadasOrdenado() {
        Collections.sort(this.rankDeJogadas);
        if(this.rankDeJogadas.size() == 0){
            return null;
        }
        else{
            return this.rankDeJogadas.toArray(new RankJogadas[this.rankDeJogadas.size()]);
        }
    }

    @Override
    public RankTempo[] getRankDeTemposOrdenado() {
        Collections.sort(this.rankDeTempos);
        if(this.rankDeTempos.size() == 0){
            return null;
        }
        else{
            return this.rankDeTempos.toArray(new RankTempo[this.rankDeTempos.size()]);
        }
    }

    @Override
    public void adicionarAoRankDeJogadas(RankJogadas registro) {
        if(this.rankDeJogadas.size() == 10){
            Collections.sort(this.rankDeJogadas);
            int ultimoLista = this.rankDeJogadas.getLast().getNumeroJogadas();
            int novoRegistro = registro.getNumeroJogadas();
            if(ultimoLista > novoRegistro){
                this.rankDeJogadas.removeLast();
                this.rankDeJogadas.addLast(registro);
            }
        }
        else{
            this.rankDeJogadas.addLast(registro);
        }
    }

    @Override
    public void adicionarAoRankDeTempos(RankTempo registro) {
        if(this.rankDeTempos.size() == 10){
            Collections.sort(this.rankDeTempos);
            long ultimoLista = this.rankDeTempos.getLast().getTempoJogo();
            long novoRegistro = registro.getTempoJogo();
            if(ultimoLista > novoRegistro){
                this.rankDeTempos.removeLast();
                this.rankDeTempos.addLast(registro);
            }
        }
        else{
            this.rankDeTempos.addLast(registro);
        }
    }
}