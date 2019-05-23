package Cinema;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Banco.Banco;
import Banco.Ingressos;

public class Sessao {

	private int sessaoid;
	private int salaid;
	private int filmeid;

	private String data;
	private String horario;

	public Sessao(int isessaoid, int isalaid, int ifilmeid, String idata,
			String ihorario) {
		this.sessaoid = isessaoid;
		this.data = idata;
		this.horario = ihorario;
		this.filmeid = ifilmeid;
		this.salaid = isalaid;

	}

	public int getSessaoID() {
		return sessaoid;
	}

	public int getSalaid() {
		return salaid;
	}

	public void setSalaid(int salaid) {
		this.salaid = salaid;
	}

	public int getFilmeid() {
		return filmeid;
	}

	public void setFilmeid(int filmeid) {
		this.filmeid = filmeid;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		horario = horario;
	}

	public int getTotal(Banco BC) throws Exception {
		Ingressos i = new Ingressos(BC);
		return i.todos(sessaoid).size();
	}

	public int getVendidos(Banco BC) throws Exception {
		Ingressos i = new Ingressos(BC);
		return i.vendidos(sessaoid).size();
	}

	public void mostrardisponiveis(Banco BC, int poltronas, int fileiras)
			throws Exception {

		System.out.printf("\n          ###### Lugares Disponiveis ######\n\n");

		int somador = 0;
		Ingressos i = new Ingressos(BC);

		ArrayList<String> lsvendidos = i.vendidos(sessaoid);
		ArrayList<String> lstodos = i.todos(sessaoid);

		for (int f = 0; f < fileiras; f++) {

			for (int p = 0; p < poltronas; p++) {
				String poltronanome = lstodos.get(somador);

				if (lsvendidos.contains(poltronanome)) {
					System.out.printf("--- ");

				} else {
					System.out.printf("%s ", poltronanome);
				}

				somador += 1;
			}

			System.out.printf("\n");
		}

	}
	
	public void comprar(Cinema c, Banco BC, String lugar, IngressoTipo it,
			int poltronas, int fileiras) throws Exception {

		int somador = 0;
		Ingressos i = new Ingressos(BC);

		boolean vendido = false;
		ArrayList<String> lsvendidos = i.vendidos(sessaoid);
		ArrayList<String> lstodos = i.todos(sessaoid);

		if (lsvendidos.contains(lugar)) {
			System.out.println("\n Lugar está ocupado !!!");

		}

		for (int f = 0; f < fileiras; f++) {

			for (int p = 0; p < poltronas; p++) {
				String poltronanome = lstodos.get(somador);

				if (lsvendidos.contains(poltronanome)) {

				} else {

					if (poltronanome.equals(lugar)) {
						// vendidos.add(lugar);

						vendido = true;
						String tipo = "";
						double valor = 0;

						if (it == IngressoTipo.Inteira) {
							tipo = "Inteira";
							valor = c.getInteira();
						}
						if (it == IngressoTipo.Meia) {
							tipo = "Meia";
							valor = c.getMeia();

						}
						
						i.vender(sessaoid, lugar, i.getIdIngresso(sessaoid, lugar));

						System.out.println("\n Lugar vendido com sucesso !!!");
					}

				}

				somador += 1;
			}

		}

		if (vendido == false) {
			System.out.printf("\n Ingresso não comprado !!!");

		}
		System.out.printf("\n");
	}

}