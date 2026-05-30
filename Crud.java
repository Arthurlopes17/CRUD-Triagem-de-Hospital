package prova;

import javax.swing.*;
import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Crud {
    private static final String CAMINHO_ARQUIVO = "triagem_hospital.csv";

    private String nome;
    private String cpf;
    private int idade;
    private String sintomas;
    private int prioridade;

    public void criar() {
        try {
            this.nome = JOptionPane.showInputDialog("Digite o nome do paciente: ");
            this.cpf = JOptionPane.showInputDialog("Digite o CPF do paciente: ");
            this.idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do paciente: "));
            this.sintomas = JOptionPane.showInputDialog("Digite os sintomas do paciente: ");
            this.prioridade = Integer.parseInt(JOptionPane.showInputDialog("Em uma escala de 1 a 5 qual o nível de prioridade do paciente? "));

            FileWriter fw = new FileWriter(CAMINHO_ARQUIVO, true);
            CSVWriter writer = new CSVWriter(fw);

            String[] linha = {this.nome, this.cpf, String.valueOf(this.idade), this.sintomas, String.valueOf(this.prioridade)};
            writer.writeNext(linha);

            writer.close();
            fw.close();

            JOptionPane.showMessageDialog(null, "Paciente cadastrado na triagem com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados CSV: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: Idade e Prioridade precisam ser números inteiros válidos.");
        }
    }

    public void ler() {
        try {
            FileReader fr = new FileReader(CAMINHO_ARQUIVO);
            CSVReader reader = new CSVReader(fr);
            List<String[]> todasLinhas = reader.readAll();
            reader.close();
            fr.close();

            if (todasLinhas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum paciente cadastrado na fila de triagem.");
                return;
            }

            StringBuilder relatorio = new StringBuilder("--- Fila de Triagem (Pacientes) ---\n\n");
            for (String[] linha : todasLinhas) {
                relatorio.append("Nome: ").append(linha[0]).append("\n")
                        .append("CPF: ").append(linha[1]).append("\n")
                        .append("Idade: ").append(linha[2]).append("\n")
                        .append("Sintomas: ").append(linha[3]).append("\n")
                        .append("Prioridade: ").append(linha[4]).append("\n")
                        .append("------------------------------------\n");
            }

            JOptionPane.showMessageDialog(null, relatorio.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "O arquivo de banco de dados ainda não existe ou está vazio.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler dados: " + e.getMessage());
        }
    }

    public void atualizar() {
        String cpfBusca = JOptionPane.showInputDialog("Digite o CPF do paciente que deseja atualizar os dados:");
        if (cpfBusca == null || cpfBusca.trim().isEmpty()) return;

        try {
            FileReader fr = new FileReader(CAMINHO_ARQUIVO);
            CSVReader reader = new CSVReader(fr);
            List<String[]> todasLinhas = reader.readAll();
            reader.close();
            fr.close();

            boolean encontrado = false;
            for (String[] linha : todasLinhas) {
                if (linha[1].equals(cpfBusca)) {
                    encontrado = true;
                    linha[0] = JOptionPane.showInputDialog("Novo nome (Atual: " + linha[0] + "):");
                    linha[2] = JOptionPane.showInputDialog("Nova idade (Atual: " + linha[2] + "):");
                    linha[3] = JOptionPane.showInputDialog("Novos sintomas (Atual: " + linha[3] + "):");
                    linha[4] = JOptionPane.showInputDialog("Nova prioridade [1-5] (Atual: " + linha[4] + "):");
                    break;
                }
            }

            if (encontrado) {
                FileWriter fw = new FileWriter(CAMINHO_ARQUIVO, false);
                CSVWriter writer = new CSVWriter(fw);
                writer.writeAll(todasLinhas);
                writer.close();
                fw.close();
                JOptionPane.showMessageDialog(null, "Dados do paciente atualizados com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Paciente com o CPF informado não foi encontrado.");
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar a base de dados: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    public void deletar() {
        String cpfBusca = JOptionPane.showInputDialog("Digite o CPF do paciente que receberá alta/será removido:");
        if (cpfBusca == null || cpfBusca.trim().isEmpty()) return;

        try {
            FileReader fr = new FileReader(CAMINHO_ARQUIVO);
            CSVReader reader = new CSVReader(fr);
            List<String[]> todasLinhas = reader.readAll();
            reader.close();
            fr.close();

            List<String[]> novaLista = new ArrayList<>();
            boolean encontrado = false;

            for (String[] linha : todasLinhas) {
                if (linha[1].equals(cpfBusca)) {
                    encontrado = true;
                } else {
                    novaLista.add(linha);
                }
            }

            if (encontrado) {
                FileWriter fw = new FileWriter(CAMINHO_ARQUIVO, false);
                CSVWriter writer = new CSVWriter(fw);
                writer.writeAll(novaLista);
                writer.close();
                fw.close();
                JOptionPane.showMessageDialog(null, "Paciente removido da triagem com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Paciente com o CPF informado não foi encontrado.");
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar a base de dados: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
}