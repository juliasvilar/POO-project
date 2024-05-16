import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        List<Filme> listaDeFilmes = new ArrayList<>();
        List<Livro> listaDeLivros = new ArrayList<>();
        Favoritos favoritos = new Favoritos();
        int resposta;
        
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
        
        Thread.sleep(1500);

        do {
            exibirMenu();
            System.out.print("Informe a opcao desejada: ");
            resposta = scanner.nextInt();

            switch (resposta) {
                case 1:                   
                    Filme.adicionarFilme(scanner, listaDeFilmes, favoritos);                   
                    break;
                                   
                case 2: 
                    System.out.println("Lista de filmes:");
                    for (Filme f : listaDeFilmes) {
                        f.exibeFichaTecnica();
                    }
                    break;                                          
                
                case 3: 
                    if (favoritos.getFilmesFavoritos().isEmpty()) {
                        System.out.println("Lista vazia!");
                    } else {
                        favoritos.exibirFilmesFavoritos();
                    }
                    break; 
                     
                case 4: 
                    Livro.adicionarLivro(scanner, listaDeLivros, favoritos);
                    break;                                   
                case 5: 
                    System.out.println("Lista de livros:");
                    for (Livro l : listaDeLivros) {
                        l.exibeFichaTecnica();
                    }
                    break;
                    
                case 6: 
                    if (favoritos.getLivrosFavoritos().isEmpty()) {
                        System.out.println("Lista vazia!");
                    } else {
                        favoritos.exibirLivrosFavoritos();
                    }
                    break; 
                case 0: 
                    System.out.println("Fechando programa...");
                    break;

                default: 
                    System.out.println("Opcao inválida! Tente novamente.");
                    break;
            }

        } while (resposta != 0);

        scanner.close();
    }

    public static void exibirMenu() {
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
