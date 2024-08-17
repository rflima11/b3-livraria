package tech.ada.livraria.negocio;

import java.util.ArrayList;
import tech.ada.livraria.model.Autor;
import tech.ada.livraria.persistencia.AutorBancoDeDados;

public class AutorNegocio {

    private AutorBancoDeDados bancoDeDados;

    public AutorNegocio(AutorBancoDeDados bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

    public void salvar(Autor autor) {
        if (autor.getNome() != null && !autor.getNome().isBlank()) {
            bancoDeDados.salvarAutor(autor);
        }
    }

    public ArrayList<Autor> encontrarAutorPorNome(String nome) {
        if (nome != null && !nome.isBlank()) {
            return bancoDeDados.buscarAutorPorNome(nome);
        }
        throw new IllegalArgumentException("Parâmetro nome deve ser preenchido");
    }

    public ArrayList<Autor> obterAutores() {
       ArrayList<Autor> autoresSalvos = bancoDeDados.getAutores();

       for(Autor autor : autoresSalvos) {
           System.out.println("Nome: " + autor.getNome());
       }

       return autoresSalvos;
    }

}
