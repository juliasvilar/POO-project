class Livro {
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
}