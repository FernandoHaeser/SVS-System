package Sistema.View;

import Sistema.Models.Paciente;

import javax.swing.*;

/**
 * Classe que representa o menu principal para o usuário do tipo Paciente.
 * Permite ao paciente visualizar seus dados, ver o histórico de vacinação ou sair.
 */

public class MenuUsuario {

    /**
     * Método que exibe o menu e gerencia as ações do paciente logado.
     * @param paciente objeto Paciente que está logado no sistema
     */

    public void menuUsuario(Paciente paciente) {

        MenuInicial menuInicial = new MenuInicial(); // Instância do menu inicial para navegação
        int escolha; // Guarda a opção escolhida no menu

        // Opções que aparecem para o paciente no menu
        String[] opcoes = {"Visualizar seus dados", "Verificar histórico de vacinação", "Sair"};

        // Loop para manter o menu ativo enquanto o paciente não escolher sair
        do {
            escolha = JOptionPane.showOptionDialog(
                    null,                           // Janela centralizada na tela
                    "Qual ação você deseja realizar?", // Mensagem da caixa de diálogo
                    "Menu do Usuário",             // Título da janela
                    JOptionPane.DEFAULT_OPTION,    // Tipo padrão de botão
                    JOptionPane.PLAIN_MESSAGE,     // Sem ícone específico
                    null,                         // Sem ícone personalizado
                    opcoes,                      // Opções disponíveis para o usuário
                    opcoes[0]);                  // Opção padrão selecionada inicialmente

            // Processa a escolha do paciente
            switch (escolha) {
                case 0:
                    // Exibe uma caixa de mensagem com as informações do paciente (nome, CPF, etc)
                    JOptionPane.showMessageDialog(null, paciente.mostrarInfos());
                    break;

                case 1:
                    // Chama método que retorna o histórico das vacinas e exibe em uma caixa de diálogo
                    String historico = paciente.exibirHistoricoVacinas();
                    JOptionPane.showMessageDialog(null, historico);
                    break;

                case 2:
                    // Sai do menu do paciente e volta para o menu inicial
                    JOptionPane.showMessageDialog(null, "Desconectando da conta...");
                    menuInicial.telaInicial();
                    break;
            }
        }
        // Enquanto o paciente escolher visualizar dados ou histórico, o menu reaparece.
        // Ao escolher sair (opção 2), o loop para.
        while (escolha == 0 || escolha == 1);
    }
}
