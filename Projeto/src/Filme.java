import java.util.ArrayList;
import java.util.List;

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
}

