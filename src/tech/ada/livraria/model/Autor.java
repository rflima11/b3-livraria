package tech.ada.livraria.model;

import java.util.ArrayList;

public class Autor {

    private String nome;
    private String cpf;
    private ArrayList<Livro> livros;

    public Autor(String nome, String cpf, ArrayList<Livro> livros) {
        this.nome = nome;
        this.cpf = cpf;
        this.livros = livros;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }



    public ArrayList<Livro> getLivros() {
        return livros;
    }
}
