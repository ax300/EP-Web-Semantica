import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Loja {
    LinkedHashMap<String, Integer> produtos = new LinkedHashMap<>();
    String atividade;

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public String getAtividade() {
        return atividade;
    }

    public LinkedHashMap getProdutos (){
        return produtos;
    }

    public void setProdutos(String produto, int valor) {
        this.produtos.put(produto,valor);
    }
}
