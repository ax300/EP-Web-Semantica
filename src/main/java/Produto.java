public class Produto {

    String nome;
    int valor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Produto(String nome, int valor) {
        this.nome = nome;
        this.valor = valor;
    }
}
