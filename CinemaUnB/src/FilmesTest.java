import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import Cinema.Cinema;

public class FilmesTest {
	
	private Cinema cinema;
	
	public void criaCinema() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.cinema = new Cinema();
	}
	
	@Test
	public void testaExisteFilme() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		criaCinema();	
		
		//testa filme existente
		Assert.assertEquals(true, this.cinema.filmes.existe_filme("O Rei Leao"));
		
		//testa filme inexistente
		Assert.assertEquals(false, this.cinema.filmes.existe_filme("Poeira em alto mar"));	
	}
	
	@Test
	public void testaListaFilmes() throws Exception {
		criaCinema();	
		
		Assert.assertEquals(9, this.cinema.filmes.filmes_listar().size());
	}
}
