package uml;
import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private String matricula;
    private Curso curso;
    private List<Matricula> matriculas = new ArrayList<>();

    public Aluno(String nome, String matricula, Curso curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public void matricularDisciplina(Disciplina disciplina) {
        Matricula m = new Matricula(this, disciplina);
        matriculas.add(m);
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public String getNome() {
        return nome;
    }

    public Curso getCurso() {
        return curso;
    }
}