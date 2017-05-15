/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.views;

import com.codename1.components.SpanLabel;
import com.codename1.controllers.AgenceController;
import com.codename1.controllers.CoursController;
import com.codename1.controllers.OffreController;
import com.codename1.entities.Agence;
import com.codename1.entities.Cours;
import com.codename1.entities.Offre;
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
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.BaseForm;
import com.codename1.uikit.cleanmodern.ProfileForm;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USER
 */
public class AfficheOffre extends BaseForm {

    public AfficheOffre(Resources res) {
        super("Gestion de Offres", BoxLayout.y());
        
         Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        //setTitle("Gestion de cours");
        getContentPane().setScrollVisible(false);
        
//        super.addSideMenu(res);
//        tb.addSearchCommand(e -> {});
        
        OffreController offre = new OffreController();
        Container ctn = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        add(ctn);
       
          Image img = res.getImage("profile-background.jpg");
          img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 2);

         ctn.add(img);
        ConnectionRequest con = new ConnectionRequest();
//        
        Form f = new Form(" Liste des Offres");
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
 
           con.setUrl("http://localhost/karhabti/islem/select.php");
         
         con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
               System.out.println(getListOffre(new String(con.getResponseData())));

                ArrayList<Offre> listOffre;

              listOffre= getListOffre(new String(con.getResponseData()));

                for (int i = 0; i < listOffre.size(); i++) {
                    ctn.add(Createcontainer(listOffre.get(i), offre, res));
                }

                f.refreshTheme();
               
            }
        
         
         public ArrayList<Offre> getListOffre(String json) {
        ArrayList<Offre> listOffre = new ArrayList<>();

        try {

            JSONParser j = new JSONParser();

            Map<String, Object> e = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) e.get("offre");

            for (Map<String,Object> obj : list) {
                 Offre o = new Offre();
                 o.setNom(obj.get("nom").toString());
                 o.setPrix_ucode(Integer.parseInt(obj.get("prix_ucode").toString()));
                 o.setPrix_uconduite(Integer.parseInt(obj.get("prix_uconduite").toString()));
                 o.setDescription(obj.get("description").toString());
                 listOffre .add(o);

            }

        } catch (IOException ex) {
         }
        return  listOffre ;

    }
 

      public Container Createcontainer(Offre o,OffreController offre, Resources res)
            
    {  
              Label nom = new Label(o.getNom());
              Label description = new Label(o.getDescription());
              Label prixc = new Label("prix unitaire code "+o.getPrix_ucode());
              Label prixcon = new Label("prix unitaire conduite "+o.getPrix_uconduite());
            
              
        
      
       
              Button btnsupp = new Button("supprimer");
              Button btnpartage = new Button("partager");
               Label l = new Label("______________________________________________________");
               Container  ctn=new Container(new BoxLayout(BoxLayout.Y_AXIS));
               ctn.add(nom);
               ctn.add(description);
               ctn.add(prixc);
               ctn.add(prixcon);
               ctn.add(btnpartage);
               ctn.add(btnsupp);
               ctn.add(l);
     
            
              
                btnsupp.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
         
           offre.deletecours(o);
           new AfficherCours(res).show();
           ctn.refreshTheme();
                    }
                });
                 
                  btnpartage.addActionListener(new ActionListener() {

                         @Override
                         public void actionPerformed(ActionEvent evt) {
                             String accessToken = "EAACEdEose0cBAPJHYIVheLHD2HcqsdHXWQhXZAH2rZCod9RRtyxQtZADQAUyNnHTZBOUYBUal1UGWbujhvPEMl3xGqaZBIo0fDdXx3zanKZBJV50MA3VH5uKu2GSZCu4SPIMFVLc9kFkZBMPZBTB0xnnbWzeTPGvD3sWCla5qHIQrZARr6GrZCzGroxuSL3qZAFoNF8ZD";
        
          
        FacebookClient fbClient= new DefaultFacebookClient(accessToken);
         FacebookType response = fbClient.publish("me/feed", FacebookType.class,
                           Parameter.with("message", "consulter notre site web pour une nouvelle offre *** Nom de l'offre: " +o.getNom()+" "+"prix unitaire code:" +o.getPrix_ucode()+ "prix unitaire conduite: "+o.getPrix_uconduite()+ "description :"+o.getDescription()));
         System.out.println("Votre offre à été publiée");
         System.out.println("fb.com/"+response.getId()); 
                         }
                     });
  
                return ctn;
                }


          

  

         });
        
        
        NetworkManager.getInstance().addToQueue(con);
     
     
    }
}