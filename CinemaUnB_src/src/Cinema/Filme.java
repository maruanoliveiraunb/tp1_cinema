package Cinema;

public class Filme {

	private int filmeid;

	private String nome;
	private int duracao;
	private String idioma;
	private String tipo;

	public Filme(int ifilmeid, String inome, int iduracao, String iidioma,
			String itipo) throws Exception {

		filmeid = ifilmeid;
		setNome(inome);
		setDuracao(iduracao);
		setIdioma(iidioma);
		setTipo(itipo);

	}

	public int getfilmeid() {
		return this.filmeid;
	}

	public String getNome() {
		return this.nome;
	}

	public int getDuracao() {
		return this.duracao;
	}

	public String getIdioma() {
		return this.idioma;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setNome(String inome) {
		this.nome = inome;
	}

	public void setDuracao(int iduracao) throws Exception {
		
		if (iduracao>=0){
			this.duracao = iduracao;

		}else{
			throw new Exception("Duracao do filme invalida !!!");
		}

	}

	public void setIdioma(String iidioma) {
		this.idioma = iidioma;
	}

	public void setTipo(String itipo) {
		this.tipo = itipo;
	}

	public String getExtras() {

		String extras = "";

		if (idioma.equals("dublado")) {
			extras = "DUB";
		} else if (idioma.equals("DUBLADO")) {
			extras = "DUB";
		} else if (idioma.equals("Dublado")) {
			extras = "DUB";
		} else if (idioma.equals("dub")) {
			extras = "DUB";
		} else if (idioma.equals("Dub")) {
			extras = "DUB";
		} else if (idioma.equals("DUB")) {
			extras = "DUB";
		} else {
			extras = "LEG";
		}

		if (tipo == "3D") {
			extras = extras + "  3D";
		}

		return extras;

	}

	public String getChamada() {
		return this.getNome() + " - " + this.getExtras();
	}

	public String getDuracaoFormatada() {
		String formatado = "";

		int horas = 0;
		int minutos = 0;
		int segundos = 0;
		int total = getDuracao();

		while (total >= 3600) {
			horas += 1;
			total -= 3600;
		}
		while (total >= 60) {
			minutos += 1;
			total -= 60;
		}

		segundos += total;

		formatado = horas + ":" + minutos + ":" + segundos;

		return formatado;
	}
}