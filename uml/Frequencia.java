package uml;

import java.time.LocalDate;

public class Frequencia {
    private LocalDate data;
    private boolean presente;
    private Professor professor; // quem registrou a presença

    public Frequencia(LocalDate data, boolean presente, Professor professor) {
        if (data.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de frequência não pode ser futura.");
        }
        this.data = data;
        this.presente = presente;
        this.professor = professor;
    }

    public LocalDate getData() {
        return data;
    }

    public boolean isPresente() {
        return presente;
    }

    public Professor getProfessor() {
        return professor;
    }
}