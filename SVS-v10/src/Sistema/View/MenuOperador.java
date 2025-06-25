package Sistema.View;

import javax.swing.*;

import Sistema.Controller.DeletarPaciente;
import Sistema.Controller.EditarPaciente;
import Sistema.Models.Operador;
import Sistema.Controller.RegistrarVacina;

/**
 * Classe que representa o menu principal para o usuário do tipo Operador.
 * Aqui o operador pode visualizar seus dados, registrar vacina para paciente, ou sair do menu.
 */

public class MenuOperador {

    /**
     * Método que exibe o menu e gerencia as ações do operador.
     * @param operador objeto Operador que está logado no sistema
     */

    public void menuOperador(Operador operador) {

        MenuInicial menuInicial = new MenuInicial(); // Instância do menu inicial para navegação
        int escolha; // Guarda a opção escolhida no menu

        // Array com as opções que aparecem para o operador
        String[] opcoes = {"Visualizar seus dados", "Registrar vacina em paciente",
                "Editar dados de Paciente", "Deletar Paciente", "Sair"};

        // Loop do-while para manter o menu ativo enquanto o operador estiver escolhendo opções
        do {
            escolha = JOptionPane.showOptionDialog(
                    null,                           // Componente pai (null = centralizado na tela)
                    "Qual ação você deseja realizar?", // Mensagem exibida ao operador
                    "Menu do Operador",             // Título da janela
                    JOptionPane.DEFAULT_OPTION,    // Tipo padrão de botão
                    JOptionPane.PLAIN_MESSAGE,     // Tipo de mensagem sem ícones
                    null,                         // Sem ícone personalizado
                    opcoes,                      // Array de opções para o usuário escolher
                    opcoes[0]);                  // Opção padrão selecionada (Visualizar seus dados)

            // Switch para tratar a opção escolhida pelo operador
            switch (escolha) {
                case 0:
                    // Exibe uma caixa de mensagem mostrando as informações do operador
                    JOptionPane.showMessageDialog(null, operador.mostrarInfos());
                    break;

                case 1:
                    // Cria uma instância da classe RegistrarVacina e chama o método para registrar a vacina
                    RegistrarVacina registrarVacina = new RegistrarVacina();
                    registrarVacina.registrarVacina(operador);
                    break;

                case 2:
                    // Cria uma instância da classe EditarPaciente e chama com o método;
                    EditarPaciente editarPaciente = new EditarPaciente();
                    editarPaciente.editarPaciente(operador);
                case 3:
                    // Cria uma instância da classe DeletarPaciente e chama o método para deletá-lo
                    DeletarPaciente deletarPaciente = new DeletarPaciente();
                    deletarPaciente.deletarPaciente(operador);
                    break;
                case 4:
                    // Sai do menu do operador e volta para o menu inicial
                    JOptionPane.showMessageDialog(null, "Desconectando da conta...");
                    menuInicial.telaInicial();
                    break;
            }
        } while (escolha == 0 || escolha == 1);
        // Enquanto a escolha for 0 ou 1, o menu continua aparecendo.
        // Quando o operador escolher sair (2), o loop para.
    }
}
