package Banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Cinema.Funcionario;
import Cinema.Sala;

public class Salas {

	private Banco BC;

	public Salas(Banco b) {
		BC = b;
	}

	public void criar(String salanome, int poltronas, int fileiras) {

		String sql = "INSERT INTO salas(nome,poltronas,fileiras,ddc,ddm) VALUES(?,?,?,?,?)";

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		java.util.Date dt = new java.util.Date();
		String currentTime = sdf.format(dt);

		try {
			PreparedStatement stmt = BC.conecta.prepareStatement(sql);

			stmt.setString(1, salanome);
			stmt.setInt(2, poltronas);
			stmt.setInt(3, fileiras);
			stmt.setString(4, currentTime);
			stmt.setString(5, currentTime);

			stmt.execute(); // executa comando
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	public ArrayList<Sala> listar() throws Exception {

		ArrayList<Sala> lista = new ArrayList<Sala>();

		String sql = "SELECT salaid,nome,poltronas,fileiras FROM salas";

		try {
			PreparedStatement stmt = BC.conecta.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				Sala f = new Sala(rs.getInt("SalaID"), rs.getString("Nome"),
						rs.getInt("Poltronas"), rs.getInt("Fileiras"));

				lista.add(f);

			}

			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

		return lista;

	}

	public Sala salaum(int salaid) throws Exception {

		Sala ret = new Sala(0, "", 1, 1);

		ArrayList<Sala> lista = this.listar();

		for (int s = 0; s < lista.size(); s++) {

			if (lista.get(s).getsalaid() == salaid) {
				lista.get(s).mostrarsala();
				ret = lista.get(s);
				break;
			}

		}
		return ret;
	}

	public Sala obter(int salaid) throws Exception {

		Sala ret = new Sala(0, "", 0, 0);

		String sql = "SELECT salaid,nome,poltronas,fileiras FROM salas where salaid=?";

		try {
			PreparedStatement stmt = BC.conecta.prepareStatement(sql);
			stmt.setInt(1, salaid);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ret = new Sala(rs.getInt("salaid"), rs.getString("nome"),
						rs.getInt("poltronas"), rs.getInt("fileiras"));
			}

			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

		return ret;

	}

	public boolean existe_sala(String sala) throws SQLException {
		int res = 0;
		boolean resultado = false;

		PreparedStatement stmt = BC.conecta
				.prepareStatement("select count(*) from salas where nome=? ");
		stmt.setString(1, sala);

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			res = rs.getInt("count(*)");
		}

		stmt.close();

		if (res > 0) {
			resultado = true;
		}

		return resultado;
	}

}
