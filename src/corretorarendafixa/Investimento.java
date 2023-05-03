package corretorarendafixa;

public class Investimento {
    private String tipo;
    private double valorInvestido;
    private double taxaDeRendimento;
    private int orgaoEmissor;

    public Investimento(String tipo, double valorInvestido, double taxaDeRendimento, int orgaoEmissor) {
        this.tipo = tipo;
        this.valorInvestido = valorInvestido;
        this.taxaDeRendimento = taxaDeRendimento;
        this.orgaoEmissor = orgaoEmissor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public double getTaxaDeRendimento() {
        return taxaDeRendimento;
    }

    public void setTaxaDeRendimento(double taxaDeRendimento) {
        this.taxaDeRendimento = taxaDeRendimento;
    }

    public int getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(int orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public double getValorAtual() {
        double rendimento = valorInvestido * taxaDeRendimento;
        return valorInvestido += rendimento;
    }
    public void mostrar() {
        System.out.println("Tipo de investimento: " + tipo);
        System.out.println("Valor investido: " + valorInvestido);
        System.out.println("Taxa de rendimento: " + taxaDeRendimento);
        System.out.println("Órgão emissor: " + orgaoEmissor);
        System.out.println("Valor atual: " + getValorAtual());
    }

}
