package Menus;

import java.sql.SQLException;
import java.util.Scanner;

import Cinema.Cinema;

public class MenuConfigurar {

	public static void menu_configurar_cinema(Cinema c) throws SQLException {

		while (true) {

			System.out.println("Escolha uma opção abaixo : ");
			System.out.printf("\n");
			System.out.printf(" - n  : Definir o nome do Cinema \n");
			System.out.printf(" - a  : Criar ADMINISTRADOR \n");
			System.out.printf(" - s  : Sair \n");
			System.out.printf("\n");

			System.out.printf("Opcao : ");
			Scanner sc = new Scanner(System.in);
			String tipo = sc.nextLine();

			if (tipo.equals("n")) {

				System.out.println("\n  ---- DEFINIR NOME DO CINEMA ----\n ");
				System.out.print("Nome : ");

				Scanner sc1 = new Scanner(System.in);
				String nome = sc.nextLine();

				c.prefs.definir("Cinema.nome", nome);

			} else if (tipo.equals("a")) {
				System.out.println("\n  ---- CRIAR ADMININSTRADOR ----\n ");

				System.out.print("Usuario : ");
				Scanner sc1 = new Scanner(System.in);
				String usuario = sc.nextLine();

				System.out.print("CPF : ");
				Scanner sc2 = new Scanner(System.in);
				String cpf = sc2.nextLine();

				System.out.print("Senha : ");
				Scanner sc3 = new Scanner(System.in);
				String senha1 = sc3.nextLine();

				System.out.print("Confirmacao : ");
				Scanner sc4 = new Scanner(System.in);
				String senha2 = sc4.nextLine();

				if (senha1.equals(senha2)) {

					c.usuarios.admin_criar(usuario, cpf, senha1);

					c.prefs.definir("Cinema.preco", "0.0");
					c.prefs.definir("Cinema.endereco", "");

				} else {
					System.out.println("\n  Senhas nao conferem !!! ");
				}

			} else if (tipo.equals("s")) {
				break;

			} else {

				System.out.println("Tipo DESCONHECIDO !!! \n");

			}

		}

	}

}
