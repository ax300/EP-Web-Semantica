import java.util.LinkedList;

public class Cliente {
    String nome;
    int idade;
    int rg;
    String sexo;
    String interesse;

    public Cliente (String nome, int idade, int RG, String interesse, String sexo){
        this.nome = nome;
        this.idade = idade;
        this.interesse = interesse;
        this.rg = RG;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getInteresse() {
        return interesse;
    }

    public void setInteresse(String interesse) {
        this.interesse = interesse;
    }
}
