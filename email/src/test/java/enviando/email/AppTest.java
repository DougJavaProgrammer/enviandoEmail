package enviando.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {


	private String userName = "dougmoroli@gmail.com";
	private String password = "endehe76";
	
	
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
			
			System.out.println(session);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
