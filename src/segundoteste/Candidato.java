package segundoteste;

public class Candidato {
    private int id;
    private String nome;
    private String status;

    public Candidato(String nome, int id) {
        this.id = id;
        this.nome = nome;
        this.status = "Recebido";
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status){
        this.status= status;
    }

}
