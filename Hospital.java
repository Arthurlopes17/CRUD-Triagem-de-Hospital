package prova;

import javax.swing.*;

public class Hospital {
    public static void main(String[] args) {
        Crud sistema = new Crud();

        String[] opcoes = {"Cadastrar Paciente", "Visualizar Triagem", "Atualizar Paciente", "Remover Paciente", "Sair"};

        while (true) {
            int escolha = JOptionPane.showOptionDialog(
                    null,
                    "Escolha uma operação para gerenciar a Triagem:",
                    "Hospital - Sistema de Triagem",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
            );
            
            if (escolha == 4 || escolha == -1) {
                JOptionPane.showMessageDialog(null, "Encerrando o sistema de triagem. Até logo!");
                break;
            }

            switch (escolha) {
                case 0:
                    sistema.criar();
                    break;
                case 1:
                    sistema.ler();
                    break;
                case 2:
                    sistema.atualizar();
                    break;
                case 3:
                    sistema.deletar();
                    break;
            }
        }
    }
}
