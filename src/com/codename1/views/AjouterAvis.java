/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.views;

import com.codename1.controllers.AgenceController;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.BaseForm;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author USER
 */
public class AjouterAvis extends BaseForm{

    public AjouterAvis(Resources res) {
        super("Insert", BoxLayout.y());
        
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        //setTitle("Newsfeed");
       
       
        getContentPane().setScrollVisible(false);
        
        
        int choix;
        CheckBox mauvaise;
        CheckBox Bien;
        CheckBox tres;
        CheckBox parfaite ;
   
        TextField tfNomAgence = new TextField("", "nom_agence");
        TextField tfCment = new TextField("", "comment");
        TextField tfNom = new TextField("", "nom");
        TextField tfMail = new TextField("", "mail");
        CheckBox m = new CheckBox ("Mauvaise");
        CheckBox b = new CheckBox ("Bien");
        CheckBox t = new CheckBox ("Tres bien");
        CheckBox p = new CheckBox ("Parfaite");
            
       add(tfNom);
       add(tfMail);
       add(tfNomAgence);
       add(m);
       add(b);
       add(t);
       add(p);
       add(tfCment);
       
        Button btnAjouter = new Button("Ajouter");
        add(btnAjouter);
         btnAjouter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
 Integer nbpoints= 0;
                 if (m.isSelected()){
        }
       else if (b.isSelected()){
           nbpoints+=5;
           }
       else if (t.isSelected()){
        nbpoints+=10;
      }
       else if (p.isSelected()){
            
          nbpoints+=15;
     
        }
    int choix=nbpoints;
                ConnectionRequest req = new ConnectionRequest();
                
                req.setUrl("http://localhost/code/ajouter_avis.php?mail=" + tfMail.getText() + "&nom=" + tfNom.getText()+ "&nom_agence=" + tfNomAgence.getText()+"&comment=" + tfCment.getText()+ "&choix_avis=" +choix+"");
                

                req.addResponseListener(new ActionListener<NetworkEvent>() {
                        @Override
            public void actionPerformed(NetworkEvent evt) {
          byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);

                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "ajout ok", "Ok", null);
                            
                            Twilio.init("AC920c167d8df001c31579a18cc8183eac", "5cd7f339daeaa7da59557099a69972dd");
                                com.twilio.rest.api.v2010.account.Message message = com.twilio.rest.api.v2010.account.Message.creator(new PhoneNumber("+21625062772"),
                                        new PhoneNumber("+18283574327"),
                                        "Merci pour votre Vote.")
                                        .create();
                                Dialog.show("Confirmation", "Message à été envoyer avec succées ,"
                                       + " merci votre VOTE", "Ok", null);
                            
                            
                        }
                       new AfficherAvis(res, s).show();
                     
                
            }
         
               
                   
                });
                
                NetworkManager.getInstance().addToQueue(req);
             }
        });
          
    }
 
     public void localNotificationReceived(String notificationId) {
        System.out.println("Received local notification "+notificationId);
    }
    
   
    
}
