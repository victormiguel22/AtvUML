package uml;

public class Professor {
    private final String nome;

    public Professor(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do professor nao pode ser vazio.");
        }
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}