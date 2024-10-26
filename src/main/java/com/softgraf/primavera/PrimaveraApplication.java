package com.softgraf.primavera;

import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.softgraf.primavera.service.CrudService;

import static java.lang.System.out;

@SpringBootApplication
public class PrimaveraApplication implements CommandLineRunner {

	private final CrudService crudService;

	public static void main(String[] args) {
		SpringApplication.run(PrimaveraApplication.class, args);
	}

	public PrimaveraApplication(CrudService crudService) {
		this.crudService = crudService;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Executou run() do CommandLineRunner");
		Scanner scanner = new Scanner(System.in);
		boolean rodar = true;
		
		while (rodar) {
			out.println("\n\n===== Sistema Primavera =====");
			out.println("1 - Cadastra 3 produtos padrões");
			out.println("2 - Cadastra novo produto");
			out.println("3 - Cadastra 100 produtos aleatórios");
			out.println("4 - Lista todos os produtos");
			out.println("5 - Busca produto por descrição");
			out.println("6 - Lista produtos com paginação (20/pag) em ordem ASC de id");
			out.println("7 - Sair");
			
			int opcao = 0;
			while (opcao < 1 || opcao > 7) {
				out.println("Qual opção?");
				opcao = scanner.nextInt();
			}
			
			
			switch (opcao) {
				case 1 -> crudService.cadastra3Produtos();
				case 2 -> crudService.cadastraNovoProduto();
				case 3 -> crudService.cadastra100Produtos();
				case 4 -> crudService.listaTodosProdutos();
				case 5 -> crudService.buscaPorDescricao();
				case 6 -> crudService.listaProdutosComPaginacao("id");
				case 7 -> rodar = false;
			}
		}	
		
		scanner.close();
		out.println("\nFui! Tchau!");
	}
}
