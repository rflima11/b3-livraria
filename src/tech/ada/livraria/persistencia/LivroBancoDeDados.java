package tech.ada.livraria.persistencia;

import tech.ada.livraria.model.Livro;

import java.util.ArrayList;

public class LivroBancoDeDados {

    private ArrayList<Livro> livros = new ArrayList<Livro>();


    public void salvarLivro(Livro livro) {
        livros.add(livro);
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }
}
