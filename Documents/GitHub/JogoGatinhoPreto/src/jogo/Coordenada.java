package jogo;

public class Coordenada {
	protected int linha;
	protected int coluna;
	
	public Coordenada(int linha, int coluna){
		this.linha = linha;
		this.coluna = coluna;
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}
	
	public boolean equals(Object anObject){
		try{
			Coordenada aSerTestada = (Coordenada) anObject;
			if(this.getLinha() == aSerTestada.getLinha() && this.getColuna() == aSerTestada.getColuna()){
				return true;
			}
			else{
				return false;
			}
		}catch(ClassCastException e){
			System.out.println("VOCÊ NÃO PASSOU UMA COORDENADA, SEU CABAÇO");
			return false;
		}
	}
	public String toString(){
		return ("linha " + this.getLinha() + ", coluna " + this.getColuna());
	}
	
}
