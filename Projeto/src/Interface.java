import java.util.List;
import java.util.Scanner;

class Interface {
    
    public void login(){
        Scanner scanner = new Scanner(System.in);
        String senha_salva = "123456";

        System.out.println("===== LOGIN =====");
        System.out.println("Email ou nome de usuário: ");
        String emailOuNome = scanner.nextLine();
        System.out.println("Senha: ");
        String senha = scanner.nextLine();
        
        while(!senha.equals(senha_salva)){
            System.out.println("Senha incorreta! Tente novamente.");
            senha = scanner.nextLine();
        }        
        System.out.printf("\nBem vindo(a) de volta, %s!\n\n",emailOuNome);
    }
    
    
    public void exibirFilmes(List<Filme> filmes) {
        System.out.println("Lista de filmes:");
        for (Filme filme : filmes) {
            filme.exibeFichaTecnica();
        }
    }

    public void exibirLivros(List<Livro> livros) {
        System.out.println("Lista de livros:");
        for (Livro livro : livros) {
            livro.exibeFichaTecnica();
        }
    }
    

    public void exibirFilmesFavoritos(List<Filme> filmesFavoritos) {
        System.out.println("Filmes Favoritos:");
        for (Filme filme : filmesFavoritos) {
            filme.exibeFichaTecnica();
        }
    }

    public void exibirLivrosFavoritos(List<Livro> livrosFavoritos) {
        System.out.println("Livros Favoritos:");
        for (Livro livro : livrosFavoritos) {
            livro.exibeFichaTecnica();
        }
    }
    
    public void exibirMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("FILMES");
        System.out.println("1. Adicionar filme na lista"); 
        System.out.println("2. Mostrar filmes na lista de filmes"); 
        System.out.println("3. Mostrar filmes favoritos"); 
        System.out.println("LIVROS");
        System.out.println("4. Adicionar livro na lista");
        System.out.println("5. Mostrar livros na lista de livros"); 
        System.out.println("6. Mostrar livros favoritos"); 
        System.out.println("0. Sair");
        System.out.println("================");
    }  
    
}
