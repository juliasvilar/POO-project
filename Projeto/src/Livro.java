import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Livro {    
    
    List<Livro> listaDeLivros = new ArrayList<>();
    
    private String nome;
    private double nota;

    public void exibeFichaTecnica() {
        System.out.println("Nome do livro: " + nome);
        System.out.println("Nota do livro: " + nota);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    public List<Livro> getLivros() {
        return listaDeLivros;
    }
    
    public static void adicionarLivro(Scanner scanner, List<Livro> ListaDeLivros, Favoritos favoritos){
        scanner.nextLine(); 
        Livro livro = new Livro();
        System.out.print("Digite o nome do livro: ");
        String nomeLivro = scanner.nextLine();

        boolean livroExistente = false;
        for (Livro f : ListaDeLivros) {
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
            while ( notaLivro > 10 || notaLivro < 0){
                System.out.println("A nota deve estar entre 0-10. Tente novamente: ");
                notaLivro = scanner.nextDouble();
            }
            livro.setNota(notaLivro);

            ListaDeLivros.add(livro);
            System.out.println("Deseja adicionar livro na lista de favoritos? ");
            System.out.println("1 - SIM\n2 - NAO: ");
            int fav = scanner.nextInt();
            while(fav != 1 && fav != 2){
                System.out.println("Resposta inválida!\n");
            }
            if(fav == 1){
                favoritos.adicionarLivro(livro);
                System.out.println("Livro adicionado aos favoritos!");

            }
        }
    }
}
