package Sistema.View;

import javax.swing.JOptionPane;

/**
 * Classe MenuInicial representa o menu principal do sistema.
 * Apresenta opções para o usuário: logar, cadastrar-se ou sair.
 */

public class MenuInicial {

    /**
     * Método que exibe o menu inicial e controla o fluxo principal do sistema.
     */

    public void telaInicial() {

        // Opções principais do menu inicial exibidas ao usuário
        String[] opcoes = {"Logar", "Cadastrar-se", "Sair"};

        // Opções de confirmação para sair do sistema
        String[] opcoes2 = {"Sim", "Não"};

        // Instância dos menus de Login e Cadastro para redirecionamento
        Login menuLogin = new Login();
        Cadastro menuCadastro = new Cadastro();

        int escolha, escolha2; // Variáveis para armazenar as escolhas do usuário
        boolean continuar = false; // Controle do loop principal do menu

        // Loop principal que mantém o menu ativo até o usuário optar por sair
        while (!continuar) {

            // Exibe o menu principal usando JOptionPane com as opções "Logar", "Cadastrar-se" e "Sair"
            escolha = JOptionPane.showOptionDialog(
                    null,                       // Componente pai (null = centralizado)
                    "O que você deseja fazer?", // Mensagem exibida
                    "Menu Inicial",             // Título da janela
                    JOptionPane.YES_NO_OPTION,  // Tipo de botão (usado como padrão, mas com opções customizadas)
                    JOptionPane.PLAIN_MESSAGE,  // Tipo de mensagem (sem ícones)
                    null,                       // Sem ícone personalizado
                    opcoes,                    // Opções exibidas
                    opcoes[0]);               // Opção padrão selecionada (Logar)

            // Se o usuário fechar a janela (clicar no X), o programa é finalizado
            if (escolha == JOptionPane.CLOSED_OPTION) {
                System.exit(0);
            }

            // Switch para controlar o fluxo com base na opção escolhida
            switch (escolha) {

                case 0: // Se escolheu "Logar"
                    menuLogin.logar(); // Chama o menu de login
                    break;

                case 1: // Se escolheu "Cadastrar-se"
                    menuCadastro.cadastrar(); // Chama o menu de cadastro
                    break;

                case 2: // Se escolheu "Sair"

                    continuar = true; // Sai do loop principal para iniciar processo de saída

                    // Confirmação para o usuário confirmar se realmente deseja sair
                    escolha2 = JOptionPane.showOptionDialog(
                            null,
                            "Você está saindo do sistema, tem certeza?",
                            null,
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE,
                            null,
                            opcoes2,
                            opcoes2[0]);

                    // Se confirmar saída
                    if (escolha2 == 0) {
                        JOptionPane.showMessageDialog(null, "Saindo...", null, JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0); // Fecha o programa
                    } else {
                        continuar = false;
                        continue; // Caso escolha "Voltar", volta para o menu principal (continua o loop)
                    }
                    break;
            }
        }
    }
}
