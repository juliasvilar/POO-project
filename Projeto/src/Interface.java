import java.util.List;
import java.util.Scanner;

class Interface {
    
    public void login(){
        Scanner scanner = new Scanner(System.in);
       
        System.out.println("===== CADASTRO =====");
        System.out.println("Email ou nome de usuario: ");
        String emailOuNome = scanner.nextLine();
        System.out.println("Crie sua senha: ");
        String senha = scanner.nextLine();
        System.out.println("Confirme sua senha: ");
        String confirmacaosenha = scanner.nextLine();
        while(!confirmacaosenha.equals(senha)){
            System.out.println("As senhas precisam ser iguais. Tente novamente: ");
            confirmacaosenha = scanner.nextLine();
        }
        System.out.println("\nUsuario cadastrado com sucesso!");
        
        System.out.println("\n===== LOGIN =====");
        System.out.println("Email ou nome de usuário: ");
        String emailOuNomeEntrar = scanner.nextLine();
        System.out.println("Senha: ");
        senha = scanner.nextLine();
        
        while(!senha.equals(confirmacaosenha) || !emailOuNomeEntrar.equals(emailOuNome)){
            System.out.println("Senha, email ou nome de usuário incorretos! Tente novamente.");
            System.out.println("\n===== LOGIN =====");
            System.out.println("Email ou nome de usuário: ");
            emailOuNomeEntrar = scanner.nextLine();
            System.out.println("Senha: ");
            senha = scanner.nextLine();
        }        
        System.out.printf("\nBem vindo(a) de volta, %s!\n\n",emailOuNome);
    }
    
    
    public void exibirFilmes(List<Filme> filmes) {
        System.out.println("\nLista de filmes:");
        for (Filme filme : filmes) {
            filme.exibeFichaTecnica();
        }
    }

    public void exibirLivros(List<Livro> livros) {
        System.out.println("\nLista de livros:");
        for (Livro livro : livros) {
            livro.exibeFichaTecnica();
        }
    }
    

    public void exibirFilmesFavoritos(List<Filme> filmesFavoritos) {
        System.out.println("\nFilmes Favoritos:");
        for (Filme filme : filmesFavoritos) {
            filme.exibeFichaTecnica();
        }
    }

    public void exibirLivrosFavoritos(List<Livro> livrosFavoritos) {
        System.out.println("\nLivros Favoritos:");
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
        System.out.println("4. Remover filme da lista de favoritos");
        System.out.println("LIVROS");
        System.out.println("5. Adicionar livro na lista");
        System.out.println("6. Mostrar livros na lista de livros"); 
        System.out.println("7. Mostrar livros favoritos");
        System.out.println("8. Remover livro da lista de favoritos");
        System.out.println("0. Sair");
        System.out.println("================");
    }  
    
}
