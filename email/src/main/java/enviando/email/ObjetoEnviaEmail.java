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

public class ObjetoEnviaEmail {

	private String userName = "";
	private String password = "";
	private String listaDestinatarios = "";
	private String nomeRemetente = "";
	private String assuntoEmail = "";
	private String mensagemEmail = "";

	public ObjetoEnviaEmail(String userName, String password, String listaDestinario, String nomeRemetente,
			String assuntoEmail, String mensagemEmail) {
		this.userName = userName;
		this.password = password;
		this.listaDestinatarios = listaDestinario;
		this.nomeRemetente = nomeRemetente;
		this.assuntoEmail = assuntoEmail;
		this.mensagemEmail = mensagemEmail;
	}

	public void enviarEmail(boolean envioHtml) throws Exception {
		Properties properties = new Properties();
		properties.put("mail.smtp.ssl.trust", "*"); // autenticação SSL
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

		Address[] toUser = InternetAddress.parse(listaDestinatarios);

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName, nomeRemetente)); // origem do email, ou seja, quem
																		// envia
		message.setRecipients(Message.RecipientType.TO, toUser); // email de destino
		message.setSubject(assuntoEmail); // assunto do email
		if (envioHtml) {
			message.setContent(mensagemEmail, "text/html; charset=utf-8");
		} else {

			message.setText(mensagemEmail);
		}
		Transport.send(message);
		JOptionPane.showInternalMessageDialog(null, "E-mail enviado com sucesso");
	}

}
