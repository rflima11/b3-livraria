package tech.ada.livraria.model;

public class Livro {

    private String titulo;

    private Genero genero;

    private Autor autor;

    public Livro(String titulo, Genero genero, Autor autor) {
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
    }

}
