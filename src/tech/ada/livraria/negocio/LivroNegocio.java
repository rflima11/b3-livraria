package tech.ada.livraria.negocio;

import tech.ada.livraria.model.Livro;
import tech.ada.livraria.persistencia.LivroBancoDeDados;

public class LivroNegocio {

    private LivroBancoDeDados bancoDeDados;

    public LivroNegocio(LivroBancoDeDados bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

    public void salvarLivro(Livro livro) {
        //validações de campo
        bancoDeDados.salvarLivro(livro);
    }
}
