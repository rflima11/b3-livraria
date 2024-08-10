package tech.ada.livraria;

import tech.ada.livraria.model.Autor;
import tech.ada.livraria.negocio.AutorNegocio;
import tech.ada.livraria.persistencia.AutorBancoDeDados;
import java.util.Scanner;

import java.util.ArrayList;
public class Aplicacao {

    public static void main(String[] args) {
        AutorBancoDeDados autorBancoDeDados = new AutorBancoDeDados();

        AutorNegocio negocio = new AutorNegocio(autorBancoDeDados);

        Scanner scanner = new Scanner(System.in);

        int opcaoEscolhida = 0;

        do {
            System.out.println("Digite a opção escolhida: ");
            System.out.println("Opção 1 - Cadastrar novo autor");
            System.out.println("Opção 0 - Sair");
            opcaoEscolhida = scanner.nextInt();

            scanner.nextLine();

            if (opcaoEscolhida == 1) {
                System.out.println("Escreva o nome do autor: ");
                String nomeDoAutor = scanner.nextLine();


                System.out.println("Informe o cpf do autor: ");
                String cpf = scanner.nextLine();

                Autor autorQueSeraSalvo = new Autor(
                        nomeDoAutor,
                        cpf,
                        null
                );

                negocio.salvar(autorQueSeraSalvo);

                negocio.obterAutores();
            }

        } while (opcaoEscolhida != 0);

    }
}
