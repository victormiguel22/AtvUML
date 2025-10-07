package uml;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando curso (fases e disciplinas agora são inicializadas nos construtores)
        Curso curso = new Curso("Engenharia de Software");

        // Listas para professores e alunos
        List<Professor> professores = new ArrayList<>();
        List<Aluno> alunos = new ArrayList<>();
        // Acessando disciplinas da fase 1
        List<Disciplina> disciplinas = curso.getFases().get(0).getDisciplinas();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Cadastrar Aluno");
            System.out.println("3. Designar Professores para Disciplina");
            System.out.println("4. Matricular Aluno em Disciplina");
            System.out.println("5. Gerenciar Frequencias");
            System.out.println("6. Definir Situacao de Matricula");
            System.out.println("7. Exibir Dados");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opcao: ");
            String opStr = scanner.nextLine();
            int op;
            try {
                op = Integer.parseInt(opStr);
            } catch (NumberFormatException e) {
                System.out.println("Opcao invalida. Tente novamente.");
                continue;
            }

            if (op == 1) {
                // Cadastrar Professor
                System.out.print("Nome do professor: ");
                String nome = scanner.nextLine();
                if (nome == null || nome.trim().isEmpty()) {
                    System.out.println("Nome invalido.");
                    continue;
                }
                Professor prof = new Professor(nome);
                professores.add(prof);
                System.out.println("Professor cadastrado com sucesso.");
            } else if (op == 2) {
                // Cadastrar Aluno
                System.out.print("Nome do aluno: ");
                String nome = scanner.nextLine();
                if (nome == null || nome.trim().isEmpty()) {
                    System.out.println("Nome invalido.");
                    continue;
                }
                System.out.print("Matricula do aluno: ");
                String matricula = scanner.nextLine();
                if (matricula == null || matricula.trim().isEmpty()) {
                    System.out.println("Matricula invalida.");
                    continue;
                }
                Aluno aluno = new Aluno(nome, matricula, curso);
                alunos.add(aluno);
                System.out.println("Aluno cadastrado com sucesso.");
            } else if (op == 3) {
                // Designar Professores para Disciplina
                if (disciplinas.isEmpty()) {
                    System.out.println("Nenhuma disciplina disponivel.");
                    continue;
                }
                System.out.println("Disciplinas disponiveis:");
                for (int i = 0; i < disciplinas.size(); i++) {
                    System.out.println((i + 1) + ". " + disciplinas.get(i).getNome());
                }
                System.out.print("Escolha a disciplina (numero): ");
                String discStr = scanner.nextLine();
                int discOp;
                try {
                    discOp = Integer.parseInt(discStr) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Opcao invalida.");
                    continue;
                }
                if (discOp < 0 || discOp >= disciplinas.size()) {
                    System.out.println("Disciplina invalida.");
                    continue;
                }
                Disciplina disc = disciplinas.get(discOp);

                while (true) {
                    if (professores.isEmpty()) {
                        System.out.println("Nenhum professor cadastrado.");
                        break;
                    }
                    System.out.println("Professores disponiveis:");
                    for (int i = 0; i < professores.size(); i++) {
                        System.out.println((i + 1) + ". " + professores.get(i).getNome());
                    }
                    System.out.print("Escolha o professor para adicionar (0 para sair): ");
                    String profStr = scanner.nextLine();
                    int profOp;
                    try {
                        profOp = Integer.parseInt(profStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Opcao invalida.");
                        continue;
                    }
                    if (profOp == 0) break;
                    profOp -= 1;
                    if (profOp < 0 || profOp >= professores.size()) {
                        System.out.println("Professor invalido.");
                        continue;
                    }
                    Professor prof = professores.get(profOp);
                    disc.adicionarProfessor(prof);
                }
            } else if (op == 4) {
                // Matricular Aluno em Disciplina
                if (alunos.isEmpty()) {
                    System.out.println("Nenhum aluno cadastrado.");
                    continue;
                }
                System.out.println("Alunos disponiveis:");
                for (int i = 0; i < alunos.size(); i++) {
                    System.out.println((i + 1) + ". " + alunos.get(i).getNome());
                }
                System.out.print("Escolha o aluno (numero): ");
                String aluStr = scanner.nextLine();
                int aluOp;
                try {
                    aluOp = Integer.parseInt(aluStr) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Opcao invalida.");
                    continue;
                }
                if (aluOp < 0 || aluOp >= alunos.size()) {
                    System.out.println("Aluno invalido.");
                    continue;
                }
                Aluno aluno = alunos.get(aluOp);

                if (disciplinas.isEmpty()) {
                    System.out.println("Nenhuma disciplina disponivel.");
                    continue;
                }
                System.out.println("Disciplinas disponiveis:");
                for (int i = 0; i < disciplinas.size(); i++) {
                    System.out.println((i + 1) + ". " + disciplinas.get(i).getNome());
                }
                System.out.print("Escolha a disciplina (numero): ");
                String discStr = scanner.nextLine();
                int discOp;
                try {
                    discOp = Integer.parseInt(discStr) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Opcao invalida.");
                    continue;
                }
                if (discOp < 0 || discOp >= disciplinas.size()) {
                    System.out.println("Disciplina invalida.");
                    continue;
                }
                Disciplina disc = disciplinas.get(discOp);
                try {
                    aluno.matricularDisciplina(disc);
                    System.out.println("Aluno matriculado com sucesso.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (op == 5) {
                // Gerenciar Frequencias
                if (alunos.isEmpty()) {
                    System.out.println("Nenhum aluno cadastrado.");
                    continue;
                }
                System.out.println("Alunos disponiveis:");
                for (int i = 0; i < alunos.size(); i++) {
                    System.out.println((i + 1) + ". " + alunos.get(i).getNome());
                }
                System.out.print("Escolha o aluno (numero): ");
                String aluStr = scanner.nextLine();
                int aluOp;
                try {
                    aluOp = Integer.parseInt(aluStr) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Opcao invalida.");
                    continue;
                }
                if (aluOp < 0 || aluOp >= alunos.size()) {
                    System.out.println("Aluno invalido.");
                    continue;
                }
                Aluno aluno = alunos.get(aluOp);

                List<Matricula> mats = aluno.getMatriculas();
                if (mats.isEmpty()) {
                    System.out.println("Aluno nao esta matriculado em nenhuma disciplina.");
                    continue;
                }
                System.out.println("Disciplinas matriculadas:");
                for (int i = 0; i < mats.size(); i++) {
                    System.out.println((i + 1) + ". " + mats.get(i).getDisciplina().getNome());
                }
                System.out.print("Escolha a disciplina (numero): ");
                String matStr = scanner.nextLine();
                int matOp;
                try {
                    matOp = Integer.parseInt(matStr) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Opcao invalida.");
                    continue;
                }
                if (matOp < 0 || matOp >= mats.size()) {
                    System.out.println("Matricula invalida.");
                    continue;
                }
                Matricula matricula = mats.get(matOp);

                while (true) {
                    System.out.println("\nSubmenu Frequencias:");
                    System.out.println("1. Registrar Frequencia");
                    System.out.println("2. Exibir Frequencias");
                    System.out.println("3. Voltar");
                    System.out.print("Escolha uma opcao: ");
                    String subOpStr = scanner.nextLine();
                    int subOp;
                    try {
                        subOp = Integer.parseInt(subOpStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Opcao invalida.");
                        continue;
                    }

                    if (subOp == 1) {
                        // Registrar Frequencia
                        System.out.print("Data (yyyy-mm-dd): ");
                        String dateStr = scanner.nextLine();
                        LocalDate data;
                        try {
                            data = LocalDate.parse(dateStr);
                        } catch (Exception e) {
                            System.out.println("Data invalida.");
                            continue;
                        }
                        System.out.print("Presente (true/false): ");
                        String presStr = scanner.nextLine();
                        boolean presente = Boolean.parseBoolean(presStr);

                        List<Professor> profsDisc = matricula.getDisciplina().getProfessores();
                        if (profsDisc.isEmpty()) {
                            System.out.println("Nenhum professor designado para esta disciplina.");
                            continue;
                        }
                        System.out.println("Professores da disciplina:");
                        for (int i = 0; i < profsDisc.size(); i++) {
                            System.out.println((i + 1) + ". " + profsDisc.get(i).getNome());
                        }
                        System.out.print("Escolha o professor que esta registrando (numero): ");
                        String profStr = scanner.nextLine();
                        int profOp;
                        try {
                            profOp = Integer.parseInt(profStr) - 1;
                        } catch (NumberFormatException e) {
                            System.out.println("Opcao invalida.");
                            continue;
                        }
                        if (profOp < 0 || profOp >= profsDisc.size()) {
                            System.out.println("Professor invalido.");
                            continue;
                        }
                        Professor prof = profsDisc.get(profOp);
                        try {
                            Frequencia freq = new Frequencia(data, presente, prof);
                            matricula.registrarFrequencia(freq);
                            System.out.println("Frequencia registrada com sucesso.");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (subOp == 2) {
                        // Exibir Frequencias
                        List<Frequencia> freqs = matricula.getFrequencias();
                        if (freqs.isEmpty()) {
                            System.out.println("Nenhuma frequencia registrada.");
                        } else {
                            System.out.println("Frequencias:");
                            for (Frequencia f : freqs) {
                                System.out.println("Data: " + f.getData() + ", Presente: " + f.isPresente() + ", Registrado por: " + f.getProfessor().getNome());
                            }
                        }
                    } else if (subOp == 3) {
                        break;
                    } else {
                        System.out.println("Opcao invalida.");
                    }
                }
            } else if (op == 6) {
                // Definir Situacao de Matricula
                if (alunos.isEmpty()) {
                    System.out.println("Nenhum aluno cadastrado.");
                    continue;
                }
                System.out.println("Alunos disponiveis:");
                for (int i = 0; i < alunos.size(); i++) {
                    System.out.println((i + 1) + ". " + alunos.get(i).getNome());
                }
                System.out.print("Escolha o aluno (numero): ");
                String aluStr = scanner.nextLine();
                int aluOp;
                try {
                    aluOp = Integer.parseInt(aluStr) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Opcao invalida.");
                    continue;
                }
                if (aluOp < 0 || aluOp >= alunos.size()) {
                    System.out.println("Aluno invalido.");
                    continue;
                }
                Aluno aluno = alunos.get(aluOp);

                List<Matricula> mats = aluno.getMatriculas();
                if (mats.isEmpty()) {
                    System.out.println("Aluno nao esta matriculado em nenhuma disciplina.");
                    continue;
                }
                System.out.println("Disciplinas matriculadas:");
                for (int i = 0; i < mats.size(); i++) {
                    System.out.println((i + 1) + ". " + mats.get(i).getDisciplina().getNome());
                }
                System.out.print("Escolha a disciplina (numero): ");
                String matStr = scanner.nextLine();
                int matOp;
                try {
                    matOp = Integer.parseInt(matStr) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Opcao invalida.");
                    continue;
                }
                if (matOp < 0 || matOp >= mats.size()) {
                    System.out.println("Matricula invalida.");
                    continue;
                }
                Matricula matricula = mats.get(matOp);

                System.out.print("Nova situacao (ex: Aprovado, Reprovado, Reprovado por falta, etc.): ");
                String situacao = scanner.nextLine();
                matricula.definirSituacao(situacao);
                System.out.println("Situacao atualizada com sucesso.");
            } else if (op == 7) {
                // Exibir Dados
                if (alunos.isEmpty()) {
                    System.out.println("Nenhum aluno cadastrado.");
                    continue;
                }
                for (Aluno aluno : alunos) {
                    System.out.println("\nAluno: " + aluno.getNome());
                    System.out.println("Curso: " + aluno.getCurso().getNome());
                    for (Matricula m : aluno.getMatriculas()) {
                        System.out.println("Disciplina: " + m.getDisciplina().getNome());
                        System.out.println("Situacao: " + m.getSituacao());
                        for (Frequencia f : m.getFrequencias()) {
                            System.out.println("Frequencia em " + f.getData() + ": Presente=" + f.isPresente() + ", Registrado por: " + f.getProfessor().getNome());
                        }
                    }
                }
            } else if (op == 8) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opcao invalida. Tente novamente.");
            }
        }
        scanner.close();
    }
}