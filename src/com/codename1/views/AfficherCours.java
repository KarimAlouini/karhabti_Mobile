/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.views;

import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.controllers.CoursController;
import com.codename1.entities.Cours;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.io.Util;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.BaseForm;
import com.codename1.uikit.cleanmodern.ProfileForm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author USER
 */
public class AfficherCours  extends BaseForm {

    public AfficherCours(Resources res) {
        super("Gestion de cours", BoxLayout.y());
         Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        //setTitle("Gestion de cours");
        getContentPane().setScrollVisible(false);
        
//        super.addSideMenu(res);
//        tb.addSearchCommand(e -> {});
        
        CoursController cours = new CoursController();
        Container ctn = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        add(ctn);
       
          Image img = res.getImage("profile-background.jpg");
          img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 2);

         ctn.add(img);
        ConnectionRequest con = new ConnectionRequest();
//        
        Form f = new Form(" Liste des Cours");
        SpanLabel spl = new SpanLabel();
        f.add(spl);
        f.show();
     
        super.addSideMenu(res);
        tb.addCommandToRightBar("Back",res.getImage("back-command.png"), new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                new ProfileForm(res).showBack();
            }
        });
        
        
        con.setUrl("http://localhost/karhabti/aicha/select.php");
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println(getListCours(new String(con.getResponseData())));

                ArrayList<Cours> listCours;

              listCours = getListCours(new String(con.getResponseData()));

                for (int i = 0; i < listCours.size(); i++) {
                    ctn.add(Createcontainer(listCours.get(i), cours, res));
                }

                f.refreshTheme();
               
            }
        
            
       
     public ArrayList<Cours> getListCours(String json) {
        ArrayList<Cours> listCours = new ArrayList<>();

        try {

            JSONParser j = new JSONParser();

            Map<String, Object> e = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) e.get("cours");

            for (Map<String,Object> obj : list) {
                Cours c= new Cours();
                c.setId(Integer.parseInt(obj.get("id").toString()));
                System.out.println(c.getId());
                c.setTitre(obj.get("titre").toString());
                c.setPermis(obj.get("permis").toString());
                c.setContenue(obj.get("contenue").toString());
                c.setDateajout(obj.get("dateajout").toString());
                   System.out.println(c.getDateajout());
                 listCours .add(c);

            }

        } catch (IOException ex) {
         }
        return  listCours ;

    }
 

      public Container Createcontainer(Cours c,CoursController cours, Resources res)
            
    {  
      
       Label ltitre=new Label(c.getTitre());
       Label lcontenue=new Label(c.getContenue());
       //Label ltype=new Label(c.getPermis().toString());
       Label ldate=new Label(c.getDateajout().toString());
        
       Label l = new Label("______________________________________________________");
       Button btnmodif=new Button("modifier");
       Button btnsupp= new Button("supprimer");
               Container  ctn=new Container(new BoxLayout(BoxLayout.Y_AXIS));
               ctn.add(ltitre);
               ctn.add(lcontenue);
              // ctn.add(ltype);
               ctn.add(ldate);
               ctn.add(l);
               ctn.add(btnmodif);
               ctn.add(btnsupp);
     
            
                btnmodif.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent evt) {
           Cours c= new Cours(); 
          new ModifierCours(res,c).show();
                    }
                });
                btnsupp.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
         
           cours.deletecours(c);
           new AfficherCours(res).show();
           ctn.refreshTheme();
                    }
                });
           
  
                return ctn;
                }
         });
        
        
        NetworkManager.getInstance().addToQueue(con);
     
     
    }
    
   
        
    }
    


