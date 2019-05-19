package Banco;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Cinema.Funcionario;
import Cinema.Sala;
import Cinema.Sessao;

public class Sessoes {

private Banco BC;
	
	public Sessoes(Banco b){
		BC = b;	
	}
	
	public int criar(int salaid, int filmeid, String data,String horario) {

		int sid = 0;
		
		String sql = "INSERT INTO sessoes(salaid,filmeid,data,horario) VALUES(?,?,?,?)";

			
			
		try {
			PreparedStatement stmt = BC.conecta.prepareStatement(sql);

			stmt.setInt(1, salaid);
			stmt.setInt(2, filmeid  );
			stmt.setString(3, data);
			stmt.setString(4, horario);
			
			stmt.execute();
			
			final ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
			    sid = rs.getInt(1);
			}
			
			
		        
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		
		return sid;
	}
	

	public ArrayList<Sessao> listar() throws Exception{
		
		ArrayList<Sessao> lista = new ArrayList<Sessao>();
		
		String sql = "SELECT sessaoid,salaid,filme,data,horario FROM sessoes";

		try {
			PreparedStatement stmt = BC.conecta.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
		    while(rs.next()){
		    	
		    	Sessao f = new Sessao(rs.getInt("sessaoid"),rs.getInt("salaid"),rs.getInt("filmeid"),rs.getString("data"),rs.getString("horario"));

		    			    	
		    lista.add(f);
		    
		    }
		    
		    
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		
		
		return lista;

	}
		

	public Sessao obter(int salaid) throws Exception{
		
		Sessao ret= new Sessao(0,0,0,"","");
		
		String sql = "SELECT sessaoid,salaid,filme,data,horario FROM salas where sessaoid='?'";

		try {
			PreparedStatement stmt = BC.conecta.prepareStatement(sql);
			stmt.setInt(1, salaid);

			ResultSet rs = stmt.executeQuery();
		    while(rs.next()){	    	
		    	ret = new Sessao(rs.getInt("sessaoid"),rs.getInt("salaid"),rs.getInt("filmeid"),rs.getString("data"),rs.getString("horario"));
		    }
		    
		    
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		
		
		return ret;

	}
		
	
}
