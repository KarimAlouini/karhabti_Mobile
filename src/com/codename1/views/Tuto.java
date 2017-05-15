/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.views;

import com.codename1.ui.BrowserComponent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.BaseForm;

/**
 *
 * @author USER
 */
public class Tuto extends BaseForm {
    
     public Tuto(Resources res) {
         BrowserComponent browser = new BrowserComponent();
                browser.setURL("http://m.youtube.com/watch?v=5yzu7qqy0zk");
                add(browser);
         
     }
    
}
