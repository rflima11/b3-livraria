package tech.ada.livraria.persistencia;

import tech.ada.livraria.model.Autor;

import java.util.ArrayList;

public class AutorBancoDeDados {

    private ArrayList<Autor> autores = new ArrayList<Autor>();


    public void salvarAutor(Autor autor) {
        autores.add(autor);
    }

    public ArrayList<Autor> buscarAutorPorNome(String nome) {
        ArrayList<Autor> autoresEncontrados = new ArrayList<>();

        for(Autor autor : autores) {

            if (autor.getNome().equalsIgnoreCase(nome)) { //autor.getNome().toLowerCase().startsWith(nome.toLowerCase())) {
                autoresEncontrados.add(autor);
            }
        }
        return autoresEncontrados;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

}
