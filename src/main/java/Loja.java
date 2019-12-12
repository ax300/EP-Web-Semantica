import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Loja {
    String atividade;
    String nome;
    LinkedList<Produto> produtos = new LinkedList<Produto>();

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Loja (String nome, String atividade, LinkedList<Produto> produtos){
        this.nome = nome;
        this.atividade = atividade;
    }

}
