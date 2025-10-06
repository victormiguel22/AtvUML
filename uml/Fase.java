package uml;
import java.util.ArrayList;
import java.util.List;

public class Fase {
    private int numero;
    private List<Disciplina> disciplinas = new ArrayList<>();

    public Fase(int numero) {
        this.numero = numero;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public int getNumero() {
        return numero;
    }
}