package uml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Curso {
    private String nome;
    private List<Fase> fases = new ArrayList<>();

    public Curso(String nome) {
        this.nome = nome;
        // Fase inicial adicionada no construtor
        Fase fase1 = new Fase(1);
        fases.add(fase1);
    }

    public void adicionarFase(Fase fase) {
        fases.add(fase);
    }

    public List<Fase> getFases() {
        return Collections.unmodifiableList(fases);
    }

    public String getNome() {
        return nome;
    }
}