/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.views;

import com.codename1.controllers.CoursController;
import com.codename1.entities.Cours;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Display;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.BaseForm;

/**
 *
 * @author USER
 */
public class ModifierCours extends BaseForm  {

 public ModifierCours(Resources res, Cours c) {
      super("Liste des Cours", BoxLayout.y());
     
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        //setTitle("");
        getContentPane().setScrollVisible(false);
        
        Image img = res.getImage("profile-background.jpg");
        img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 2);
        add(img);
        
      
     TextField tftitre = new TextField("", "titre");
     TextField tfcontenue = new TextField("", "contenue");
     ComboBox ctype = new ComboBox("", "Taxis" , "Autobus" , "Poids lourds" , "Voiture");
     
      Button btnModif = new Button("Modifier");
      tftitre.setText(c.getTitre());
      tfcontenue.setText(c.getContenue());
      ctype.setSelectedItem(c.getPermis());
      
      
        add(tftitre);
        add(tfcontenue);
        add(ctype);
        add(btnModif);
        
      CoursController coursc = new CoursController();
      btnModif.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
          coursc.updateCours(tftitre,tfcontenue,ctype,c);
          System.out.println("Modification effectuées avec succés");
          new AfficherCours(res).show();
          }
      });
    }

}
