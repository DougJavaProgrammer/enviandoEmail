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

			StringBuilder stringBuilderTextoEmail = new StringBuilder();
			stringBuilderTextoEmail.append("Olá, <br/><br/>");
			stringBuilderTextoEmail.append("Você está recebendo acesso ao curso de Java <br/><br/>");
			stringBuilderTextoEmail.append("Para ter acesso, clique no link abaixo. <br/><br/>");
			stringBuilderTextoEmail.append(
					"<a target= \"_blank\" href=\"www.google.com.br\" style=\"color:#2525a7;padding: 14px 25px;"
					+ " text-align:center;text-decoration: none;display:inline-block;border-radius:30px;"
					+ " font-size:20px; font-family:courier; border:3px solid green;background-color:#99DA39;"
					+ "\">Acessar Portal </a>");

			ObjetoEnviaEmail enviaEmail = new ObjetoEnviaEmail(JOptionPane.showInputDialog("Digite o usuário GMAIL: "),
					JOptionPane.showInputDialog("Digite a senha do usuário: "),
					JOptionPane.showInputDialog("Destinatário: "), JOptionPane.showInputDialog("Nome do remetente: "),
					JOptionPane.showInputDialog("Assunto: "), stringBuilderTextoEmail.toString());

			enviaEmail.enviarEmail(true);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha catastrófica: \n" + e.getMessage());
			e.printStackTrace();

		}
	}
}
