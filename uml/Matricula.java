package uml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Matricula {
    private Aluno aluno;
    private Disciplina disciplina;
    private String situacao; // aprovado, reprovado, reprovado por falta
    private List<Frequencia> frequencias = new ArrayList<>();

    public Matricula(Aluno aluno, Disciplina disciplina) {
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.situacao = "Cursando";
    }

    public void registrarFrequencia(Frequencia freq) {
        if (!disciplina.getProfessores().contains(freq.getProfessor())) {
            throw new IllegalArgumentException("O professor não está associado a esta disciplina.");
        }
        frequencias.add(freq);
    }

    public void definirSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public List<Frequencia> getFrequencias() {
        return Collections.unmodifiableList(frequencias);
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Aluno getAluno() {
        return aluno;
    }
}