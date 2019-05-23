import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import Cinema.Cinema;
import Cinema.Filme;
import Cinema.IngressoTipo;
import Cinema.Sala;
import Cinema.Sessao;
import Menus.MenuAdmin;
import Menus.MenuConfigurar;
import Menus.MenuFuncionario;

public class main {

	public static void main(String[] args) throws Exception {

		Cinema c = new Cinema();

		while (c.usuarios.get_contagem_admins() == 0) {
			System.out
					.printf("\n\n ----------- CONFIGURADOR ----------------\n\n ");

			MenuConfigurar.menu_configurar_cinema(c);

		}

		if (c.usuarios.get_contagem_admins() > 0) {

			while (true) {

				String cinemanome = c.getNome();

				System.out.println(" -------------- ---------- " + cinemanome
						+ " ---------- -----------------");

				System.out
						.printf("\n\n ----------- LOGIN ----------------\n\n ");

				System.out.printf("Usuario : ");
				Scanner sc = new Scanner(System.in);
				String usuario = sc.nextLine();

				System.out.printf(" Senha : ");
				Scanner sc2 = new Scanner(System.in);
				String senha = sc2.nextLine();

				if (c.usuarios.usuario_login(usuario, senha) == true) {

					if (c.usuarios.usuario_tipo(usuario).equals("admin")) {
						MenuAdmin.menu_admin(c);
					} else {
						MenuFuncionario.menu_funcionario(c);
					}

				} else {
					System.out.println("\nUsuario nao encontrado !!!");
				}

			}

		}

	}

}
