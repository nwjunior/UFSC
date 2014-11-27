package jogo;
import javax.swing.ImageIcon;


public class Gato extends Jogador{

	protected Posicao posicaoAtual;
	protected Coordenada[] posicoesPossiveis = new Coordenada[6];
	
	public Gato(String nome, ImageIcon imagemFundo, Posicao posicaoAtual) {
		super(nome, imagemFundo);
		this.posicaoAtual = posicaoAtual;
		this.posicaoAtual.setImagemPosicao(imagemFundo);
		this.atualizaPosicoesPossiveis();
	}
	
	public Posicao getPosicaoAtual(){
		return this.posicaoAtual;
	}
	
	public void setPosicaoAtual(Posicao posicaoAtual){
		this.posicaoAtual = posicaoAtual;
	}
	
	public void atualizaPosicoesPossiveis(){
		int linhaAtual = this.getPosicaoAtual().getCoordenada().getLinha();
		int colunaAtual = this.getPosicaoAtual().getCoordenada().getColuna();
		
		boolean ehLinhaPar = linhaAtual % 2 == 0;
		
		if(ehLinhaPar){
			posicoesPossiveis[0] = new Coordenada(linhaAtual - 1, colunaAtual - 1);
			posicoesPossiveis[1] = new Coordenada(linhaAtual, colunaAtual - 1);
			posicoesPossiveis[2] = new Coordenada(linhaAtual + 1, colunaAtual - 1);
			posicoesPossiveis[3] = new Coordenada(linhaAtual + 1, colunaAtual);
			posicoesPossiveis[4] = new Coordenada(linhaAtual, colunaAtual + 1);
			posicoesPossiveis[5] = new Coordenada(linhaAtual - 1, colunaAtual);
		}
		else{ //Linha impar
			posicoesPossiveis[0] = new Coordenada(linhaAtual - 1, colunaAtual);
			posicoesPossiveis[1] = new Coordenada(linhaAtual, colunaAtual - 1);
			posicoesPossiveis[2] = new Coordenada(linhaAtual + 1, colunaAtual);
			posicoesPossiveis[3] = new Coordenada(linhaAtual + 1, colunaAtual + 1);
			posicoesPossiveis[4] = new Coordenada(linhaAtual, colunaAtual + 1);
			posicoesPossiveis[5] = new Coordenada(linhaAtual - 1, colunaAtual + 1);
		}
	}
	
	public boolean isVencedor(){
		boolean ehVencedor = false;
		
		int linha = this.getPosicaoAtual().getCoordenada().getLinha();
		int coluna = this.getPosicaoAtual().getCoordenada().getColuna();
		
		if(linha == 0 || linha == 10 || coluna == 0 || coluna == 10){
			ehVencedor = true;
		}
		
		return ehVencedor;
	}

	public Coordenada[] getPosicoesPossiveis(){
		return this.posicoesPossiveis;
	}
}
