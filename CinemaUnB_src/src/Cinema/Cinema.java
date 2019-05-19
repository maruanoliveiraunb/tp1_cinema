package Cinema;

import Banco.Banco;
import Banco.Filmes;
import Banco.Prefs;
import Banco.Salas;
import Banco.Sessoes;
import Banco.Usuarios;
import Cinema.Sala;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cinema {

	
	private Banco b;
	
	public Usuarios usuarios;
	public Filmes filmes;
	public Salas salas;
	public Sessoes sessoes;
	public Prefs prefs;
	
	
	public Cinema() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		b = new Banco();
		usuarios=new Usuarios(b);
		filmes=new Filmes(b);
		salas=new Salas(b);
		sessoes=new Sessoes(b);
		prefs=new Prefs(b);

	}

	public String getNome() throws Exception {
		return prefs.obter("Cinema.nome");
	}

	public void setNome(String inome) throws SQLException {
		prefs.definir("Cinema.nome",inome);
	}

	public void setPreco(double ipreco) throws SQLException {
		 prefs.definir("Cinema.preco",String.valueOf(ipreco));
	}

	public void setEndereco(String iendereco) throws SQLException {
		prefs.definir("Cinema.endereco",iendereco);
	}

	public String getEndereco() throws Exception {
		return prefs.obter("Cinema.endereco");
	}

	public double getPreco() throws NumberFormatException, Exception {
		return Double.parseDouble( prefs.obter("Cinema.preco"));
	}

	public double getInteira() throws NumberFormatException, Exception {
		return this.getPreco();
	}

	public double getMeia() throws NumberFormatException, Exception {
		return this.getPreco() / 2;
	}

	

	public void sala_listar() throws Exception {

		
		ArrayList<Sala> lista = salas.listar();

		for (int s = 0; s < lista.size(); s++) {
			System.out.printf(
					"\n%d - %20s -\t F = %3d \t P = %3d \t Total = %3d ", lista
							.get(s).getsalaid(), lista.get(s).getNome(), lista
							.get(s).getFileiras(), lista.get(s).getPoltronas(),
							lista.get(s).getLugares());
		}

		System.out.printf("\n \n");

	}

	public void sala_mostrar() throws Exception {

		ArrayList<Sala> lista = salas.listar();

		for (int s = 0; s < lista.size(); s++) {

			lista.get(s).mostrarsala();

		}

	}

	public void sala_mostrarporid(int salaid) throws Exception {

		boolean encontrada = false;
		ArrayList<Sala> lista = salas.listar();

		for (int s = 0; s < lista.size(); s++) {

			if (lista.get(s).getsalaid() == salaid) {
				lista.get(s).mostrarsala();
				encontrada = true;
				break;
			}

		}

		if (encontrada == false) {
			System.out.printf("\nSala não encontrada !!!");
		}
	}

	public void filme_cadastrar(String nome, int duracao, String iidioma,
			String itipo) throws Exception {
		filmes.filmes_inserir(nome, duracao, iidioma, itipo);
	}

	public void filme_listar() throws Exception {

		ArrayList<Filme> lista = filmes.filmes_listar();

		
		for (int s = 0; s < lista.size(); s++) {
			System.out.printf("\n%d - %s : %s : %s",
					lista.get(s).getfilmeid(), lista.get(s).getNome(), lista
							.get(s).getDuracaoFormatada(), lista.get(s)
							.getExtras());
		}

		System.out.printf("\n \n");

	}

	public Filme filmes_obter(int index) throws Exception {

		ArrayList<Filme> lista = filmes.filmes_listar();

		for (int s = 0; s < lista.size(); s++) {

			if (lista.get(s).getfilmeid() == index) {
				return lista.get(s);
			}

		}
		return null;

	}

	public Sala sala_obter(int index) throws Exception {

		ArrayList<Sala> lista = salas.listar();

		for (int s = 0; s < lista.size(); s++) {

			if (lista.get(s).getsalaid() == index) {
				return lista.get(s);
			}

		}
		return null;

	}

	public Sessao sessao_obter(int index) throws Exception {

		return sessoes.obter(index);
		
		

	}

	public void sessoes_listar() throws Exception {

		ArrayList<Sessao> lista = sessoes.listar();

		for (int s = 0; s < lista.size(); s++) {

			Sessao sessaoc = lista.get(s);
			Filme fs = filmes_obter(sessaoc.getFilmeid());
			Sala ss = sala_obter(sessaoc.getSalaid());

			System.out.printf("\nSessao %d - %s :: %s  - %s    - %s   :: %d",
					sessaoc.getSessaoID(), sessaoc.getData(),
					sessaoc.getHorario(), fs.getChamada(), ss.getNome(),
					sessaoc.getTotal());
		}

		System.out.printf("\n \n");

	}

	public void sessoes_listardia(String Data) throws Exception {

		ArrayList<Sessao> lista = sessoes.listar();

		for (int s = 0; s < lista.size(); s++) {

			Sessao sessaoc = lista.get(s);

			if (sessaoc.getData().equals(Data)) {

				Filme fs = filmes_obter(sessaoc.getFilmeid());
				Sala ss = sala_obter(sessaoc.getSalaid());

				System.out.printf(
						"\nSessao %d - %s :: %s  - %s    - %s   :: %d",
						sessaoc.getSessaoID(), sessaoc.getData(),
						sessaoc.getHorario(), fs.getChamada(), ss.getNome(),
						sessaoc.getTotal());

			}

		}

		System.out.printf("\n \n");

	}

	public void sessoes_listarsala(String sala) throws Exception {

		ArrayList<Sessao> lista = sessoes.listar();

		for (int s = 0; s < lista.size(); s++) {

			Sessao sessaoc = lista.get(s);
			Sala sl = sala_obter(sessaoc.getSalaid());

			if (sl.getNome().equals(sala)) {

				Filme fs = filmes_obter(sessaoc.getFilmeid());
				Sala ss = sala_obter(sessaoc.getSalaid());

				System.out.printf(
						"\nSessao %d - %s :: %s  - %s    - %s   :: %d",
						sessaoc.getSessaoID(), sessaoc.getData(),
						sessaoc.getHorario(), fs.getChamada(), ss.getNome(),
						sessaoc.getTotal());

			}

		}

		System.out.printf("\n \n");

	}

	public void sessoes_listarfilme(int filmeid) throws Exception {

		ArrayList<Sessao> lista = sessoes.listar();

		for (int s = 0; s < lista.size(); s++) {

			Sessao sessaoc = lista.get(s);
			
			if (sessaoc.getFilmeid() == filmeid){

				Filme fs = filmes_obter(sessaoc.getFilmeid());
				Sala ss = sala_obter(sessaoc.getSalaid());

				System.out.printf(
						"\nSessao %d - %s :: %s  - %s    - %s   :: %d",
						sessaoc.getSessaoID(), sessaoc.getData(),
						sessaoc.getHorario(), fs.getChamada(), ss.getNome(),
						sessaoc.getTotal());

			}

		}

		System.out.printf("\n \n");

	}

	public void sessoes_criar(int salaid, int filmeid, String data,String horario) throws Exception {

		System.out.printf("\nTentando....");

		
		int sid = sessoes.criar(salaid, filmeid, data, horario);
		
		System.out.printf("\nSID : %d",sid);
		
		
Sala sc = salas.obter(salaid);

		
		for (int f = 0; f < sc.getFileiras(); f++) {

			char fileiranome = sc.ALFABETO.charAt(f);
			 System.out.printf("\nCRIANDO Fileira : %s",fileiranome);

			for (int p = 0; p < sc.getPoltronas(); p++) {
				String poltronanome = String.valueOf(p + 1);

				if (poltronanome.length() == 1) {
					poltronanome = "0" + poltronanome;
				}

				poltronanome = fileiranome + poltronanome;

			
				String sql = "INSERT INTO ingressos(sessaoid,lugar,status) VALUES(?,?,?)";

					
					
				try {
					PreparedStatement stmt = b.conecta.prepareStatement(sql);

					stmt.setInt(1, sid);
					stmt.setString(2, poltronanome  );
					stmt.setString(3, "Vazio");
					
					stmt.execute(); // executa comando
					stmt.close();

				} catch (SQLException u) {
					throw new RuntimeException(u);
				}
				
			}

		}
		
	}

	public int getIngressos() throws Exception {
		int somatorio = 0;

		ArrayList<Sessao> lista = sessoes.listar();

		for (int p = 0; p < lista.size(); p++) {
			somatorio += lista.get(p).getInteiras()
					+ lista.get(p).getMeias();
		}

		return somatorio;
	}

	public int getInteiras() throws Exception {
		int somatorio = 0;
		ArrayList<Sessao> lista = sessoes.listar();

		for (int p = 0; p < lista.size(); p++) {
			somatorio += lista.get(p).getInteiras();
		}

		return somatorio;
	}

	public int getMeias() throws Exception {
		int somatorio = 0;
		ArrayList<Sessao> lista = sessoes.listar();

		for (int p = 0; p < lista.size(); p++) {
			somatorio += lista.get(p).getMeias();
		}

		return somatorio;
	}

	public double getReceitaBruta() throws Exception {
		
		double somatorio = (getMeias() * getMeia())
				+ (getInteiras() * getInteira());
		return somatorio;
	}
	


	
}
