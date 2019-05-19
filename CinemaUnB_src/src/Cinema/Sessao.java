package Cinema;

import java.util.ArrayList;

public class Sessao {

	private int sessaoid;
	private int salaid;
	private int filmeid;

	private String data;
	private String horario;

	ArrayList<String> lugares = new ArrayList<String>();
	ArrayList<String> vendidos = new ArrayList<String>();

	private int inteiras;
	private int meias;

	public Sessao(int isessaoid,int isalaid, int ifilmeid,String idata, String ihorario	) {
		this.sessaoid = isessaoid;
		this.data = idata;
		this.horario = ihorario;
		this.filmeid = ifilmeid;
		this.salaid = isalaid;

		this.inteiras = 0;
		this.meias = 0;

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

	public void lugar_criar(String lugar) {
		lugares.add(lugar);
	}

	public int getTotal() {
		return lugares.size();
	}

	public int getVendidos() {
		return vendidos.size();
	}

	public int getInteiras() {
		return inteiras;
	}

	public int getMeias() {
		return meias;
	}

	public void mostrardisponiveis(int poltronas, int fileiras) {

		System.out.printf("\n          ###### Lugares Disponiveis ######\n\n");

		int somador = 0;

		for (int f = 0; f < fileiras; f++) {

			for (int p = 0; p < poltronas; p++) {
				String poltronanome = lugares.get(somador);

				if (vendidos.contains(poltronanome)) {
					System.out.printf("--- ");

				} else {
					System.out.printf("%s ", poltronanome);
				}

				somador += 1;
			}

			System.out.printf("\n");
		}

	}

	public void comprar(String lugar, IngressoTipo it, int poltronas,
			int fileiras) {

		int somador = 0;

		boolean vendido = false;

		if (vendidos.contains(lugar)) {
			System.out.println("\n Lugar está ocupado !!!");

		}

		for (int f = 0; f < fileiras; f++) {

			for (int p = 0; p < poltronas; p++) {
				String poltronanome = lugares.get(somador);

				if (vendidos.contains(poltronanome)) {

				} else {

					if (poltronanome.equals(lugar)) {
						vendidos.add(lugar);
						vendido = true;

						if (it == IngressoTipo.Inteira) {
							inteiras += 1;
						}
						if (it == IngressoTipo.Meia) {
							meias += 1;
						}

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