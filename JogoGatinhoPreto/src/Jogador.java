import javax.swing.ImageIcon;


public class Jogador {
	protected String nome;
	protected ImageIcon imagemFundo;
	
	public Jogador(String nome, ImageIcon imagemFundo){
		this.nome = nome;
		this.imagemFundo = imagemFundo;
	}
	
	public ImageIcon getImagemFundo(){
		return this.imagemFundo;
	}
	
	public String getNome(){
		return this.nome;
	}
}
