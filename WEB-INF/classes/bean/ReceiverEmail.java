package bean;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ReceiverEmail {
	public void approve(String email,int amount,long receiverNo)
	{
		String msg=  ( "Dear Customer,\n"+"Your account:"+receiverNo+"  is credited with amount:"+amount ) ;
		String subject="Transaction Information";
		send_mail(msg,email,subject);
	}
	public void send_mail(String msg,String email,String subject)
	{
	 
        //Get properties object    
        Properties props = new Properties();    
		  props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
		  props.put("mail.smtp.host", "smtp.gmail.com");
		  props.put("mail.smtp.port", "587");
        //get Session   
        Session s = Session.getInstance(props,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication("chinthareddysaiteja@gmail.com","nani1324");  
         }    
        });    
        //compose message    
        try {    
      	   
      	  Message message = new MimeMessage(s);
			message.setFrom(new InternetAddress("chinthareddysaiteja@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
 				InternetAddress.parse(email));
			message.setSubject(subject);
			//String msg=  ( "Dear Mail Crawler,"+ "\n\nAccount Number:"+acc_no+"\n\n Transaction Password:"+transaction_id) ;
	  				
			//msg= msg.concat(acc_no);
			message.setText(msg);

			Transport.send(message);  
	
System.out.println("sent");
		} catch (MessagingException e) {
			e.printStackTrace();
		} 

		
	}
}
