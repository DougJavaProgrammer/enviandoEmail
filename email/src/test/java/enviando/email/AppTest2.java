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

	private String userName = JOptionPane.showInputDialog("Digite o usuário do GMAIL: ");
	private String password = JOptionPane.showInputDialog("Digite a senha de " + userName);

	@Test // marcado como teste para poder rodar o código e efetuar teste, não sendo
			// necessário método main

	public void testeEmail() {

		try {
			// verificar as configurações SMTP do seu provedor e email;

			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true"); // autorização
			properties.put("mail.smtp.starttls", "true"); // autenticação
			properties.put("mail.smtp.host", "smtp.gmail.com"); // servidor Gmail Google
			properties.put("mail.smtp.port", "465"); // porta do servidor
			properties.put("mail.smtp.socketFactory.port", "465"); // especifica a porta a ser conectada pelo socket
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // classe socket de
																								// conesão ao SMTP

			Session session = Session.getDefaultInstance(properties, new Authenticator() {

				@Override
				protected PasswordAuthentication getPasswordAuthentication() {

					return new PasswordAuthentication(userName, password);
				}
			});

			Address[] toUser = InternetAddress.parse(JOptionPane.showInputDialog("Digite o destinatário: "));

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName)); // origem do email, ou seja, quem envia
			message.setRecipients(Message.RecipientType.TO, toUser); // email de destino
			message.setSubject(JOptionPane.showInputDialog("Digite o assunto: ")); // assunto do email
			message.setText(JOptionPane.showInputDialog("Digite a mensagem: "));

			Transport.send(message);
			JOptionPane.showInternalMessageDialog(null, "E-mail enviado com sucesso");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha catastrófica: \n"+ e.getMessage());
			e.printStackTrace();

		}
	}
}
