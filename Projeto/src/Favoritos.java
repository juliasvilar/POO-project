import java.util.ArrayList;
import java.util.List;

class Favoritos {
    public List<Filme> filmesFavoritos;
    public List<Livro> livrosFavoritos;

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
    
    public List<Filme> getFilmesFavoritos() {
        return filmesFavoritos;
    }
    
    public List<Livro> getLivrosFavoritos() {
        return livrosFavoritos;
    }

}
