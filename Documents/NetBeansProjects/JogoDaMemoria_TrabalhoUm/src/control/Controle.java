/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


/**
 *
 * @author NildoJunior
 */
import Excessoes.CamposObrigatoriosNaoPreenchidosException;
import Excessoes.SenhaEConfirmacaoDeSenhaDiferentesException;
import Excessoes.SenhaIncorretaException;
import Excessoes.UsuarioJaCadastradoException;
import Excessoes.UsuarioNaoCadastradoException;
import enums.Sexo;
import imagens.*;
import java.util.Collections;
import java.util.LinkedList;
import model.RankJogadas;
import model.RankTempo;
import model.Usuario;

public class Controle {
    private static Controle controle;
    private Usuario usuarioLogado;
    private Persistencia persistencia;
    private boolean segundoClick;
    private String idPrimeiroClick;
    private int qtdClicks;
    private String[] caminhosImagens;
    private String idSegundoClick;
    private int qtdCartasViradas;
    long inicio;
    long fim;
    
    private Controle(){
        persistencia = new PersistenciaLocal();
        this.zerarContadores();
    }
    
    public static Controle getInstance() {
        if(controle == null){
            controle = new Controle();
        }
        return controle;
    }
    
    public void zerarContadores(){
        segundoClick = false;
        idPrimeiroClick = "";
        qtdClicks = 0;
        qtdCartasViradas = 0;
    }
    
    public boolean adicionarUsuario(String login, String senha, String confirmacaoSenha, String nome, String cpf, String dataDeNascimento, Sexo sexo) throws UsuarioJaCadastradoException, SenhaEConfirmacaoDeSenhaDiferentesException, CamposObrigatoriosNaoPreenchidosException{
        if(login.equals("") || senha.equals("") || confirmacaoSenha.equals("")){
            throw new CamposObrigatoriosNaoPreenchidosException("Os campos Login, Senha e Confirmação de senha são de preenchimento obrigatório");
        }
        if(senha.equals(confirmacaoSenha)){
             try{
               return persistencia.adicionarUsuario(login, senha, nome, cpf, dataDeNascimento, sexo);
            }catch(UsuarioJaCadastradoException e){
                throw e;
            }
        }
        else{
           throw new SenhaEConfirmacaoDeSenhaDiferentesException("A senha e a confirmação de senha são diferentes");
        }
    }
    
    public boolean removerUsuario(String login) throws UsuarioNaoCadastradoException{
        try{
            return persistencia.removerUsuario(login);
        }catch(UsuarioNaoCadastradoException e){
            throw e;
        }
    }
    
    public boolean realizarLogin(String login, String senha) throws UsuarioNaoCadastradoException, SenhaIncorretaException{
        try{
            String senhaCadastrada = persistencia.getUsuario(login).getSenha();
            if(senhaCadastrada.equals(senha)){
                this.usuarioLogado = persistencia.getUsuario(login);
                return true;
            }
            else{
                throw new SenhaIncorretaException("A senha digitada não pertence ao login informado");
            }
        }catch(UsuarioNaoCadastradoException e){
            throw e;
        }
    }
    
    public boolean isSegundoClick(){
        return this.segundoClick;
    }
    
    /**
     * @param idClick
     */
    public void enviaClick(String idClick){
        if(!segundoClick){
            segundoClick = true;
            idPrimeiroClick = idClick;
        }
        else{
            segundoClick = false;
            idSegundoClick = idClick;
            qtdClicks++;
        }
    }

    public boolean cartasIguais(){
        int id1 = Integer.parseInt(idPrimeiroClick);
        int id2 = Integer.parseInt(idSegundoClick);
        return caminhosImagens[id1].equals(caminhosImagens[id2]);
    }

    public int getQtdCartasViradas() {
        return qtdCartasViradas;
    }

    public void atualizaQtdCartasViradas() {
        this.qtdCartasViradas++;
    }

    public void setInicio(long inicio) {
        this.inicio = inicio;
    }

    public void setFim(long fim) {
        this.fim = fim;
    }
    
