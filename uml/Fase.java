package uml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fase {
    private int numero;
    private List<Disciplina> disciplinas = new ArrayList<>();

    public Fase(int numero) {
        this.numero = numero;
        // Disciplinas constantes adicionadas no construtor
        Disciplina alg = new Disciplina("Algoritmos");
        Disciplina mat = new Disciplina("Matematica");
        disciplinas.add(alg);
        disciplinas.add(mat);
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public List<Disciplina> getDisciplinas() {
        return Collections.unmodifiableList(disciplinas);
    }

    public int getNumero() {
        return numero;
    }
}