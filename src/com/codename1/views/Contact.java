/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.views;

import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import com.sun.mail.smtp.SMTPTransport;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author USER
 */
public class Contact {

    Form f;
    Image img;

    public Contact(Resources theme) {

        UIBuilder ui = new UIBuilder();
        f = new Form("Contact us", BoxLayout.y());
        TextField tfname = new TextField("", "User name");
        TextField tfmail = new TextField("", "Email");
        TextField tfmsg = new TextField("","Message");

        Button btnOk = new Button("Envoyer");

        f.add(tfname);
        f.add(tfmail);
        f.add(tfmsg);
        f.add(btnOk);
        
//        img = theme.getImage("back.png");
//                Image img1 = img.scaled(16, 16);
//                f.getToolbar().addCommandToLeftBar("", img1, (e) -> {
//            String nom="";
//                    HomeForm l1 = new HomeForm(theme, nom);
//                    l1.getF().show();
//                });

        btnOk.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
              
                Properties props = new Properties();
                props.put("mail.transport.protocol", "smtp");
                props.put("mail.smtps.host", "smtp.gmail.com");
                props.put("mail.smtps.auth", "true");
                Session session = Session.getInstance(props, null);
                
                MimeMessage msg = new MimeMessage(session);
                
                msg.setFrom(new InternetAddress("KARHABTI <my_email@myDomain.com>"));
                msg.setRecipients(javax.mail.Message.RecipientType.TO, "karhabti210@gmail.com");
                msg.setSubject("Contact");
                
                String txt = tfname.getText() +" propriétaire du mail "+tfmail.getText()
                        +" vous demande votre aide !!! "
                +"\n \n \n"+tfmsg.getText() ;
                
                msg.setText(txt);
                  System.out.println(txt);
                SMTPTransport st = (SMTPTransport)session.getTransport("smtps");
                st.connect("smtp.gmail.com","karhabti210@gmail.com","Karhabti2017");
                st.sendMessage(msg, msg.getAllRecipients());
                
                System.out.println("ServerResponse : " + st.getLastServerResponse());
            } catch (MessagingException ex) {
            }
                ToastBar.showErrorMessage("Votre reclamation a ete envoyer avec succus !!!");
            }
        });
    }

//    public TextField getTfLogin() {
//        return tfLogin;
//    }
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public void show() {

        f.show();
    }
}