    public long getDuracaoPartida(){
        long duracao = this.fim - this.inicio;
        duracao /= 1000;
        return duracao;
    }
    
    
    public String getIdPrimeiroClick(){
        return idPrimeiroClick;
    }
    
    public boolean vencedor(){
        return qtdCartasViradas == 10;
    }
    
    public String getIdSegundoClick(){
        return idSegundoClick;
    }
    
    public String[] getImagensEmbaralhadas(){
        return caminhosImagens;
    }
    
    public String getCaminhoImagem(String idClick){
        int id = Integer.parseInt(idClick);
        return caminhosImagens[id];
    }
    
    public String getQuantidadeJogadas() {
        return String.valueOf(qtdClicks);
    }
    
    public void embaralharImagens(){
        LinkedList<String> caminhosEmbaralhados = new LinkedList<>();
        caminhosEmbaralhados.addLast(Imagens.ACE.getCaminho());
        caminhosEmbaralhados.addLast(Imagens.BROOK.getCaminho());
        caminhosEmbaralhados.addLast(Imagens.CHOPPER.getCaminho());
        caminhosEmbaralhados.addLast(Imagens.FRANKY.getCaminho());
        caminhosEmbaralhados.addLast(Imagens.NAMI.getCaminho());
        caminhosEmbaralhados.addLast(Imagens.ROBIN.getCaminho());
        caminhosEmbaralhados.addLast(Imagens.SANJI.getCaminho());
        caminhosEmbaralhados.addLast(Imagens.USOPP.getCaminho());
        caminhosEmbaralhados.addLast(Imagens.ZORO.getCaminho());
        caminhosEmbaralhados.addLast(Imagens.LUFFY.getCaminho());
        caminhosEmbaralhados.addLast(Imagens.ACE.getCaminho());
        caminhosEmbaralhados.addLast(Imagens.BROOK.getCaminho());
        caminhosEmbaralhados.addLast(Imagens.CHOPPER.getCaminho());
        caminhosEmbaralhados.addLast(Imagens.FRANKY.getCaminho());
        caminhosEmbaralhados.addLast(Imagens.NAMI.getCaminho());
        caminhosEmbaralhados.addLast(Imagens.ROBIN.getCaminho());
        caminhosEmbaralhados.addLast(Imagens.SANJI.getCaminho());
        caminhosEmbaralhados.addLast(Imagens.USOPP.getCaminho());
        caminhosEmbaralhados.addLast(Imagens.ZORO.getCaminho());
        caminhosEmbaralhados.addLast(Imagens.LUFFY.getCaminho());

        Collections.shuffle(caminhosEmbaralhados);
            
        caminhosImagens = caminhosEmbaralhados.toArray(new String[caminhosEmbaralhados.size()]);
    }
    
    public String[][] getRankDeJogadasOrdenado(){
        String[][] aux = new String[10][2];
        RankJogadas[] rj = persistencia.getRankDeJogadasOrdenado();
        if(rj != null){
            for(int i = 0; i < rj.length; i++){
                aux[i][0] = rj[i].getUsuario().getLogin();
                aux[i][1] = String.valueOf(rj[i].getNumeroJogadas());
            }
        }
        return aux;
    }
    
    public String[][] getRankDeTemposOrdenado(){
        String[][] aux = new String[10][2];
        RankTempo[] rt = persistencia.getRankDeTemposOrdenado();

        if(rt != null){
            for(int i = 0; i < rt.length; i++){
                aux[i][0] = rt[i].getUsusario().getLogin();
                aux[i][1] = String.valueOf(rt[i].getTempoJogo()) + "seg";
            }
        }
        return aux;
    }
    
    public void adicionarAoRankDeJogadas() {
        persistencia.adicionarAoRankDeJogadas(new RankJogadas(this.usuarioLogado, this.qtdClicks));
    }
    
    public void adicionarAoRankDeTempos() {
        persistencia.adicionarAoRankDeTempos(new RankTempo(this.usuarioLogado, this.getDuracaoPartida()));
    }
}
