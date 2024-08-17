package tech.ada.livraria;

import tech.ada.livraria.model.Autor;
import tech.ada.livraria.model.Genero;
import tech.ada.livraria.model.Livro;
import tech.ada.livraria.negocio.AutorNegocio;
import tech.ada.livraria.negocio.LivroNegocio;
import tech.ada.livraria.persistencia.AutorBancoDeDados;
import tech.ada.livraria.persistencia.LivroBancoDeDados;

import java.util.Scanner;

import java.util.ArrayList;
public class Aplicacao {

    public static void main(String[] args) {
        AutorBancoDeDados autorBancoDeDados = new AutorBancoDeDados();

        AutorNegocio negocio = new AutorNegocio(autorBancoDeDados);

        LivroBancoDeDados livroBancoDeDados = new LivroBancoDeDados();

        LivroNegocio livroNegocio = new LivroNegocio(livroBancoDeDados);

        Scanner scanner = new Scanner(System.in);

        int opcaoEscolhida = 0;

        do {
            System.out.println("Digite a opção escolhida: ");
            System.out.println("Opção 1 - Cadastrar novo autor");
            System.out.println("Opção 2 - Buscar autor por nome");
            System.out.println("Opção 3 - Cadastrar novo livro");
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
                        new ArrayList<Livro>()
                );

                negocio.salvar(autorQueSeraSalvo);

                negocio.obterAutores();
            }

            if (opcaoEscolhida == 2) {
                System.out.println("Escreva o nome do autor buscado: ");
                String nomeBusca = scanner.nextLine();

                ArrayList<Autor> autoresEncontrados = negocio.encontrarAutorPorNome(nomeBusca);

                for(Autor autor : autoresEncontrados) {
                    System.out.println("Nome: " + autor.getNome());
                    System.out.println("CPF: " + autor.getCpf());
                    System.out.println("Livros: ");
                    for(Livro livro : autor.getLivros()) {
                        System.out.println("Titulo: " + livro.getTitulo());
                    }
                }
            }

            if (opcaoEscolhida == 3) {
                System.out.println("Informe o titulo do livro: ");
                String tituloLivro = scanner.nextLine();

                System.out.println("Deseja associar um autor para o livro? : ");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                int opcaoAdicionarAutor = scanner.nextInt();

                Livro livro = new Livro(
                        tituloLivro,
                        Genero.TERROR,
                        null
                );

                scanner.nextLine();

                if (opcaoAdicionarAutor == 1) {
                    ArrayList<Autor> autoresSalvos = negocio.obterAutores();
                    System.out.println("Digite o nome do autor desejado: ");
                    String nomeAutorAssociado = scanner.nextLine();
                    ArrayList<Autor> autoresEncontrados = negocio.encontrarAutorPorNome(nomeAutorAssociado);
                    livro.setAutor(autoresEncontrados.get(0));
                }

                livroNegocio.salvarLivro(livro);

                ArrayList<Livro> livrosSalvos = livroBancoDeDados.getLivros();
                for(Livro livroEncontrado : livrosSalvos) {
                    System.out.println("Titulo: " + livroEncontrado.getTitulo());
                    System.out.println("Autor: " + livroEncontrado.getAutor().getNome());
                }


            }

        } while (opcaoEscolhida != 0);

    }
}
