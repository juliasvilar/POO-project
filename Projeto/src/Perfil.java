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
            String emailAntigo = email;
            System.out.println("Qual será o seu novo email? ");
            email = scanner.nextLine();
            while (emailAntigo.equals(email) || email.isEmpty()){
                System.out.println("Escolha um email diferente do atual: ");
                email = scanner.nextLine();
            }
            System.out.println("Email alterado com sucesso!\n");
        
        } else if (resposta == 2){
            String nomeAntigo = nome;
            System.out.println("Qual será o seu novo nome de usuario? ");
            nome = scanner.nextLine();
            while (nomeAntigo.equals(nome) || nome.isEmpty()){
                System.out.println("Escolha um nome de usuario diferente do atual: ");
                nome = scanner.nextLine();
            }
            System.out.println("Nome de usuario alterado com sucesso!\n");
        
        } else {
            String senhaAntiga = senha;
            System.out.println("Qual será a sua nova senha? ");
            senha = scanner.nextLine();
            while (senhaAntiga.equals(senha)|| senha.isEmpty()){
                System.out.println("Escolha uma senha diferente da atual: ");
                senha = scanner.nextLine();
            }
            System.out.println("Senha alterada com sucesso!\n");
        }        
    }
}
