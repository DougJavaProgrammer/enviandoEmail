package enviando.email;

import javax.swing.JOptionPane;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest2 {

	@Test // marcado como teste para poder rodar o código e efetuar teste, não sendo
			// necessário método main

	public void testeEmail() {

		try {

			ObjetoEnviaEmail enviaEmail = new ObjetoEnviaEmail(JOptionPane.showInputDialog("Digite o usuário GMAIL: "),
					JOptionPane.showInputDialog("Digite a senha do usuário: "),
					JOptionPane.showInputDialog("Destinatário: "), JOptionPane.showInputDialog("Nome do remetente: "),
					JOptionPane.showInputDialog("Assunto: "), JOptionPane.showInputDialog("Texto do email: "));

			enviaEmail.enviarEmail();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha catastrófica: \n" + e.getMessage());
			e.printStackTrace();

		}
	}
}
