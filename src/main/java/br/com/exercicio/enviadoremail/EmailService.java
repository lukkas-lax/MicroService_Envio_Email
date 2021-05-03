package br.com.exercicio.enviadoremail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void enviar(String nome, String emailDestinatario){

                try {
                    Email email = new SimpleEmail();
                    email.setHostName("smtp.googlemail.com");
                    email.setSmtpPort(465);
                    email.setAuthenticator(new DefaultAuthenticator("teste@gmail.com", "senha"));
                    email.setSSLOnConnect(true);

                    email.setFrom("teste@gmail.com");
                    email.setSubject("Você foi convidado pelo Lista de Convidados");
                    email.setMsg("Olá " + nome + ". Você acaba de ser convidado pelo Lista de Convidados.");
                    email.addTo(emailDestinatario);
                    email.send();

                } catch (EmailException e) {
                    e.printStackTrace();
                }

    }

}
