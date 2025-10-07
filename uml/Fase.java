package uml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fase {
    private int numero;
    private List<Disciplina> disciplinas = new ArrayList<>();

    public Fase(int numero) {
        this.numero = numero;
        if (numero % 2 == 1) {
            // Conjunto para fases ímpares
            disciplinas.add(new Disciplina("Algoritmos"));
            disciplinas.add(new Disciplina("Matematica"));
            disciplinas.add(new Disciplina("Calculo I"));
            disciplinas.add(new Disciplina("Banco de dados I"));
            disciplinas.add(new Disciplina("Programação I"));
            disciplinas.add(new Disciplina("Estrutura de dados I"));
            disciplinas.add(new Disciplina("Desenvolvimento web I"));
            disciplinas.add(new Disciplina("Linguagens formais e autômatos"));
        } else {
            // Conjunto para fases pares
            disciplinas.add(new Disciplina("Calculo II"));
            disciplinas.add(new Disciplina("Banco de dados II"));
            disciplinas.add(new Disciplina("Programação 2"));
            disciplinas.add(new Disciplina("Estrutura de dados II"));
            disciplinas.add(new Disciplina("Desenvolvimento web II"));
            disciplinas.add(new Disciplina("Compiladores"));
        }
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