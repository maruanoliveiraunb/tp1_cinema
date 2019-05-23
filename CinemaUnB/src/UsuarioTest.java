import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import Cinema.Cinema;


public class UsuarioTest {

	@Test
	public void testaQtdAdmin() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Cinema c = new Cinema();
		
		Assert.assertEquals(1, c.usuarios.get_contagem_admins());
		
	}
	
	@Test
	public void testaUsuario() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		Cinema c = new Cinema();
		
		//testa o login
		Assert.assertEquals(true, c.usuarios.usuario_login("luan", "123"));
		
		//testa se o usuario é admin
		Assert.assertEquals(true, c.usuarios.usuario_tipo("luan").equals("admin"));
		Assert.assertEquals("admin", c.usuarios.usuario_tipo("luan"));
		
		//testa usuario não admin
		Assert.assertEquals(false, c.usuarios.usuario_tipo("alex").equals("admin"));
		Assert.assertEquals("funcionario", c.usuarios.usuario_tipo("alex"));
		
		//testa falha na autenticação
		Assert.assertEquals(false, c.usuarios.usuario_login("luan", "senhaErrada"));
		
	}
	
	@Test
	public void testaExisteCpf() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		Cinema c = new Cinema();
		//testa cpf verdadeiro
		Assert.assertEquals(c.usuarios.existe_cpf("123"), true);
		
		//testa cpf falso
		Assert.assertEquals(c.usuarios.existe_cpf("0576498378"), false);
	}

}
