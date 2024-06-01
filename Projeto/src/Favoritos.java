import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    
    
    public void removerFilmeFavorito() {
        if (getFilmesFavoritos().isEmpty()) {
            System.out.println("Lista vazia!");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Que filme você deseja remover da lista de favoritos? ");
            String filme = scanner.nextLine();

            for(int i = 0; i < filmesFavoritos.size(); i++){
                Filme p = filmesFavoritos.get(i);

                if(p.getNome().equals(filme)){
                    filmesFavoritos.remove(p);
                    System.out.println("Filme removido da lista de favoritos!");
                    return;
                }
            }
            System.out.println("Filme nao favoritado.\n");
        }
    }
}
