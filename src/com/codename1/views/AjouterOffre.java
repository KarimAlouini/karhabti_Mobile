/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.views;

import com.codename1.controllers.CoursController;
import com.codename1.controllers.OffreController;
import com.codename1.ui.Button;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.BaseForm;

/**
 *
 * @author USER
 */
public class AjouterOffre  extends BaseForm {

    public AjouterOffre(Resources res) {
        super("Insert", BoxLayout.y());
          Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        //setTitle("Newsfeed");
       
       
        getContentPane().setScrollVisible(false);
        
        TextField tfnom = new TextField("", "Nom");
        TextField tfpcode = new TextField("", "Prix unitaire code");
        TextField tfpconduite = new TextField("", "Prix unitaire code");
        TextField tfdes = new TextField("", "Description");
        
        add(tfnom);
        add(tfpcode);
        add(tfpconduite);
        add(tfdes);
        
        Button btnAjouter = new Button("Ajouter");
         add(btnAjouter);
        OffreController coursc = new OffreController();

        btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
         coursc.insertOffre(tfnom,tfpcode,tfpconduite,tfdes,res);
                new AfficheOffre(res);            }
            
        });
        
    }
    
    
}
