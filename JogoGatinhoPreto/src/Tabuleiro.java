import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Tabuleiro extends JPanel{
	
	protected Posicao [][] tabuleiro = new Posicao[11][11];
	
	public Tabuleiro(ActionListener actListener){
		for(int linha = 0; linha < 11; linha++){
			for(int coluna = 0; coluna < 11; coluna++){
				tabuleiro[linha][coluna] = new Posicao(new Coordenada(linha, coluna), new ImageIcon("davidViado.png"), actListener);
				this.add(tabuleiro[linha][coluna]);
			}
		}
	}
}
