package Menus;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Cinema.Cinema;
import Cinema.Filme;
import Cinema.IngressoTipo;
import Cinema.Sala;
import Cinema.Sessao;

public class MenuFuncionario {


	public static void menu_funcionario(Cinema c) throws Exception {

		while (true) {

			System.out.println("Escolha uma opção abaixo : ");
			System.out.printf("\n");
			System.out.printf(" - cin  : Informacoes Basicas \n");
			System.out.printf("\n");

			System.out.printf(" - sc  : Criar nova sala \n");
			System.out.printf(" - sl  : Listar salas \n");
			System.out.printf(" - sld  : Listar detalhes de todas as salas \n");
			System.out.printf(" - sd : Detalhes da sala \n");
			System.out.printf("\n");
			System.out.printf(" - fc : Criar Filme \n");
			System.out.printf(" - fl : Listar Filmes \n");

			System.out.printf("\n");
			System.out.printf(" - ssc : Criar Sessao \n");
			System.out.printf(" - ssl : Listar Sessoes \n");
			System.out.printf(" - ssd : Listar Sessoes do Dia \n");
			System.out.printf(" - sss : Listar Sessoes da Sala \n");
			System.out.printf(" - ssf : Listar Sessoes do Filme \n");
			System.out.printf(" - ssh : Listar Sessoes de Hoje \n");
			System.out.printf(" - ssi : Informacoes da Sessao \n");

			System.out.printf("\n");
			System.out.printf(" - cmp : Comprar ingresso \n");

			System.out.printf("\n");

			System.out.printf("Opcao : ");
			Scanner sc = new Scanner(System.in);
			String tipo = sc.nextLine();

			if (tipo.equals("cin")) {
				System.out
						.println("\n  ---- INFORMACOES GERAIS BASICAS ----\n ");

				System.out.printf("\nNome : %s", c.getNome());
				System.out.printf("\nPreco Inteira : %.2f", c.getInteira());
				System.out.printf("\nPreco Meia : %.2f", c.getMeia());

				System.out
						.printf("\nIngressos Vendidos : %d", c.getIngressos());
				System.out.printf("\nInteiras Vendidas : %d", c.getInteiras());
				System.out.printf("\nMeias Vendidas : %d", c.getMeias());

				System.out
						.printf("\nReceita Bruta : %.2f", c.getReceitaBruta());

				System.out.println("\n");

			} else if (tipo.equals("sc")) {
				System.out.println("\n  ---- CRIAR NOVA SALA ----\n ");
				System.out.print("Nome : ");

				Scanner sc1 = new Scanner(System.in);
				String nome = sc.nextLine();

				System.out.print("Poltronas : ");
				int poltronas = sc.nextInt();

				System.out.print("Fileiras : ");
				int fileiras = sc.nextInt();

				try {
					c.salas.criar(nome, poltronas, fileiras);
				} catch (Exception e) {
					System.out.printf("\n  ERRO :  %\n", e.getMessage());
				}

			} else if (tipo.equals("sl")) {

				System.out.println("\n  ---- LISTAR TODAS AS SALAS ----\n ");

				c.sala_listar();
			} else if (tipo.equals("sld")) {

				System.out
						.println("\n  ---- LISTAR DETALHES DE TODAS AS SALAS ----\n ");

				c.sala_mostrar();
			} else if (tipo.equals("sd")) {

				System.out.println("\n  ---- LISTAR DETALHES DA SALA  ----\n ");

				System.out.print("Sala : ");
				int salaid = sc.nextInt();

				c.sala_mostrarporid(salaid);

			} else if (tipo.equals("fc")) {

				System.out.println("\n  ---- CRIAR FILME  ----\n ");

				System.out.print("Nome : ");
				String nome = sc.nextLine();

				System.out.print("Duracao : ");
				int duracao = sc.nextInt();

				Scanner sc3 = new Scanner(System.in);

				System.out.print("Idioma : ");
				String idioma = sc3.nextLine();

				Scanner sc2 = new Scanner(System.in);

				System.out.print("Tipo : ");
				String tipo2 = sc2.nextLine();

				try {
					c.filme_cadastrar(nome, duracao, idioma, tipo2);
				} catch (Exception e) {
					System.out.printf("\n  ERRO :  %\n", e.getMessage());
				}

			} else if (tipo.equals("fl")) {

				System.out.println("\n  ---- LISTAR FILMES  ----\n ");

				c.filme_listar();

			} else if (tipo.equals("ssc")) {

				System.out.println("\n  ---- CRIAR SESSAO  ----\n ");

				Scanner sc2 = new Scanner(System.in);
				System.out.print("Data : ");
				String tipo2 = sc2.nextLine();

				Scanner sc3 = new Scanner(System.in);
				System.out.print("Horario : ");
				String tipo3 = sc3.nextLine();

				Scanner sc4 = new Scanner(System.in);
				System.out.print("Filme ID : ");
				int tipo4 = sc4.nextInt();

				Scanner sc5 = new Scanner(System.in);
				System.out.print("Sala ID : ");
				int tipo5 = sc5.nextInt();

				try {
					c.sessoes_criar(tipo5, tipo4, tipo2, tipo3);
				} catch (Exception e) {
					System.out.printf("\n  ERRO :  %\n", e.getMessage());
				}

			} else if (tipo.equals("ssl")) {

				System.out.println("\n  ---- LISTAR SESSOES  ----\n ");

				c.sessoes_listar();

			} else if (tipo.equals("ssd")) {

				System.out.println("\n  ---- LISTAR SESSOES DO DIA  ----\n ");

				Scanner sc2 = new Scanner(System.in);
				System.out.print("Data : ");
				String tipo2 = sc2.nextLine();

				c.sessoes_listardia(tipo2);
			} else if (tipo.equals("ssh")) {

				System.out.println("\n  ---- LISTAR SESSOES DE HOJE  ----\n ");

				Date data = new Date(System.currentTimeMillis());
				SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

				c.sessoes_listardia(formatador.format(data));

			} else if (tipo.equals("sss")) {

				System.out.println("\n  ---- LISTAR SESSOES DA SALA  ----\n ");

				Scanner sc2 = new Scanner(System.in);
				System.out.print("Sala : ");
				String tipo2 = sc2.nextLine();

				c.sessoes_listarsala(tipo2);
			} else if (tipo.equals("ssf")) {

				System.out.println("\n  ---- LISTAR SESSOES DO FILME  ----\n ");

				Scanner sc2 = new Scanner(System.in);
				System.out.print("Filme : ");
				int tipo2 = sc2.nextInt();

				c.sessoes_listarfilme(tipo2);
			} else if (tipo.equals("cmp")) {

				System.out.println("\n  ---- COMPRAR INGRESSO  ----\n ");

				Scanner sc2 = new Scanner(System.in);
				System.out.print("Sessao : ");
				int tipo2 = sc2.nextInt();

				Sessao sco = c.sessao_obter(tipo2);

				System.out.printf("\nFilme : %s",
						c.filmes_obter(sco.getFilmeid()).getChamada());
				System.out.printf("\nData : %s as %s", sco.getData(),
						sco.getHorario());

				System.out.println("\n");

				sco.mostrardisponiveis(c.sala_obter(sco.getSalaid())
						.getPoltronas(), c.sala_obter(sco.getSalaid())
						.getFileiras());

				System.out.println("\n");

				if (sco.getVendidos() < sco.getTotal()) {

					Scanner sc3 = new Scanner(System.in);
					System.out.print("Inteira ou Meia : ");
					String tipo3 = sc3.nextLine();

					boolean modovalido = false;
					IngressoTipo it = IngressoTipo.Inteira;

					if (tipo3.equals("Inteira")) {
						modovalido = true;
						it = IngressoTipo.Inteira;
					}
					if (tipo3.equals("INTEIRA")) {
						modovalido = true;
						it = IngressoTipo.Inteira;
					}
					if (tipo3.equals("inteira")) {
						modovalido = true;
						it = IngressoTipo.Inteira;
					}
					if (tipo3.equals("Meia")) {
						modovalido = true;
						it = IngressoTipo.Meia;
					}
					if (tipo3.equals("MEIA")) {
						modovalido = true;
						it = IngressoTipo.Meia;
					}
					if (tipo3.equals("meia")) {
						modovalido = true;
						it = IngressoTipo.Meia;
					}

					if (modovalido == true) {

						Scanner sc4 = new Scanner(System.in);
						System.out.print("Lugar : ");
						String tipo4 = sc4.nextLine();

						sco.comprar(tipo4, it, c.sala_obter(sco.getSalaid())
								.getPoltronas(), c.sala_obter(sco.getSalaid())
								.getFileiras());

					} else {

						System.out
								.println("Tipo de Ingresso DESCONHECIDO !!! \n");

					}

				} else {

					System.out.println("Ingressos ESGOTADOS !!! \n");

				}

			} else if (tipo.equals("ssi")) {

				System.out.println("\n  ---- INFORMACOES DA SESSAO  ----\n ");

				Scanner sc2 = new Scanner(System.in);
				System.out.print("Sessao : ");
				int tipo2 = sc2.nextInt();

				Sessao sco = c.sessao_obter(tipo2);
				Sala salac = c.sala_obter(sco.getSalaid());
				Filme filmec = c.filmes_obter(sco.getFilmeid());

				System.out.printf("\nChamada : %s", filmec.getChamada());
				System.out.printf("\nSala : %s", salac.getNome());
				System.out.printf("\nHorario : %s as %s", sco.getData(),
						sco.getHorario());

				System.out.printf("\nPoltronas : %d", salac.getPoltronas());
				System.out.printf("\nFileiras : %d", salac.getFileiras());
				System.out.printf("\nLugares : %d", salac.getLugares());

				int disponivel = sco.getTotal() - sco.getVendidos();

				System.out.printf("\nDisponiveis : %d", disponivel);
				System.out.printf("\nVendidos : %d", sco.getVendidos());

				System.out.printf("\n\nInteiras : %d", sco.getInteiras());
				System.out.printf("\nMeias : %d", sco.getMeias());

				System.out.println("\n");

				sco.mostrardisponiveis(c.sala_obter(sco.getSalaid())
						.getPoltronas(), c.sala_obter(sco.getSalaid())
						.getFileiras());

				System.out.println("\n");

			} else {

				System.out.println("Tipo DESCONHECIDO !!! \n");

			}

			System.out
					.println(" -------------- ---------- ----------------- ---------- -----------------");

		}

	}
}
