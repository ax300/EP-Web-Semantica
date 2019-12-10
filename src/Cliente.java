import java.util.LinkedList;

public class Cliente {
    String nome;
    int idade;
    LinkedList<String> Interesses = new LinkedList<String>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public LinkedList<String> getInteresse() {
        return Interesses;
    }

    public void setInteresse(String interesse) {
        this.Interesses.add(interesse);
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }
}
