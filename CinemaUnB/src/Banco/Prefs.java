package Banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Cinema.Funcionario;
import Cinema.Sala;

public class Prefs {

	private Banco BC;

	public Prefs(Banco b) {
		BC = b;
	}

	public boolean existe(String nome) throws SQLException {
		int res = 0;

		PreparedStatement stmt = BC.conecta
				.prepareStatement("select count(*) from preferencias where nome=?");
		stmt.setString(1, nome);

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			res = rs.getInt("count(*)");
		}

		stmt.close();

		if (res > 0) {
			return true;
		} else {
			return false;
		}

	}

	public void definir(String nome, String valor) throws SQLException {

		if (existe(nome) == true) {

			String sql = "UPDATE preferencias SET valor=?,dda=? Where nome=?";

			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			java.util.Date dt = new java.util.Date();
			String currentTime = sdf.format(dt);

			try {
				PreparedStatement stmt = BC.conecta.prepareStatement(sql);

				stmt.setString(1, valor);
				stmt.setString(2, currentTime);

				stmt.setString(3, nome);

				stmt.execute(); // executa comando
				stmt.close();

			} catch (SQLException u) {
				throw new RuntimeException(u);
			}

		} else {

			String sql = "INSERT INTO preferencias(nome,valor,dda) VALUES(?,?,?)";

			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			java.util.Date dt = new java.util.Date();
			String currentTime = sdf.format(dt);

			try {
				PreparedStatement stmt = BC.conecta.prepareStatement(sql);

				stmt.setString(1, nome);
				stmt.setString(2, valor);
				stmt.setString(3, currentTime);

				stmt.execute(); // executa comando
				stmt.close();

			} catch (SQLException u) {
				throw new RuntimeException(u);
			}

		}

	}

	public String obter(String nome) throws Exception {

		String ret = "";

		String sql = "SELECT valor FROM preferencias where nome=?";

		try {
			PreparedStatement stmt = BC.conecta.prepareStatement(sql);
			stmt.setString(1, nome);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ret = rs.getString("valor");
			}

			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

		return ret;

	}

}
