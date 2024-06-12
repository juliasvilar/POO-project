import java.util.List;
import java.util.Scanner;

class Interface {
    
    Perfil perfil = new Perfil();
    String confirmacaosenha;
    
    public Interface(Perfil perfil) {
        this.perfil = perfil;
    }
    
    public void cadastro(){
        Scanner scanner = new Scanner(System.in);
       
        System.out.println("===== CADASTRO =====");
        System.out.println("Nome de usuario: ");
        perfil.nome = scanner.nextLine();
        System.out.println("Email: ");
        perfil.email = scanner.nextLine();
        System.out.println("Crie sua senha: ");
        perfil.senha = scanner.nextLine();
        System.out.println("Confirme sua senha: ");
        confirmacaosenha = scanner.nextLine();
        while(!confirmacaosenha.equals(perfil.senha)){
            System.out.println("As senhas precisam ser iguais. Tente novamente: ");
            confirmacaosenha = scanner.nextLine();
        }
        System.out.println("\nUsuario cadastrado com sucesso!");
    }
    
    public void login() throws InterruptedException{
        Thread.sleep(1000);
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n===== LOGIN =====");
        System.out.println("Email ou nome de usuario: ");
        String emailOuNomeEntrar = scanner.nextLine();
        System.out.println("Senha: ");
        perfil.senha = scanner.nextLine();
        
        while(!perfil.senha.equals(confirmacaosenha) || (!emailOuNomeEntrar.equals(perfil.nome) && !emailOuNomeEntrar.equals(perfil.email))){
            System.out.println("Senha, email ou nome de usuario incorretos! Tente novamente.");
            System.out.println("\n===== LOGIN =====");
            System.out.println("Email ou nome de usuário: ");
            emailOuNomeEntrar = scanner.nextLine();
            System.out.println("Senha: ");
            perfil.senha = scanner.nextLine();
        }
        if (emailOuNomeEntrar.equals(perfil.email)){
            System.out.printf("\nBem vindo(a), %s!\n\n",perfil.email);
        } else {
            System.out.printf("\nBem vindo(a), %s!\n\n",perfil.nome);
        }        
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
        System.out.println("OUTRAS OPCOES");
        System.out.println("9 - Editar perfil");
        System.out.println("10 - Visualizar perfil");
        System.out.println("11 - Deslogar");
        System.out.println("0. Fechar programa");
        System.out.println("================");
    }
    
    public void mostrarPerfil(){
        System.out.printf("\nNome de usuario: %s\nEmail: %s\n ",perfil.nome,perfil.email);
    }
}
