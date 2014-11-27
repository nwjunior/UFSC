package jogo;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Posicao extends JButton{
	protected Coordenada coordenada;
	protected boolean ocupada;
	protected ImageIcon imagemPosicao;
	
	public Posicao(Coordenada coordenada, ImageIcon imagemPosicao, ActionListener actListener){
		this.coordenada = coordenada;
		this.imagemPosicao = imagemPosicao;
		renderizaPosicao();
		posicionaPosicao();
		this.addActionListener(actListener);
		this.setActionCommand("POSICAO");
	}

		public void renderizaPosicao(){
		this.setImagemPosicao(this.imagemPosicao);
		this.ocupada = false;
		//this.setRolloverIcon(new ImageIcon("muro.png"));
		this.setBorderPainted(false);
	}
	
	public void setImagemPosicao(ImageIcon imagemFundo){
		this.setIcon(imagemFundo);
	}
	
	public Coordenada getCoordenada(){
		return this.coordenada;
	}
	
	public boolean getOcupada(){
		return this.ocupada;
	}
	
	public void setOcupada(boolean ocupada){
		this.ocupada = ocupada;
	}
	
	private void posicionaPosicao(){
		int x = this.coordenada.getColuna() * 52;
		int y = this.coordenada.getLinha() * 50;

		if(this.coordenada.getLinha() % 2 != 0){ x += 26; }

		this.setBounds(x, y, 50, 50);
	}
	
}
