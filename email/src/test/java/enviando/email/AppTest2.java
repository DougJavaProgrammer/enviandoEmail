package enviando.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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

			ObjetoEnviaEmail enviaEmail = new ObjetoEnviaEmail(JOptionPane.showInputDialog("Destinatátio: "),
					JOptionPane.showInputDialog("Nome do remetente: "), JOptionPane.showInputDialog("Assunto: "),
					JOptionPane.showInputDialog("Mensagem: "));
			
			enviaEmail.enviarEmail();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha catastrófica: \n" + e.getMessage());
			e.printStackTrace();

		}
	}
}
