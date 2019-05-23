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
		
		this.cinema.ingressos.criar(1, lugar, "Disponivel");
		
		int qtdIngressosEsperados = qtdIngressosDisponiveisAntes + 1;
		
		Assert.assertEquals(qtdIngressosEsperados, this.cinema.ingressos.disponiveis(1).size());
		
	}
	
	@Test
	public void testaVenderIngressos() throws Exception {
		criaCinema();
		
		int qtdIngressosVendidosAntes = this.cinema.ingressos.vendidos(1).size();
		
		this.cinema.ingressos.vender(1, "21C", 9);
		
		int qtdIngressosEsperados = qtdIngressosVendidosAntes + 1;
		
		System.out.println(qtdIngressosVendidosAntes);
		System.out.println(this.cinema.ingressos.vendidos(1).size());
		
		
		Assert.assertEquals(qtdIngressosEsperados, this.cinema.ingressos.vendidos(1).size());
	}
}
