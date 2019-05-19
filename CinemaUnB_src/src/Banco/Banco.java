package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Banco {

	public Connection conecta;

	private final String banco = "tp1_cinema";
	private final String porta = "3307";

	private final String usuario = "tp1";
	private final String pwd = "tp1";
	
	
	
	public Banco() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		String c = "jdbc:mysql://localhost:" + this.porta + "/" + this.banco + "?user=" + this.usuario + "&password=" + this.pwd;
		
		
					Class.forName("com.mysql.jdbc.Driver").newInstance();
								
					conecta=DriverManager.getConnection("jdbc:mysql://localhost:3307/" + this.banco,this.usuario,this.pwd);
					
					
		try {
			
			
			
		} catch (Exception e) {
			System.out.println("Erro na conexão : " + e.getMessage());
		}
	}

	
}
