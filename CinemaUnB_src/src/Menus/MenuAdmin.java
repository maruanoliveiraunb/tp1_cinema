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

			System.out.println("Escolha uma opção abaixo : ");
			System.out.printf("\n");
			System.out.printf(" - n  : Definir o nome do Cinema \n");
			System.out.printf(" - f  : Criar FUNCIONARIO \n");
			System.out.printf(" - l  : Listar FUNCIONARIOS \n");
			System.out.printf(" - s  : Sair \n");
			System.out.printf("\n");
			
			
			System.out.printf("Opcao : ");
			Scanner sc = new Scanner(System.in);
			String tipo = sc.nextLine();

		 if (tipo.equals("f")){
				System.out.println("\n  ---- CRIAR FUNCIONARIO  ----\n ");
				
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
				
				if (senha1.equals(senha2)){
					
					c.usuarios.funcionario_criar(usuario, cpf, senha1);
					
					
					
				}else{
					System.out.println("\n  Senhas nao conferem !!! ");
				}
				
			}else if (tipo.equals("l")){
				
				System.out.println("\n------------- LISTAR FUNCIONARIOS ---------------------- \n");

				ArrayList<Funcionario> lista = c.usuarios.funcionarios_listar();

				
				for (int s = 0; s < lista.size(); s++) {
						System.out.printf(
								"\nFuncionario %d - %s ",
								lista.get(s).getID(), lista.get(s).getNome());
				}
				
				System.out.println("\n");
			}else if (tipo.equals("n")) {
					
					System.out.println("\n  ---- DEFINIR NOME DO CINEMA ----\n ");
					System.out.print("Nome : ");

					Scanner sc1 = new Scanner(System.in);
					String nome = sc.nextLine();
				
					c.prefs.definir("Cinema.nome", nome);
					
			}else if (tipo.equals("s")){
break;
			}else{
				
				System.out.println("Tipo DESCONHECIDO !!! \n");

			}
			
			
			
		}

	}
	
	
	
}
