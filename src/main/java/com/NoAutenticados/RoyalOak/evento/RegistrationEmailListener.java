package com.NoAutenticados.RoyalOak.evento;

import com.NoAutenticados.RoyalOak.models.Cliente;
import com.NoAutenticados.RoyalOak.services.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
@Component
public class RegistrationEmailListener implements ApplicationListener <OnRegistrationSuccessEvent> {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private MessageSource mensaje;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void onApplicationEvent(OnRegistrationSuccessEvent event) {
        try {
            this.confirmRegistration(event);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private void confirmRegistration(OnRegistrationSuccessEvent event) throws MessagingException, UnsupportedEncodingException{

        Cliente cliente = event.getCliente();
        String tokencito = cliente.getToken();
        String emailRegistrado = cliente.getEmail();
        String emailEmisor = "noreply.royaloak@gmail.com";
        String nombreEmisor = "Royal Oak Staff";
        String asuntoEmail = "Confirmación de registro";
        String urlConfirmacionRegistro = "/registro.html?token=" + tokencito;
        String contenidoEmail = "<h2 style=\"color: black;\">\n Bienvenido <spa style=\"color: yellow;\"n>Cliente</spa>  a Royal Oak!\n </h2>\n"
                +"<p style=\"color: #333533;\">\n Gracias por registrarte en nuestra página! Para confirmar tu registro, haz click en el siguiente link:\n </p>\n"
                +"<p> <a href=\"URL\">Confirma tu registro</a> </p>"
                +nombreEmisor;
        contenidoEmail = contenidoEmail.replace("Cliente", cliente.getNombreCompleto());
        contenidoEmail = contenidoEmail.replace("URL","http://localhost:8585/web"+urlConfirmacionRegistro);
        MimeMessage mensaje = javaMailSender.createMimeMessage();
        MimeMessageHelper mensajeAyudador = new MimeMessageHelper(mensaje);
        mensajeAyudador.setFrom(emailEmisor);
        mensajeAyudador.setTo(emailRegistrado);
        mensajeAyudador.setSubject(asuntoEmail);
        mensajeAyudador.setText(contenidoEmail,true);
        javaMailSender.send(mensaje);
    }



}
