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
            System.out.print("Informe a opção desejada: ");
            resposta = scanner.nextInt();

            switch (resposta) {
                case 1: 
                    scanner.nextLine(); 
                    Filme filme = new Filme();
                    System.out.print("Digite o nome do filme: ");
                    String nomeFilme = scanner.nextLine();
                    filme.setNome(nomeFilme);

                    System.out.print("Digite a nota para o filme '" + filme.getNome() + "': ");
                    double notaFilme = scanner.nextDouble();
                    filme.setNota(notaFilme);

                    listaDeFilmes.add(filme);
                    System.out.println("Deseja adicionar o filme na lista dos favoritos? ");
                    System.out.println("1 para SIM ou 2 para NÃO: ");
                    fav = scanner.nextInt();
                    while(fav != 1 && fav != 2){
                        System.out.println("Resposta inválida!\n");
                    }
                    if(fav == 1){
                        favoritos.adicionarFilme(filme);
                        System.out.println("Filme adicionado aos favoritos!");
                    
                    }
                    break;

                case 2: 
                    System.out.println("Lista de filmes:");
                    for (Filme f : listaDeFilmes) {
                        f.exibeFichaTecnica();
                    }
                    break;

                case 3: 
                    scanner.nextLine(); 
                    Livro livro = new Livro();
                    System.out.print("Digite o nome do livro: ");
                    String nomeLivro = scanner.nextLine();
                    livro.setNome(nomeLivro);

                    System.out.print("Digite a nota para o livro '" + livro.getNome() + "': ");
                    double notaLivro = scanner.nextDouble();
                    livro.setNota(notaLivro);

                    listaDeLivros.add(livro);
                    System.out.println("Deseja adicionar livro na lista de favoritos? ");
                    System.out.println("1 para SIM ou 2 para NÃO: ");
                    fav = scanner.nextInt();
                    while(fav != 1 && fav != 2){
                        System.out.println("Resposta inválida!\n");
                    }
                    if(fav == 1){
                        favoritos.adicionarLivro(livro);
                        System.out.println("Livro adicionado aos favoritos!");
                    
                    }
                    break;

                case 4:
                    System.out.println("Lista de livros:");
                    for (Livro l : listaDeLivros) {
                        l.exibeFichaTecnica();
                    }
                    break;

                case 5: //ainda vou implementar melhor para perguntar se deseja mostrar so livros
                    //favoritos.exibirFilmesFavoritos();//so filmes ou ambos, tambem implementando esse metodo
                    //favoritos.exibirLivrosFavoritos();//na propria classe de favoritos
                    favoritos.exibirLivrosEFilmesFavoritos();//essa função chama as duas acima
                    break;//implementar tambem uma condicional para caso a lista estja vazia

                /*case 6:
                    System.out.println("Deseja adicionar um filme ou um livro na lista de favoritos? ");
                    System.out.println("1- Filme\n2-Livro");
                    fav = scanner.nextInt();
                    while(fav != 1 && fav != 2){
                        System.out.println("Resposta inválida!\n");
                    }
                    if(fav == 1){//fazer opc para adicionar filmes ja assistidos nessa lista

                    }
                */ //tem que implementar verificando se ele ja esta na lista de filmes
                   //e se ele ja esta nos favoritos, depois vou parar pra fazer pq tem 
                   //que fazer algumas buscas nas listas

                case 0: 
                    System.out.println("Fechando programa...");
                    break;

                default: 
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        } while (resposta != 0);

        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("===== MENU =====");
        System.out.println("1. Adicionar filme à lista");
        System.out.println("2. Mostrar filmes na lista de filmes");
        System.out.println("3. Adicionar livro à lista");
        System.out.println("4. Mostrar livros na lista de livros");
        System.out.println("5. Mostrar favoritos");
        System.out.println("6. Adicionar filme ou livro nos favoritos");//ainda vou implementar
        System.out.println("0. Sair");
        System.out.println("================");
    }
}