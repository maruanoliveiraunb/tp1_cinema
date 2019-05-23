package Banco;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Cinema.Funcionario;
import Cinema.Sala;
import Cinema.Sessao;

public class Ingressos {

	private Banco BC;

	public Ingressos(Banco b) {
		BC = b;
	}

	public void criar(int sessaoid, String lugar, String status)
			throws Exception {

		String sql = "INSERT INTO ingressos(sessaoid,lugar,status) VALUES(?,?,?)";

		try {
			PreparedStatement stmt = BC.conecta.prepareStatement(sql);

			stmt.setInt(1, sessaoid);
			stmt.setString(2, lugar);
			stmt.setString(3, status);

			stmt.execute(); // executa comando
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

	}

	public ArrayList<String> vendidos(int sessaoid) throws Exception {

		ArrayList<String> lista = new ArrayList<String>();

		String sql = "SELECT lugar FROM ingressos where sessaoid=? and status=?";

		try {
			PreparedStatement stmt = BC.conecta.prepareStatement(sql);

			stmt.setInt(1, sessaoid);
			stmt.setString(2, "Vendido");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				lista.add(rs.getString("lugar"));

			}

			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

		return lista;

	}

	public ArrayList<String> disponiveis(int sessaoid) throws Exception {

		ArrayList<String> lista = new ArrayList<String>();

		String sql = "SELECT lugar FROM ingressos where sessaoid=? and status=?";

		try {
			PreparedStatement stmt = BC.conecta.prepareStatement(sql);

			stmt.setInt(1, sessaoid);
			stmt.setString(2, "Disponivel");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				lista.add(rs.getString("lugar"));

			}

			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

		return lista;

	}

	public ArrayList<String> todos(int sessaoid) throws Exception {

		ArrayList<String> lista = new ArrayList<String>();

		String sql = "SELECT lugar FROM ingressos where sessaoid=? ";

		try {
			PreparedStatement stmt = BC.conecta.prepareStatement(sql);

			stmt.setInt(1, sessaoid);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				lista.add(rs.getString("lugar"));

			}

			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

		return lista;

	}

	public void vender(int sessaoid, String lugar, int ingressoID) {

		String sql = "UPDATE ingressos SET status=? Where sessaoid=? and ingressoID=? and lugar=?";

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		java.util.Date dt = new java.util.Date();
		String currentTime = sdf.format(dt);

		try {
			PreparedStatement stmt = BC.conecta.prepareStatement(sql);

			stmt.setString(1, "Vendido");
			stmt.setInt(2, sessaoid);
			stmt.setDouble(3, ingressoID);
			stmt.setString(4, lugar);

			stmt.execute(); // executa comando
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

	}

	public int getMeias() throws SQLException {
		int res = 0;

		PreparedStatement stmt = BC.conecta
				.prepareStatement("SELECT COUNT(ingressoid) AS 'Contagem' FROM ingressos WHERE tipo='Meia';");

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			res = rs.getInt("Contagem");
		}

		stmt.close();

		return res;
	}

	public int getInteiras() throws SQLException {
		int res = 0;

		PreparedStatement stmt = BC.conecta
				.prepareStatement("SELECT COUNT(ingressoid) AS 'Contagem' FROM ingressos WHERE tipo='Inteira';");

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			res = rs.getInt("Contagem");
		}

		stmt.close();

		return res;
	}

	public double getValorTotalMeia() throws SQLException {
		double res = 0;

		PreparedStatement stmt = BC.conecta
				.prepareStatement("SELECT SUM(i.valor) AS 'Meia' FROM ingressos AS i WHERE i.Tipo='Meia'");

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			res = rs.getInt("Meia");
		}

		stmt.close();

		return res;
	}

	public double getValorTotalInteira() throws SQLException {
		double res = 0;

		PreparedStatement stmt = BC.conecta
				.prepareStatement("SELECT SUM(i.valor) AS 'Inteira' FROM ingressos AS i WHERE i.Tipo='Inteira'");

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			res = rs.getInt("Inteira");
		}

		stmt.close();

		return res;
	}

	public int totalvendidos() throws Exception {

		String sql = "SELECT count(ingressoid) AS 'Vendidos'  FROM ingressos WHERE STATUS='Vendido';";
		int ret = 0;

		try {
			PreparedStatement stmt = BC.conecta.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ret = rs.getInt("Vendidos");
			}

			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

		return ret;

	}
	public int getIdIngresso(int sessaoid, String lugar) {
		String sql = "SELECT ingressoid FROM ingressos WHERE sessaoid = ? and lugar = ?;";
		
		int ingressoid;
		int ret = 0;
		try {
			PreparedStatement stmt = BC.conecta.prepareStatement(sql);
			
			stmt.setInt(1, sessaoid);
			stmt.setString(2, lugar);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ret = rs.getInt("ingressoid");
			}

			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return ret;

	}
	
}
