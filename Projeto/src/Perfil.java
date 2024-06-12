import java.util.Scanner;

class Perfil {
        
    String nome = "";
    String email = "";
    String senha = "";
    
    public void edicao(){
    
        System.out.println("O que voce deseja mudar?\n1 - Email\n2 - Nome de usuario\n3 - Senha\nEscolha: ");
        Scanner scanner = new Scanner(System.in);
        int resposta;
        
        resposta = scanner.nextInt();
        scanner.nextLine();
        
        while(resposta < 1 || resposta > 3){
            System.out.println("Escolha invalida. Tente de novo: ");
            resposta = scanner.nextInt();
            scanner.nextLine();
        }
        
        if (resposta == 1){
            String novoEmail;
            System.out.println("Qual será o seu novo email? ");
            novoEmail = scanner.nextLine();
            while (novoEmail.equals(email) || novoEmail.isEmpty()){
                System.out.println("Escolha um email diferente do atual: ");
                novoEmail = scanner.nextLine();
            }
            email = novoEmail;
            System.out.println("Email alterado com sucesso!\n");
        
        } else if (resposta == 2){
            String novoNome;
            System.out.println("Qual será o seu novo nome de usuario? ");
            novoNome = scanner.nextLine();
            while (novoNome.equals(nome) || novoNome.isEmpty()){
                System.out.println("Escolha um nome de usuario diferente do atual: ");
                novoNome = scanner.nextLine();
            }
            nome = novoNome;
            System.out.println("Nome de usuario alterado com sucesso!\n");
        
        } else {
            String novaSenha;
            System.out.println("Qual será a sua nova senha? ");
            novaSenha = scanner.nextLine();
            while (novaSenha.equals(senha)|| novaSenha.isEmpty()){
                System.out.println("Escolha uma senha diferente da atual: ");
                senha = scanner.nextLine();
            }
            senha = novaSenha;
            System.out.println("Senha alterada com sucesso!\n");
        }        
    }
}
