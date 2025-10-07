package uml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Disciplina {
    private static final int MAX_PROFESSORES = 4;

    private String nome;
    private List<Professor> professores = new ArrayList<>();
    private boolean ofertada;

    public Disciplina(String nome) {
        this.nome = nome;
        this.ofertada = true; // por padrão está sendo ofertada
    }

    public void adicionarProfessor(Professor p) {
        if (professores.size() < MAX_PROFESSORES) {
            professores.add(p);
        } else {
            System.out.println("Máximo de " + MAX_PROFESSORES + " professores atingido para " + nome);
        }
    }

    public List<Professor> getProfessores() {
        return Collections.unmodifiableList(professores);
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