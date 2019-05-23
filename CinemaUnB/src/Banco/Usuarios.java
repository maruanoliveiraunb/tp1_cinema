package Banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Cinema.Filme;
import Cinema.Funcionario;

public class Usuarios {

	private Banco BC;

	public Usuarios(Banco b) {
		BC = b;
	}

	public int get_contagem_admins() throws SQLException {
		int res = 0;

		PreparedStatement stmt = BC.conecta
				.prepareStatement("select count(*) from usuarios where tipo='admin' and status='ativo'");

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			res = rs.getInt("count(*)");
		}

		stmt.close();

		return res;
	}

	public void admin_criar(String usuario, String cpf, String senha) {

		String sql = "INSERT INTO usuarios(usuario,cpf,pwd,tipo,ddc,ddm,status) VALUES(?,?,sha(?),?,?,?,?)";

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		java.util.Date dt = new java.util.Date();

		String currentTime = sdf.format(dt);

		try {
			PreparedStatement stmt = BC.conecta.prepareStatement(sql);

			stmt.setString(1, usuario);
			stmt.setString(2, cpf);
			stmt.setString(3, senha);
			stmt.setString(4, "admin");
			stmt.setString(5, currentTime);
			stmt.setString(6, currentTime);
			stmt.setString(7, "ativo");

			stmt.execute(); // executa comando
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	public void funcionario_criar(String usuario, String cpf, String senha) {

		String sql = "INSERT INTO usuarios(usuario,cpf,pwd,tipo,ddc,ddm,status) VALUES(?,?,sha(?),?,?,?,?)";

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		java.util.Date dt = new java.util.Date();

		String currentTime = sdf.format(dt);

		try {
			PreparedStatement stmt = BC.conecta.prepareStatement(sql);

			stmt.setString(1, usuario);
			stmt.setString(2, cpf);
			stmt.setString(3, senha);
			stmt.setString(4, "funcionario");
			stmt.setString(5, currentTime);
			stmt.setString(6, currentTime);
			stmt.setString(7, "ativo");

			stmt.execute(); // executa comando
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	public boolean usuario_login(String usuario, String senha)
			throws SQLException {
		int res = 0;
		boolean resultado = false;

		PreparedStatement stmt = BC.conecta
				.prepareStatement("select count(*) from usuarios where usuario=? and pwd=sha(?) and status='ativo'");
		stmt.setString(1, usuario);
		stmt.setString(2, senha);

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

	public String usuario_tipo(String usuario) throws SQLException {
		String resultado = "";

		PreparedStatement stmt = BC.conecta
				.prepareStatement("select tipo from usuarios where usuario=?");
		stmt.setString(1, usuario);

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			resultado = rs.getString("tipo");
		}

		stmt.close();

		return resultado;
	}

	public ArrayList<Funcionario> funcionarios_listar() throws Exception {

		ArrayList<Funcionario> lista = new ArrayList<Funcionario>();

		String sql = "SELECT usuarioid,usuario FROM usuarios where tipo='funcionario' and status='ativo'";

		try {
			PreparedStatement stmt = BC.conecta.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				Funcionario f = new Funcionario();
				f.setID(rs.getInt("Usuarioid"));
				f.setNome(rs.getString("Usuario"));

				lista.add(f);

			}

			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

		return lista;

	}

	public boolean existe_cpf(String cpf) throws SQLException {
		int res = 0;
		boolean resultado = false;

		PreparedStatement stmt = BC.conecta
				.prepareStatement("select count(*) from usuarios where cpf=? ");
		stmt.setString(1, cpf);

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

	public boolean existe_usuario(String usuario) throws SQLException {
		int res = 0;
		boolean resultado = false;

		PreparedStatement stmt = BC.conecta
				.prepareStatement("select count(*) from usuarios where usuario=? ");
		stmt.setString(1, usuario);

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
