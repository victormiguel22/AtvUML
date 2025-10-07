package uml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aluno {
    private String nome;
    private String matricula;
    private Curso curso;
    private List<Matricula> matriculas = new ArrayList<>();

    public Aluno(String nome, String matricula, Curso curso) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do aluno nao pode ser vazio.");
        }
        if (matricula == null || matricula.trim().isEmpty()) {
            throw new IllegalArgumentException("Matricula do aluno nao pode ser vazia.");
        }
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public void matricularDisciplina(Disciplina disciplina) {
        if (!disciplina.isOfertada()) {
            throw new IllegalArgumentException("Disciplina nao esta sendo ofertada.");
        }
        Matricula m = new Matricula(this, disciplina);
        matriculas.add(m);
    }

    public List<Matricula> getMatriculas() {
        return Collections.unmodifiableList(matriculas);
    }

    public String getNome() {
        return nome;
    }

    public Curso getCurso() {
        return curso;
    }
}