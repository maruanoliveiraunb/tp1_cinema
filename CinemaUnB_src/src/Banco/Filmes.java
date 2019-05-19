package Banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Cinema.Filme;
import Cinema.Sala;

public class Filmes {

private Banco BC;
	
	public Filmes(Banco b){
		BC = b;	
	}
	
	public void filmes_inserir(String inome, int iduracao, String iidioma,
			String itipo) {

		String sql = "INSERT INTO filmes(nome,duracao,idioma,tipo) VALUES(?,?,?,?)";

		try {
			PreparedStatement stmt = BC.conecta.prepareStatement(sql);

			stmt.setString(1, inome);
			stmt.setInt(2, Integer.valueOf(iduracao)  );
			stmt.setString(3, iidioma);
			stmt.setString(4, itipo);

			stmt.execute(); // executa comando
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	public ArrayList<Filme> filmes_listar() throws Exception{
		
		ArrayList<Filme> lista = new ArrayList<Filme>();
		
		String sql = "SELECT * FROM filmes";

		try {
			PreparedStatement stmt = BC.conecta.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
		    while(rs.next()){
		    	
		    	Filme f = new Filme(rs.getInt("FilmeID"),
		    			rs.getString("Nome"),
		    			rs.getInt("Duracao"),
		    			rs.getString("Tipo"),
		    			rs.getString("Idioma"));
		    	
		    lista.add(f);
		    
		    }
		    
		    
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		
		
		return lista;

	}
	
}
