import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        List<Filme> listaDeFilmes = new ArrayList<>();
        List<Livro> listaDeLivros = new ArrayList<>();
        Favoritos favoritos = new Favoritos();
        Interface minhaInterface = new Interface();
        int resposta;
        
        minhaInterface.login();
                
        do {
            Thread.sleep(1500);
            minhaInterface.exibirMenu();
            System.out.print("Informe a opcao desejada: ");
            resposta = scanner.nextInt();

            switch (resposta) {
                case 1:                   
                    Filme.adicionarFilme(scanner, listaDeFilmes, favoritos);                   
                    break;
                                   
                case 2: 
                    minhaInterface.exibirFilmes(listaDeFilmes);
                    break;                                          
                
                case 3: 
                    if (favoritos.getFilmesFavoritos().isEmpty()) {
                        System.out.println("Lista vazia!");
                    } else {
                        minhaInterface.exibirFilmesFavoritos(favoritos.getFilmesFavoritos());
                    }
                    break; 
                
                case 4:
                    favoritos.removerFilmeFavorito();
                    break;
                case 5: 
                    Livro.adicionarLivro(scanner, listaDeLivros, favoritos);
                    break;                                   
                
                case 6: 
                    minhaInterface.exibirLivros(listaDeLivros);
                    break;
                    
                case 7: 
                    if (favoritos.getLivrosFavoritos().isEmpty()) {
                        System.out.println("\nLista vazia!");
                    } else {
                        minhaInterface.exibirLivrosFavoritos(favoritos.getLivrosFavoritos());
                    }
                    break; 
                   
                case 8:
                    favoritos.removerLivroFavorito();
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
}
