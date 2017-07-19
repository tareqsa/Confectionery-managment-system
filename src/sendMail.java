import java.sql.SQLException;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;


	
public class sendMail 
{


	public sendMail(String email) throws SQLException 
	{
			// setting the email and the password of the sender
			final String username = "mailsender1234567@gmail.com";
			final String password = "sender1234";

			// setting properties 
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");


			// getting instance for a session after authentication
			Session session = Session.getInstance(props,new javax.mail.Authenticator()
			{
				protected PasswordAuthentication getPasswordAuthentication() 
				{
					return new PasswordAuthentication(username, password);
				}
			});

			// setting the message info and sending it 
			try 
			{

				Message message = new MimeMessage(session);

				//From
				message.setFrom(new InternetAddress("admin"));
			
				// To
				message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email));
				// subject of the message
				message.setSubject("הזמנה מוכנה");
				// Create the message part

				BodyPart messageBodyPart = new MimeBodyPart();
	             
				// Create a multi part message
				Multipart multipart = new MimeMultipart();

				// Now set the actual message
				messageBodyPart.setText("הזמנה מוכנה נא לבוא לאסוף");

				// Set text message part ---> body of the message
				multipart.addBodyPart(messageBodyPart);

				// the attachment
				messageBodyPart = new MimeBodyPart();

				// Send the complete message parts
				message.setContent(multipart);
				//sending the message
				Transport.send(message);

				// console message to approve that the process done successfully 
				JOptionPane.showMessageDialog(null, "הודעה נשלחה בהצלחה");

			}
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "שגיאה בשליחת הודעה");
			}

		
	}
}



