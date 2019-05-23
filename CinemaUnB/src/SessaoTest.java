import java.sql.SQLException;

import org.junit.Test;

import Banco.Banco;
import Cinema.Cinema;
import Cinema.IngressoTipo;
import Cinema.Sessao;

public class SessaoTest {
	private Cinema cinema;

	public void criaCinema() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.cinema = new Cinema();
	}
	
	@Test
	public void testaComprarSessao() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception {
		Sessao s = new Sessao(1, 1, 1, "20/01/2020", "15:30");
		
		s.comprar(this.cinema, new Banco(), "21C", IngressoTipo.Meia, 20, 4);
		
	}
}
