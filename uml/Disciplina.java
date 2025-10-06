package uml;
import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private List<Professor> professores = new ArrayList<>();
    private boolean ofertada;

    public Disciplina(String nome) {
        this.nome = nome;
        this.ofertada = true; // por padrão está sendo ofertada
    }

    public void adicionarProfessor(Professor p) {
        if (professores.size() < 4) {
            professores.add(p);
        } else {
            System.out.println("Máximo de 4 professores atingido para " + nome);
        }
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public String getNome() {
        return nome;
    }

    public boolean isOfertada() {
        return ofertada;
    }

    public void setOfertada(boolean ofertada) {
        this.ofertada = ofertada;
    }
}