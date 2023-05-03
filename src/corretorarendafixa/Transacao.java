package corretorarendafixa;

import java.util.Calendar;

public class Transacao implements Operacao {
    private int id;
    private Calendar data;
    private Conta contaRemetente;
    private Conta contaDestinatario;
    private double valor;
    private String tipo;
    private static int idAtual = 0;

    public Transacao(Calendar data, Conta contaRemetente, Conta contaDestinatario, double valor, String tipo) {
        this.id = idAtual++;
        this.data = data;
        this.contaRemetente = contaRemetente;
        this.contaDestinatario = contaDestinatario;
        this.valor = valor;
        this.tipo = tipo;
    }

    public Conta getContaDestinatario() {
        return contaDestinatario;
    }

    public void setContaDestinatario(Conta contaDestinatario) {
        this.contaDestinatario = contaDestinatario;
    }

    public Conta getContaRemetente() {
        return contaRemetente;
    }

    public void setContaRemetente(Conta contaRemetente) {
        this.contaRemetente = contaRemetente;
    }
    
    @Override
    public int getId() {
        return id;
    }

    @Override
    public Calendar getData() {
        return data;
    }

    @Override
    public double getValor() {
        return valor;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setData(Calendar data) {
        this.data = data;
    }

    @Override
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    @Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public void mostrar(){
        System.out.println("Número da operação: " + getId());
        System.out.println("Valor: " + getValor());
        System.out.println("Remetente: " + (getContaRemetente() != null ? getContaRemetente().getCliente().getNome() : "não especificado"));
        System.out.println("Destinatário: " + (getContaDestinatario() != null ? getContaDestinatario().getCliente().getNome() : "não especificado"));
        System.out.println("Tipo: " + getTipo());
        System.out.println("Data: " + getData().getTime());
    }
}
