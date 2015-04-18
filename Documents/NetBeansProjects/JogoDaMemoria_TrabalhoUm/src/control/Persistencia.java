/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Excessoes.UsuarioJaCadastradoException;
import Excessoes.UsuarioNaoCadastradoException;
import enums.Sexo;
import model.RankJogadas;
import model.RankTempo;
import model.Usuario;

/**
 *
 * @author NildoJunior
 */
public interface Persistencia {
    
    public boolean existeUsuario(String login);
    public Usuario getUsuario(String login) throws UsuarioNaoCadastradoException;
    public boolean adicionarUsuario(String login, String senha, String nome, String cpf, String dataDeNascimento, Sexo sexo) throws UsuarioJaCadastradoException;
    public boolean removerUsuario(String login) throws UsuarioNaoCadastradoException;
    public RankJogadas[] getRankDeJogadasOrdenado();
    public RankTempo[] getRankDeTemposOrdenado();
    public void adicionarAoRankDeJogadas(RankJogadas registro);
    public void adicionarAoRankDeTempos(RankTempo registro);
}
