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

    public String getTitulo() {
        return this.titulo;
    }

    public Autor getAutor() {
        return this.autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
