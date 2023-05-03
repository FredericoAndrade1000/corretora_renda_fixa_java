package corretorarendafixa;

public class CorretoraRendaFixa {

    public static void main(String[] args) {

        // Criando um cliente
        Cliente cliente1 = new Cliente("João Silva", "111.222.333-44", "Rua A, 123", "1111-2222", null);

        // Criando uma conta para o cliente
        Conta conta1 = new Conta(1000, cliente1);
        cliente1.setConta(conta1);

        // Realizando um depósito na conta
        conta1.depositar(500);

        // Realizando um saque na conta
        conta1.sacar(200);

        // Criando um investimento
        Investimento investimento1 = new Investimento("Tesouro Direto", 1000, 0.05, 30);

        // Adicionando o investimento na conta
        conta1.adicionarInvestimento(investimento1);
        
        //Resgatando o investimento
        conta1.resgatarInvestimento(investimento1);

        // Realizando uma transferência para outra conta
        Cliente cliente2 = new Cliente("Maria Souza", "222.333.444-55", "Rua B, 456", "2222-3333", null);
        Conta conta2 = new Conta(500, cliente2);
        cliente2.setConta(conta2);

        conta1.transferir(conta2, 300);

        // Mostrando as informações das contas
        cliente1.mostrar();
        cliente2.mostrar();

    }

}

