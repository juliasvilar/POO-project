import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Filme> listaDeFilmes = new ArrayList<>();
        List<Livro> listaDeLivros = new ArrayList<>();
        Favoritos favoritos = new Favoritos();
        int resposta;
        int fav;

        do {
            exibirMenu();
            System.out.print("Informe a opcao desejada: ");
            resposta = scanner.nextInt();

            switch (resposta) {
                case 1: // adiciona filme na lista
                    scanner.nextLine(); 
                    Filme filme = new Filme();
                    System.out.print("Digite o nome do filme: ");
                    String nomeFilme = scanner.nextLine();

                    boolean filmeExistente = false;
                    for (Filme f : listaDeFilmes) {
                        if (f.getNome().equalsIgnoreCase(nomeFilme)) {
                            filmeExistente = true;
                            break;
                        }
                    }

                    if (filmeExistente) {
                        System.out.println("Este filme ja esta na lista!");
                    } else {
                        filme.setNome(nomeFilme);

                        System.out.print("Digite a nota para o filme '" + filme.getNome() + "': ");
                        double notaFilme = scanner.nextDouble();
                        filme.setNota(notaFilme);

                        listaDeFilmes.add(filme);
                        System.out.println("Deseja adicionar o filme na lista dos favoritos? ");
                        System.out.println("1 - SIM\n2 - NAO: ");
                        fav = scanner.nextInt();
                        while(fav != 1 && fav != 2){
                            System.out.println("Resposta inválida!\n");
                        }
                        if(fav == 1){
                            favoritos.adicionarFilme(filme);
                            System.out.println("Filme adicionado aos favoritos!");

                        }
                    }
                    break;
                                   
                case 2: // lista filmes assistidos
                    System.out.println("Lista de filmes:");
                    for (Filme f : listaDeFilmes) {
                        f.exibeFichaTecnica();
                    }
                    break;                                          
                
                case 3: // exibe filmes favoritos
                    if (favoritos.getFilmesFavoritos().isEmpty()) {
                        System.out.println("Lista vazia!");
                    } else {
                        favoritos.exibirFilmesFavoritos();
                    }
                    break; 

                    
                case 4: // adicionar filmes favoritos
                    System.out.println("Em andamento...");
                    break;
                                        
                case 5: // adiciona livro na lista
                    scanner.nextLine(); 
                    Livro livro = new Livro();
                    System.out.print("Digite o nome do livro: ");
                    String nomeLivro = scanner.nextLine();
                    
                    boolean livroExistente = false;
                    for (Livro f : listaDeLivros) {
                        if (f.getNome().equalsIgnoreCase(nomeLivro)) {
                            livroExistente = true;
                            break;
                        }
                    }

                    if (livroExistente) {
                        System.out.println("Este livro ja esta na lista!");
                    } else {
                        livro.setNome(nomeLivro);

                        System.out.print("Digite a nota para o livro '" + livro.getNome() + "': ");
                        double notaLivro = scanner.nextDouble();
                        livro.setNota(notaLivro);

                        listaDeLivros.add(livro);
                        System.out.println("Deseja adicionar livro na lista de favoritos? ");
                        System.out.println("1 - SIM\n2 - NAO: ");
                        fav = scanner.nextInt();
                        while(fav != 1 && fav != 2){
                            System.out.println("Resposta inválida!\n");
                        }
                        if(fav == 1){
                            favoritos.adicionarLivro(livro);
                            System.out.println("Livro adicionado aos favoritos!");

                        }
                    }
                    break;
                
                    
                case 6: // exibe livros lidos
                    System.out.println("Lista de livros:");
                    for (Livro l : listaDeLivros) {
                        l.exibeFichaTecnica();
                    }
                    break;
                    
                case 7: // exibe livros favoritos
                    if (favoritos.getLivrosFavoritos().isEmpty()) {
                        System.out.println("Lista vazia!");
                    } else {
                        favoritos.exibirLivrosFavoritos();
                    }
                    break; 
                
                case 8: // adicionar livro aos favoritos
                    System.out.println("Em andamento...");
                    break;
                    
                /*case 4  e 8:
                    System.out.println("Deseja adicionar um filme ou um livro na lista de favoritos? ");
                    System.out.println("1- Filme\n2-Livro");
                    fav = scanner.nextInt();
                    while(fav != 1 && fav != 2){
                        System.out.println("Resposta inválida! Tente novamente: \n");
                        System.out.println("1- Filme\n2-Livro");
                        fav = scanner.nextInt();
                    }
                    if(fav == 1){//fazer opc para adicionar filmes ja assistidos nessa lista
                        System.out.println("Que filme você deseja adicionar aos favoritos?");
                        for (Filme f : listaDeFilmes) {
                            f.exibeFichaTecnica();
                        }
                    }
                */ //tem que implementar verificando se ele ja esta na lista de filmes
                   //e se ele ja esta nos favoritos, depois vou parar pra fazer pq tem 
                   //que fazer algumas buscas nas listas

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
        System.out.println("===== MENU =====");
        System.out.println("FILMES");
        System.out.println("1. Adicionar filme na lista"); // OK
        System.out.println("2. Mostrar filmes na lista de filmes"); // fazer caso esteja vazia
        System.out.println("3. Mostrar filmes favoritos"); // OK
        System.out.println("4. Adicionar filme aos favoritos (em construcao)\n"); // em andamento... (tirar opcao de colocar aos favs de adicionar e se o filme estiver repetido nos favs)
        System.out.println("LIVROS");
        System.out.println("5. Adicionar livro na lista"); // OK
        System.out.println("6. Mostrar livros na lista de livros"); // fazer caso esteja vazia
        System.out.println("7. Mostrar livros favoritos"); // OK
        System.out.println("8. Adicionar livro aos favoritos (em construcao)\n"); // em andamento... (tirar opcao de colocar aos favs de adicionar e se o livro estiver repetido nos favs)
        System.out.println("0. Sair");
        System.out.println("================");
    }
}
