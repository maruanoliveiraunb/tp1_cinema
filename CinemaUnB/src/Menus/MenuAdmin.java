package Menus;

import java.util.ArrayList;
import java.util.Scanner;

import Cinema.Cinema;
import Cinema.Filme;
import Cinema.Funcionario;
import Cinema.Sala;
import Cinema.Sessao;

public class MenuAdmin {

	public static void menu_admin(Cinema c) throws Exception {

		while (true) {

			System.out.printf("\n");
			System.out.printf("\n");

			System.out.println("Escolha uma opção abaixo : ");
			System.out.printf("\n");
			System.out.printf(" - cin  : Informacoes Basicas \n");
			System.out.printf("\n");

			System.out.printf(" - n  : Definir o nome do Cinema \n");
			System.out.printf(" - f  : Criar FUNCIONARIO \n");
			System.out.printf(" - l  : Listar FUNCIONARIOS \n");
			System.out.printf(" - p  : Definir PRECO \n");
			System.out.printf(" - e  : Definir ENDERECO \n");
			System.out.printf(" - s  : Sair \n");
			System.out.printf("\n");

			System.out.printf("Opcao : ");
			Scanner sc = new Scanner(System.in);
			String tipo = sc.nextLine();

			if (tipo.equals("cin")) {
				informacoes_basicas(c);
			} else if (tipo.equals("f")) {
				System.out.println("\n  ---- CRIAR FUNCIONARIO  ----\n ");

				System.out.print("Usuario : ");
				Scanner sc1 = new Scanner(System.in);
				String usuario = sc.nextLine();

				if (c.usuarios.existe_usuario(usuario) == true) {
					System.out
							.println("\n Ja existe um usuario com esse NOME !!! ");
				} else {

					System.out.print("CPF : ");
					Scanner sc2 = new Scanner(System.in);
					String cpf = sc2.nextLine();

					if (c.usuarios.existe_cpf(cpf) == true) {
						System.out
								.println("\n Ja existe um usuario com esse CPF !!! ");
					} else {
						System.out.print("Senha : ");
						Scanner sc3 = new Scanner(System.in);
						String senha1 = sc3.nextLine();

						System.out.print("Confirmacao : ");
						Scanner sc4 = new Scanner(System.in);
						String senha2 = sc4.nextLine();

						if (senha1.equals(senha2)) {

							c.usuarios.funcionario_criar(usuario, cpf, senha1);

						} else {
							System.out.println("\n  Senhas nao conferem !!! ");
						}

					}

				}

			} else if (tipo.equals("l")) {

				System.out
						.println("\n------------- LISTAR FUNCIONARIOS ---------------------- \n");

				ArrayList<Funcionario> lista = c.usuarios.funcionarios_listar();

				for (int s = 0; s < lista.size(); s++) {
					System.out.printf("\nFuncionario %d - %s ", lista.get(s)
							.getID(), lista.get(s).getNome());
				}

				System.out.println("\n");
			} else if (tipo.equals("n")) {

				System.out.println("\n  ---- DEFINIR NOME DO CINEMA ----\n ");
				System.out.print("Nome : ");

				Scanner sc1 = new Scanner(System.in);
				String nome = sc.nextLine();

				c.prefs.definir("Cinema.nome", nome);
			} else if (tipo.equals("p")) {

				System.out.println("\n  ---- DEFINIR PRECO DO CINEMA ----\n ");
				System.out.print("Preco : ");

				Scanner sc1 = new Scanner(System.in);
				double nome1 = sc.nextDouble();
				String nome = String.valueOf(nome1);

				c.prefs.definir("Cinema.preco", nome);

			} else if (tipo.equals("e")) {

				System.out
						.println("\n  ---- DEFINIR ENDERECO DO CINEMA ----\n ");
				System.out.print("Endereco : ");

				Scanner sc1 = new Scanner(System.in);
				String nome = sc.nextLine();

				c.prefs.definir("Cinema.endereco", nome);

			} else if (tipo.equals("s")) {
				break;
			} else {

				System.out.println("Tipo DESCONHECIDO !!! \n");

			}

		}

	}

	public static void informacoes_basicas(Cinema c) throws Exception {

		System.out.println("\n  ---- INFORMACOES GERAIS BASICAS ----\n ");

		System.out.printf("\nNome : %s", c.getNome());
		System.out.printf("\nEndereco : %s", c.getEndereco());
		System.out.println("\n");

		System.out.printf("\nPreco Inteira : %.2f", c.getInteira());
		System.out.printf("\nPreco Meia : %.2f", c.getMeia());

		System.out.println("\n");
		System.out.printf("\nIngressos Vendidos : %d", c.getIngressos());
		System.out.printf("\n\t - Inteiras Vendidas : %d", c.getInteiras());
		System.out.printf("\n\t - Meias Vendidas : %d", c.getMeias());

		System.out.println("\n");
		System.out.printf("\nReceita Bruta : %.2f", c.getReceitaBruta());

		System.out.printf("\n\t - Receita Inteira : %.2f",
				c.getReceitaInteira());
		System.out.printf("\n\t - Receita Meia : %.2f", c.getReceitaMeia());

		System.out.println("\n");

	}

}
