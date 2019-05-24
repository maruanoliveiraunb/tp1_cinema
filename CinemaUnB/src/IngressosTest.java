import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import Cinema.Cinema;

public class IngressosTest {
	
	private Cinema cinema;
	
	private int numLugar = 20;

	public void criaCinema() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.cinema = new Cinema();
	}
	
	@Test
	public void testaCriaIngressos() throws Exception {
		criaCinema();
		
		int qtdIngressosDisponiveisAntes = this.cinema.ingressos.disponiveis(1).size();
		this.numLugar++;
		String lugar = this.numLugar+"C";
		
		this.cinema.ingressos.criar(1, lugar, "Disponivel", "Meia", 37.50);
		
		int qtdIngressosEsperados = qtdIngressosDisponiveisAntes + 1;
		
		Assert.assertEquals(qtdIngressosEsperados, this.cinema.ingressos.disponiveis(1).size());
		
	}
	
	@Test
	public void testaVenderIngressos() throws Exception {
		criaCinema();
		
		int qtdIngressosVendidosAntes = this.cinema.ingressos.vendidos(1).size();
		
		this.cinema.ingressos.vender(1, "21C", 16);
		
		int qtdIngressosEsperados = qtdIngressosVendidosAntes + 1;
		
		Assert.assertEquals(qtdIngressosEsperados, this.cinema.ingressos.vendidos(1).size());
	}
	
	@Test
	public void testaListaTodos() throws Exception {
		criaCinema();
		//só funcionara contando com o numero que o teste adicionara
		Assert.assertEquals(17, this.cinema.ingressos.todos(1).size());
	}
	
	@Test
	public void testaGets() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		criaCinema();
		
		
		Assert.assertEquals(0, this.cinema.ingressos.getInteiras());
		Assert.assertEquals(2, this.cinema.ingressos.getMeias());
		Assert.assertEquals(0.0, this.cinema.ingressos.getValorTotalInteira(), 0.0001);
		Assert.assertEquals(0.0, this.cinema.ingressos.getValorTotalMeia(), 0.0001);
		
		
	}
	
}
