package jogo;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Tabuleiro extends JPanel{
	
	protected Posicao [][] tabuleiro = new Posicao[11][11];
	protected Posicao posicaoInicial;
	
	public Tabuleiro(ActionListener actListener){
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		this.setBackground(new Color(255, 255, 255));
		
		for(int linha = 0; linha < 11; linha++){
			for(int coluna = 0; coluna < 11; coluna++){
				tabuleiro[linha][coluna] = new Posicao(new Coordenada(linha, coluna), new ImageIcon(getClass().getResource("/imagem/fundo.png")), actListener);
				this.add(tabuleiro[linha][coluna]);
			}
		}
		this.posicaoInicial = tabuleiro[5][5];
	}
	
	public boolean verificaSePosicaoOcupada(Coordenada coordenadaDaPosicao){
		return tabuleiro[coordenadaDaPosicao.getLinha()][coordenadaDaPosicao.getColuna()].getOcupada();
	}
	
	public Posicao[][] getTabuleuiro(){
		return this.tabuleiro;
	}
	
	public Posicao getPosicaoInicial(){
		return posicaoInicial;
	}
}
