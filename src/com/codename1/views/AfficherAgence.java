/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.views;

import com.codename1.components.SpanLabel;
import com.codename1.controllers.AgenceController;
import com.codename1.controllers.CoursController;
import com.codename1.entities.Agence;
import com.codename1.entities.Cours;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.Layout;
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
public class AfficherAgence  extends BaseForm {

    public AfficherAgence(Resources res) {
        super("Gestion des Agences", BoxLayout.y());
          Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        //setTitle("Gestion de cours");
        getContentPane().setScrollVisible(false);
        
//        super.addSideMenu(res);
//        tb.addSearchCommand(e -> {});
       
       AgenceController agence = new AgenceController();
        Container ctn = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        add(ctn);
       
          Image img = res.getImage("profile-background.jpg");
          img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 2);

         ctn.add(img);
        ConnectionRequest con = new ConnectionRequest();
//        
        Form f = new Form(" Liste des Agences");
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
        
         con.setUrl("http://localhost/karhabti/select_agence.php");
         
         con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println(getListAgence(new String(con.getResponseData())));

                ArrayList<Agence> listAgence;

              listAgence= getListAgence(new String(con.getResponseData()));

                for (int i = 0; i < listAgence.size(); i++) {
                    ctn.add(Createcontainer(listAgence.get(i), agence, res));
                }

                f.refreshTheme();
               
            }
        
         
                 
        public ArrayList<Agence> getListAgence(String json) {
        ArrayList<Agence> listAgence= new ArrayList<>();

        try {

            JSONParser j = new JSONParser();

            Map<String, Object> e = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) e.get("agence");

            for (Map<String,Object> obj : list) {
                Agence a= new Agence();
                a.setId(Integer.parseInt(obj.get("id").toString()));
                a.setNom(obj.get("nom").toString());
                a.setVille(obj.get("ville").toString());
                a.setAdresse(obj.get("adresse").toString());
                a.setCode_postal(Integer.parseInt(obj.get("code_postal").toString()));
                a.setTelephone(obj.get("telephone").toString());
                a.setNum_fiscal(obj.get("num_fiscal").toString());
                a.setOuverture(obj.get("Ouverture").toString());
                a.setFermeture(obj.get("Fermeture").toString());
                listAgence .add(a);

            }

        } catch (IOException ex) {
         }
        return  listAgence ;

    }
 

      public Container Createcontainer(Agence a,AgenceController agence, Resources res)
            
    {  
       
         Label lnom = new Label(a.getNom());
         Label lville = new Label(a.getVille());
         Label ladresse = new Label(a.getAdresse());
         Label lcode = new Label("code postal"+a.getCode_postal());
         Label ltel = new Label(a.getTelephone());
         Label lnum = new Label(a.getNum_fiscal());
         Label louv = new Label(a.getOuverture());
         Label lfer = new Label(a.getFermeture());
       
        
       Label l = new Label("_______________________________________________");
       Button btnmodif=new Button("modifier");
       Button btnsupp= new Button("supprimer");
       Button btnrech= new Button("rechercher");
               Container  ctn=new Container(new BoxLayout(BoxLayout.Y_AXIS));
               ctn.add(lnom);
               ctn.add(lville);
               ctn.add(ladresse);
               ctn.add(lcode);
               ctn.add(lnum);
               ctn.add(louv);
               ctn.add(lfer );
               ctn.add(btnmodif);
               ctn.add(btnsupp);
               ctn.add(btnrech);
     
            
                btnmodif.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent evt) {
           Agence a= new Agence(); 
          new ModifierAgence(res,a).show();
                    }
                });
                btnsupp.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
         
           agence.deleteAgence(a);
           new AfficherAgence(res).show();
           ctn.refreshTheme();
                    }
                });
             
           
           
  
                return ctn;
                }
         });
        
        
        NetworkManager.getInstance().addToQueue(con);
     
     
       
                }
}

    
                

