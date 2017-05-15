/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.views;

import com.codename1.entities.Agence;
import com.codename1.entities.Cours;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.BaseForm;

/**
 *
 * @author USER
 */
public class ModifierAgence  extends BaseForm{

    public ModifierAgence(Resources res, Agence a) {
        super("Modifier Agence", BoxLayout.y());
          Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        //setTitle("Newsfeed");
       
       
        getContentPane().setScrollVisible(false);
        
    }
    
     
}
