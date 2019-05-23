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

	public Sessoes(Banco b) {
		BC = b;
	}

	public int criar(int salaid, int filmeid, String data, String horario)
			throws Exception {

		int sid = 0;

		String sql = "INSERT INTO sessoes(salaid,filmeid,data,horario) VALUES(?,?,?,?)";

		try {
			PreparedStatement stmt = BC.conecta.prepareStatement(sql);

			stmt.setInt(1, salaid);
			stmt.setInt(2, filmeid);
			stmt.setString(3, data);
			stmt.setString(4, horario);

			stmt.execute();
			stmt.close();

			sid = ultimasessao();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

		return sid;
	}

	public ArrayList<Sessao> listar() throws Exception {

		ArrayList<Sessao> lista = new ArrayList<Sessao>();

		String sql = "SELECT sessaoid,salaid,filmeid,data,horario FROM sessoes";

		try {
			PreparedStatement stmt = BC.conecta.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				Sessao f = new Sessao(rs.getInt("sessaoid"),
						rs.getInt("salaid"), rs.getInt("filmeid"),
						rs.getString("data"), rs.getString("horario"));

				lista.add(f);

			}

			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

		return lista;

	}

	public int ultimasessao() throws Exception {

		String sql = "SELECT max(sessaoid) AS u FROM sessoes ;";
		int ret = 0;

		try {
			PreparedStatement stmt = BC.conecta.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ret = rs.getInt("u");
			}

			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

		return ret;

	}

	public Sessao obter(int sessaoid) throws Exception {

		Sessao ret = new Sessao(0, 0, 0, "", "");

		String sql = "SELECT sessaoid,salaid,filmeid,data,horario FROM sessoes where sessaoid=?";

		try {
			PreparedStatement stmt = BC.conecta.prepareStatement(sql);
			stmt.setInt(1, sessaoid);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ret = new Sessao(rs.getInt("sessaoid"), rs.getInt("salaid"),
						rs.getInt("filmeid"), rs.getString("data"),
						rs.getString("horario"));
			}

			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

		return ret;

	}

}
