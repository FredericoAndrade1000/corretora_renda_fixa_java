package corretorarendafixa;

import java.util.ArrayList;
import java.util.Calendar;

public class Conta {
    private int id;
    private double saldo;
    private Cliente cliente;
    private ArrayList<Investimento> investimentos= new ArrayList<Investimento>();;
    private ArrayList<Transacao> transacoes = new ArrayList<Transacao>();
    private static int idAtual = 0;

    public Conta(double saldo, Cliente cliente) {
        this.saldo = saldo;
        this.cliente = cliente;
        this.id = idAtual++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Investimento> getInvestimentos() {
        return investimentos;
    }

    public void setInvestimentos(ArrayList<Investimento> investimentos) {
        this.investimentos = investimentos;
    }

    public static int getIdAtual() {
        return idAtual;
    }

    public static void setIdAtual(int idAtual) {
        Conta.idAtual = idAtual;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void mostrar() {
        System.out.println("Conta de " + cliente.getNome());
        System.out.println("Saldo atual: " + saldo);

        if (investimentos.isEmpty()) {
            System.out.println("Não há investimentos na conta.");
        } else {
            System.out.println("Investimentos:");
            investimentos.forEach((investimento) -> {
                investimento.mostrar();
                System.out.println("////////////////////////////////////////////");
            });
        }

        if (transacoes.isEmpty()) {
            System.out.println("Não há transações na conta.");
        } else {
            System.out.println("Histórico de transações:");
            transacoes.forEach((transacao) -> {
                transacao.mostrar();
                System.out.println("////////////////////////////////////////////");
            });
        }
    }

    
    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para depósito.");
            return;
        }
        
        saldo += valor;
        Calendar dataTransacao = Calendar.getInstance();
        Transacao deposito = new Transacao(dataTransacao, null, this, valor, "Depósito");
        
        transacoes.add(deposito);
        System.out.println("Depósito realizado com sucesso.");
    }

    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para saque.");
            return false;
        }
        
        if (saldo < valor) {
            System.out.println("Saldo insuficiente para realizar saque.");
            return false;
        }
        
        saldo -= valor;
        Calendar dataTransacao = Calendar.getInstance();
        Transacao saque = new Transacao(dataTransacao, this, null, valor, "Saque");
        
        transacoes.add(saque);
        System.out.println("Saque realizado com sucesso.");
        return true;
    }

    public boolean transferir(Conta contaDestino, double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para transferência.");
            return false;
        }
        
        if (saldo < valor) {
            System.out.println("Saldo insuficiente para realizar a transferência.");
            return false;
        }
        
        saldo -= valor;
        
        contaDestino.depositar(valor);

        Calendar dataTransacao = Calendar.getInstance();
        Transacao transferencia = new Transacao(dataTransacao, this, contaDestino, valor, "Transferência");

        transacoes.add(transferencia);
        System.out.println("Transferência realizada com sucesso.");
        return true;
    }
    
    
    public void adicionarInvestimento(Investimento investimento) {
        double valorInvestido = investimento.getValorInvestido();
        
        if (valorInvestido <= 0) {
            System.out.println("Valor inválido para investimento.");
            return;
        }
        
        if (valorInvestido > saldo) {
            System.out.println("Saldo insuficiente para realizar investimento.");
            return;
        }
        
        investimentos.add(investimento);
        saldo -= valorInvestido;
        Calendar dataTransacao = Calendar.getInstance();
        Transacao investimentoRealizado = new Transacao(dataTransacao, this, null, valorInvestido, "Investimento");
        transacoes.add(investimentoRealizado);
        System.out.println("Investimento realizado com sucesso.");
    }

    public void resgatarInvestimento(Investimento investimento) {
        if (!investimentos.contains(investimento)) {
            System.out.println("Investimento não encontrado.");
            return;
        }
        
        double valorResgate = investimento.getValorAtual();
        saldo += valorResgate;
        investimentos.remove(investimento);
        Calendar dataTransacao = Calendar.getInstance();
        Transacao resgateRealizado = new Transacao(dataTransacao, this, null, valorResgate, "Resgate de Investimento");
        transacoes.add(resgateRealizado);
        System.out.println("Resgate realizado com sucesso.");
    }

    public ArrayList<Transacao> getTransacoes() {
        return transacoes;
    }
}
