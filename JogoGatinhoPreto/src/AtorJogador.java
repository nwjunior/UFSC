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
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtorJogador frame = new AtorJogador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AtorJogador (){
		this.tabuleiro = new Tabuleiro(this);
		this.logica = new Logica();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 615, 615);
		tabuleiro.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(tabuleiro);
		tabuleiro.setLayout(null);
		tabuleiro.setBackground(new Color(255, 255, 255));
	}
	
	
	
	public void notificaVencedor(Jogador jogadorVencedor){
		JOptionPane.showMessageDialog(null, jogadorVencedor.getNome() + " venceu o jogo");
	}

	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(arg0.getActionCommand());
		
		Posicao a = (Posicao) arg0.getSource();
		a.renderizaPosicao(new ImageIcon("muro.png"));
	}
	
}
