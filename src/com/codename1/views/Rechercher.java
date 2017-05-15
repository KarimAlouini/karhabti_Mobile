/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.views;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import com.codename1.uikit.cleanmodern.BaseForm;

/**
 *
 * @author hpwala
 */
public class Rechercher extends BaseForm {
    
   
    TextField  tfNom_agence ;
 public Rechercher(Resources theme){
     
     UIBuilder ui = new UIBuilder();
     
     
     
     
    TextField tfNom_agence = new TextField("", "nom_agence");
     
    Button btnOk = new Button("Rechercher");
    add(tfNom_agence);
    add(btnOk);
     
           
     
   
      btnOk.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent evt) {
        AfficherAvis avis= new AfficherAvis(theme, tfNom_agence.getText());
        avis.show();
         }
     });
 }

    public TextField getTfNom_agence() {
        return tfNom_agence;
    }

    
}

    

