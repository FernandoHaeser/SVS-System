package Sistema.UI;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Sistema.Models.*;

public class Logins {

	public static void LoginPaciente() {

	        Paciente paciente = new Paciente(null,null,null,null);

	        JTextField cpfField = new JTextField();
	        JPasswordField senhaField = new JPasswordField();

	        JPanel panel = new JPanel();
	        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	        panel.add(new JLabel("CPF:"));
	        panel.add(cpfField);
	        panel.add(new JLabel("Senha:"));
	        panel.add(senhaField);
	        
	        int result = JOptionPane.showConfirmDialog(null, panel, "Login Usuário", JOptionPane.OK_CANCEL_OPTION);

	        paciente.setCpf(cpfField.getText());
	        String senha = new String(senhaField.getPassword());
	        paciente.setSenha(senha);
	        
	        if (result == JOptionPane.OK_OPTION) 
	        	JOptionPane.showMessageDialog(null, "Trabalhando");
	        else
	        	Login.logar();
	}
	
	public static void LoginOperador() {
		
		Operador operador = new Operador(null,null,null,null,null);
		
		JTextField idFuncionario = new JTextField();
		JPasswordField senhaField = new JPasswordField();
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("ID:"));
        panel.add(idFuncionario);
        panel.add(new JLabel("Senha:"));
        panel.add(senhaField);
        
			
		int result = JOptionPane.showConfirmDialog(null, panel, "Login Operador", JOptionPane.OK_CANCEL_OPTION);
		
		operador.setIdFuncionario(idFuncionario.getText());
		String senha = new String(senhaField.getPassword());
        operador.setSenha(senha);
        
        if (result == 0) {
        	JOptionPane.showMessageDialog(null, "Trabalhando");
        }
        else
        	Login.logar();
	}
}
