package Cinema;

public class Sala {

	private int salaid;

	private String nome;
	private int poltronas;
	private int fileiras;

	public final static String ALFABETO = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public Sala(int isalaid, String inome, int ipoltronas, int ifileiras)
			throws Exception {

		salaid = isalaid;
		setNome(inome);
		setPoltronas(ipoltronas);
		setFileiras(ifileiras);

	}

	public void setNome(String inome) {
		this.nome = inome;
	}

	public void setPoltronas(int ipoltronas) throws Exception {

		if ((ipoltronas > 0) & (fileiras <= 30)) {
			this.poltronas = ipoltronas;
		} else {
			throw new Exception("Numero de poltronas invalido !!!");
		}

	}

	public void setFileiras(int ifileiras) throws Exception {

		if ((ifileiras > 0) & (ifileiras <= 26)) {
			this.fileiras = ifileiras;
		} else {
			throw new Exception("Numero de Fileiras invalido !!!" + ifileiras);
		}

	}

	public int getsalaid() {
		return this.salaid;
	}

	public String getNome() {
		return this.nome;
	}

	public int getFileiras() {
		return this.fileiras;
	}

	public int getPoltronas() {
		return this.poltronas;
	}

	public void mostrarsala() {

		System.out.printf("\n          ###### %s ######\n", this.getNome());

		for (int f = 0; f < getFileiras(); f++) {

			char fileiranome = ALFABETO.charAt(f);
			// System.out.printf("\nFileira : %s",fileiranome);

			for (int p = 0; p < getPoltronas(); p++) {
				String poltronanome = String.valueOf(p + 1);

				if (poltronanome.length() == 1) {
					poltronanome = "0" + poltronanome;
				}

				poltronanome = fileiranome + poltronanome;

				System.out.printf("%s ", poltronanome);
			}

			System.out.printf("\n");
		}

	}

	public int getLugares() {
		return this.getFileiras() * this.getPoltronas();
	}
}
