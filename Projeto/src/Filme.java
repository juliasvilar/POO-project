import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Filme {
    
    List<Filme> listaDeFilmes = new ArrayList<>();
    private String nome;
    private double nota;
        

    public void exibeFichaTecnica() {
        System.out.println("Nome do filme: " + nome);
        System.out.println("Nota do filme: " + nota); 
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
    
    public List<Filme> getFilmes() {
        return listaDeFilmes;
    }
    
    public static void adicionarFilme(Scanner scanner, List<Filme> ListaDeFilmes, Favoritos favoritos){
        scanner.nextLine(); 
        Filme filme = new Filme();
        System.out.print("Digite o nome do filme: ");
        String nomeFilme = scanner.nextLine();

        boolean achou = false;
        for (Filme f : ListaDeFilmes) {
            if (f.getNome().equalsIgnoreCase(nomeFilme)) {
                achou = true;
                break;
            }
        }

        if (achou == true) {
            System.out.println("Este filme ja esta na lista!");
        } else {
            filme.setNome(nomeFilme);

            System.out.print("Digite a nota para o filme '" + filme.getNome() + "': ");
            double notaFilme = scanner.nextDouble();
            while ( notaFilme > 10 || notaFilme < 0){
                System.out.println("A nota deve estar entre 0-10. Tente novamente: ");
                notaFilme = scanner.nextDouble();
            }
            filme.setNota(notaFilme);

            ListaDeFilmes.add(filme);
            System.out.println("Deseja adicionar o filme na lista dos favoritos? ");
            System.out.println("1 - SIM\n2 - NAO: ");
            int fav = scanner.nextInt();
            while(fav != 1 && fav != 2){
                System.out.println("Resposta inválida!\n");
            }
            if(fav == 1){
                favoritos.adicionarFilme(filme);
                System.out.println("Filme adicionado aos favoritos!");

            }
        }
    }    
}
