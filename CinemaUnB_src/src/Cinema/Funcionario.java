package Cinema;

public class Funcionario {

	private int id;
	private String nome;
	
	public void setNome(String inome){
		this.nome=inome;
	}
	
	public void setID(int id){
		this.id=id;
	}
	
	public int getID(){return this.id;}

	public String getNome(){return this.nome;}
	
}
