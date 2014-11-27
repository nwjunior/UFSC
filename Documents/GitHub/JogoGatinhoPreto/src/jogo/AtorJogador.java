package jogo;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;


public class AtorJogador extends JFrame implements ActionListener{
	protected Tabuleiro tabuleiro;
	protected Logica logica;
	protected TipoJogador tipoJogador;
	protected TipoJogador jogadorDaVez;
	
	public AtorJogador (){
		this.tabuleiro = new Tabuleiro(this);
		this.logica = new Logica(this.tabuleiro.getPosicaoInicial());
		tipoJogador = TipoJogador.GATO;
		jogadorDaVez = TipoJogador.GATO;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 615, 615);
		setContentPane(tabuleiro);
		
	}
	
	
	
	public void notificaVencedor(Jogador jogadorVencedor){
		JOptionPane.showMessageDialog(null, jogadorVencedor.getNome() + " venceu o jogo");
	}

	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//System.out.println(arg0.getActionCommand());
		
		if(logica.realizarMovimento((Posicao)arg0.getSource(), this.tipoJogador, this.jogadorDaVez)){
			if(tipoJogador == TipoJogador.GATO){
				tipoJogador = TipoJogador.CARROCINHA;
				jogadorDaVez = TipoJogador.CARROCINHA;
				if(logica.verificaVencedorGato()){
					JOptionPane.showMessageDialog(null, "gato ganhou");
					System.exit(ABORT);
				}
			}
			else{
				tipoJogador = TipoJogador.GATO;
				jogadorDaVez = TipoJogador.GATO;
				if(logica.verificaVencedorCarrocinha(this.tabuleiro)){
					JOptionPane.showMessageDialog(null, "carrocinha ganhou");
					System.exit(ABORT);
				}
			}
		}
		
		//Posicao a = (Posicao) arg0.getSource();
		//a.setImagemPosicao(new ImageIcon("gato.png"));
	}
	
}
