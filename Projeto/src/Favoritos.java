import java.util.ArrayList;
import java.util.List;

class Favoritos {
    private List<Filme> filmesFavoritos;
    private List<Livro> livrosFavoritos;

    public Favoritos() {
        this.filmesFavoritos = new ArrayList<>();
        this.livrosFavoritos = new ArrayList<>();
    }

    public void adicionarFilme(Filme filme) {
        filmesFavoritos.add(filme);
    }

    public void adicionarLivro(Livro livro) {
        livrosFavoritos.add(livro);
    }

    public void exibirFilmesFavoritos() {
        System.out.println("Filmes Favoritos:");
        for (Filme filme : filmesFavoritos) {
            filme.exibeFichaTecnica();
        }
    }

    public void exibirLivrosFavoritos() {
        System.out.println("Livros Favoritos:");
        for (Livro livro : livrosFavoritos) {
            livro.exibeFichaTecnica();
        }
    }

    public void exibirLivrosEFilmesFavoritos(){
        exibirFilmesFavoritos();
        exibirLivrosFavoritos();
    }
}