package com.ParkHere.SendMail;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


 abstract class SendEmail {
	
	 private String Username ="parkhere73" ;
	 private String Password ="parkhere@123";
	 private String fromEmailAddress ="parkhere73@gmail.com";


	boolean start(String toEmailAddress,String subject,String textMessage) {

  // For establishment of email client with 
  // Google's gmail use below properties.
  // For TLS Connection use below properties
  // Create a Properties object 
  Properties props = new Properties();

  // these properties are required
  // providing smtp auth property to true
  props.put("mail.smtp.auth", "true");
  // providing tls enability
  props.put("mail.smtp.starttls.enable", "true");
  // providing the smtp host i.e gmail.com
  props.put("mail.smtp.host", "smtp.gmail.com");
  // providing smtp port as 587
  props.put("mail.smtp.port", "587");

  // For SSL Connection use below properties

  /*props.put("mail.smtp.host", "smtp.gmail.com");
  props.put("mail.smtp.socketFactory.port", "465");
  props.put("mail.smtp.socketFactory.class",
    "javax.net.ssl.SSLSocketFactory");
  props.put("mail.smtp.auth", "true");
  props.put("mail.smtp.port", "465");*/

  // Create Scanner object to take necessary 
  // values from the user.
  

 

  // Create a Session object based on the properties and 
  // Authenticator object
  Session session = Session.getDefaultInstance(props, 
    new LoginAuthenticator(Username,Password));

  try {

   // Create a Message object using the session created above
   Message message = new MimeMessage(session);

   // setting email address to Message from where message is being sent
   message.setFrom(new InternetAddress(fromEmailAddress));

   // setting the email address to which user wants to send message 
   message.setRecipients(Message.RecipientType.TO,
     InternetAddress.parse(toEmailAddress));

   // setting the subject for the email 
   message.setSubject(subject);

   // setting the text message which user wants to send to recipients
   message.setText(textMessage);

   // Using the Transport class send() method to send message 
   Transport.send(message);


  } catch (MessagingException e) {

   //throw new RuntimeException(e);
	  JOptionPane.showMessageDialog(new JFrame(),"Unable to send mail :\n* Check Your Internet.\n* Check Your Email Id. ", "Oops....",JOptionPane.INFORMATION_MESSAGE);
	  return false;
  }
return true;
 }

 // Creating a class for Username and Password authentication
 // provided by the user.
 class LoginAuthenticator extends Authenticator {
  PasswordAuthentication authentication = null;

  public LoginAuthenticator(String username, String password) {
   authentication = new PasswordAuthentication(username,password);
  }

  @Override
  protected PasswordAuthentication getPasswordAuthentication() {
   return authentication;
  }
 }
 
}