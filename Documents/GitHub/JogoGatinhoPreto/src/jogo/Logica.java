package jogo;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Excessoes.ExceptionNaoEhAVez;


public class Logica {
	Gato jogadorGato;
	Carrocinha jogadorCarrocinha;
	public Logica(Posicao posicaoInicial) {
		jogadorGato = new Gato("Jogador Gato", new ImageIcon(getClass().getResource("/imagem/gato.png")), posicaoInicial);
		jogadorCarrocinha = new Carrocinha("Jogador Carrocinha", new ImageIcon(getClass().getResource("/imagem/carrocinha.png")));
	}
	
	public boolean realizarMovimento(Posicao posicaoClicada, TipoJogador tipoJogador, TipoJogador jogadorVez) /*throws ExceptionNaoEhAVez*/{
		if(!posicaoClicada.getOcupada()){
		if(tipoJogador == jogadorVez){
			if(tipoJogador == TipoJogador.GATO){
				return this.realizarMovimentoGato(posicaoClicada);
			}
			else{
				if(tipoJogador == TipoJogador.CARROCINHA){
				return this.realizarMovimentoCarrocinha(posicaoClicada);	
				}
				return false;
			}
		}
		else{
			return false;
			//throw new ExceptionNaoEhAVez();
		}}
		else{
			return false;
		}
	}
	
	private boolean realizarMovimentoGato(Posicao posicaoClicada){
		boolean ehPossivel = false;
		Coordenada[] possiveis = jogadorGato.getPosicoesPossiveis();
		Posicao posicaoAtual = jogadorGato.getPosicaoAtual();
		for(int i = 0; i < 6 && !ehPossivel; i++){
			if(posicaoClicada.getCoordenada().equals(possiveis[i])){
				ehPossivel = true;
			}
		}
		if(ehPossivel){
			posicaoClicada.setOcupada(true);
			posicaoClicada.setImagemPosicao(jogadorGato.getImagemFundo());
			posicaoAtual.renderizaPosicao();
			jogadorGato.setPosicaoAtual(posicaoClicada);
			jogadorGato.atualizaPosicoesPossiveis();
			Jogada jogadaRealizada = new Jogada(posicaoClicada, this.verificaVencedorGato());
			return true;
		}
		else{
			JOptionPane.showMessageDialog(null, "Invalida");
			return false;
		}
	}
	
	public boolean realizarMovimentoCarrocinha(Posicao posicaoClicada){
		if(!posicaoClicada.getOcupada()){
			posicaoClicada.setOcupada(true);
			posicaoClicada.setIcon(jogadorCarrocinha.getImagemFundo());
			return true;
		}
		return false;
	}
	
	public boolean verificaVencedorCarrocinha(Tabuleiro tabuleiro){
		boolean vencedor = true;
		Coordenada[] possiveis = jogadorGato.getPosicoesPossiveis();
		for(int i = 0; i < 6 && vencedor; i++){
			if(!tabuleiro.verificaSePosicaoOcupada(possiveis[i])){
				vencedor = false;
			}
		}
		return vencedor;
	}
	
	
	public boolean verificaVencedorGato(){
		boolean vencedor;
		vencedor = jogadorGato.isVencedor();
		return vencedor;
	}
}
