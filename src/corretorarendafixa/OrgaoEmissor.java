package corretorarendafixa;

public class OrgaoEmissor {
    private int id;
    private String nome;
    private String tipo;
    private String rating;
    private String cnpj;
    private static int idAtual = 0;

    public OrgaoEmissor(String nome, String tipo, String rating, String cnpj) {
        this.id = idAtual++;
        this.nome = nome;
        this.tipo = tipo;
        this.rating = rating;
        this.cnpj = cnpj;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}
