package enviando.email;

import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	
	@Test //marcado como teste para poder rodar o código e efetuar teste, não sendo necessário método main
	public void testeEmail() {
		
		//verificar as configurações SMTP do seu provedor e email;
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true"); //autorização
		properties.put("mail.smtp.starttls", "true"); //autenticação
		properties.put("mail.smtp.host", "smtp.gmail.com"); //servidor Gmail Google
		properties.put("mail.smtp.port", "465"); //porta do servidor
		properties.put("mail.smtp.socketFactory.port", "465"); //especifica a porta a ser conectada pelo socket
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //classe socket de conesão ao SMTP
		
	}
}
