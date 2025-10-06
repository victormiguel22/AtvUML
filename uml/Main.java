package uml;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
    	
        // Criando curso e fases
    	
        Curso curso = new Curso("Engenharia de Software");
        Fase fase1 = new Fase(1);
        curso.adicionarFase(fase1);

        // Criando disciplinas e professores
        Disciplina prog1 = new Disciplina("Algoritmos");
        Professor prof1 = new Professor("Renatinho matador de policia");
        Professor prof2 = new Professor("Aninha viuva negra");
        prog1.adicionarProfessor(prof1);
        prog1.adicionarProfessor(prof2);

        fase1.adicionarDisciplina(prog1);

        // Criando aluno
        Aluno aluno = new Aluno("João", "2025001", curso);

        // Matriculando aluno em disciplina
        aluno.matricularDisciplina(prog1);

        // Registrando frequência
        Matricula m = aluno.getMatriculas().get(0);
        Frequencia f1 = new Frequencia(LocalDate.now(), true, prof1);
        m.registrarFrequencia(f1);

        // Definindo situação
        m.definirSituacao("Aprovado");

        // Exibindo dados
        System.out.println("Aluno: " + aluno.getNome());
        System.out.println("Curso: " + aluno.getCurso().getNome());
        System.out.println("Disciplina: " + m.getDisciplina().getNome());
        System.out.println("Situação: " + m.getSituacao());
        System.out.println("Frequência registrada por: " + f1.getProfessor().getNome());
    }
}