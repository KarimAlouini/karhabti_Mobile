/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.views;

import com.codename1.components.SpanLabel;
import com.codename1.controllers.OffreController;
import com.codename1.controllers.PackController;
import com.codename1.entities.Offre;
import com.codename1.entities.Pack;
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
public class AfficherPack extends BaseForm {

    public AfficherPack(Resources res) {
       
         super("Gestion des Packs", BoxLayout.y());
        
         Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        //setTitle("Gestion de cours");
        getContentPane().setScrollVisible(false);
        
//        super.addSideMenu(res);
//        tb.addSearchCommand(e -> {});
        
        PackController pack = new PackController();
        Container ctn = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        add(ctn);
       
          Image img = res.getImage("profile-background.jpg");
          img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 2);

         ctn.add(img);
        ConnectionRequest con = new ConnectionRequest();
//        
        Form f = new Form(" Liste des Packs");
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
 
           con.setUrl("http://localhost/karhabti/islem/seleect.php");
         
         con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
               System.out.println(getListPack(new String(con.getResponseData())));

                ArrayList<Pack> listPack;

              listPack= getListPack(new String(con.getResponseData()));

                for (int i = 0; i < listPack.size(); i++) {
                    ctn.add(Createcontainer(listPack.get(i), pack, res));
                }

                f.refreshTheme();
               
            }
        
         
        public ArrayList<Pack> getListPack(String json) {
        ArrayList<Pack> listpacks = new ArrayList<>();
       

        try {

            JSONParser j = new JSONParser();

            Map<String, Object> packs = j.parseJSON(new CharArrayReader(json.toCharArray()));

            System.out.println();
            List<Map<String, Object>> list = (List<Map<String, Object>>) packs.get("pack");

            for (Map<String, Object> obj : list) {
                
                Pack p = new Pack();
                 
                p.setNom(obj.get("nom").toString());
                p.setNbr_heure_code(Integer.parseInt(obj.get("nbr_heure_code").toString()));
                p.setNbr_heure_conduite(Integer.parseInt(obj.get("nbr_heure_conduite").toString()));
                p.setPrix_ucode(Integer.parseInt(obj.get("prix_ucode").toString()));
                p.setPrix_uconduite(Integer.parseInt(obj.get("prix_uconduite").toString()));
                p.setPromotion(Integer.parseInt(obj.get("promotion").toString()));
                p.setDescription(obj.get("description").toString());
                listpacks.add(p);

            }

        } catch (IOException ex) {
         }
        return listpacks;
         
    }
 

      public Container Createcontainer(Pack p,PackController offre, Resources res)
            
    {                   
                       Label nom = new Label(p.getNom());
                       Label nbrc = new Label("nbr_heure_code: "+p.getNbr_heure_code());
                       Label nbrcon = new Label("nbr_heure_conduite: "+p.getNbr_heure_conduite());
                       Label prixc = new Label("prix unitaire code: "+p.getPrix_ucode());
                       Label prixcon = new Label("prix unitaire conduite: "+p.getPrix_uconduite());
                       Label promotion = new Label("Promotion %: "+p.getPromotion());
                       Label description = new Label(p.getDescription());
                       Button btnajout=new Button("ajouter");
                       Button btnsupp= new Button("supprimer");
                       Button btnpartage = new Button("partager");
                     
               Label l = new Label("______________________________________________________");
               Container  ctn=new Container(new BoxLayout(BoxLayout.Y_AXIS));
               ctn.add(nom);
               ctn.add(nbrc);
               ctn.add(nbrcon);
               ctn.add(prixc);
               ctn.add(prixcon);
               ctn.add(promotion);
               ctn.add(description);
               ctn.add(btnajout);
               ctn.add(btnpartage);
               ctn.add(btnsupp);
               ctn.add(l);
     
            
              
                btnsupp.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
         
           offre.deletepack(p);
           new AfficherCours(res).show();
           ctn.refreshTheme();
                    }
                });
      btnpartage.addActionListener(new ActionListener() {

                         @Override
                         public void actionPerformed(ActionEvent evt) {
                             String accessToken = "EAACEdEose0cBAPTl4WUATg5FQv5nX9VfibWdnO9ZAHIECR5TEMhPEZB4G9PW6zevu0h0wo9ZBM998kNaIYmOeuD7Q5g3AAGazFtZAwD2rqBkrMrJhYv9aqGFZCnIoPIUZBdX3BoHU0YYev88FMZAp0skXpv4kAPTJfpvwZAvfzhIAAqPKELPtaaaUuSimf6KHyoZD";
        
          
        FacebookClient fbClient= new DefaultFacebookClient(accessToken);
         FacebookType response = fbClient.publish("me/feed", FacebookType.class,
                           Parameter.with("message", "consulter notre site web pour un nouveau pack *** Nom de l'offre: " +p.getNom()+ " " + "prix unitaire code:" + p.getPrix_ucode()+ " prix unitaire conduite: " +p.getPrix_uconduite() + " Nombre heure code : " + p.getNbr_heure_code() + " Nombre heure conduite : " + p.getNbr_heure_conduite()+ " Promotion % : " + p.getPromotion()+ " description : " + p.getDescription()));
         System.out.println("Votre Pack à été publié");
         System.out.println("fb.com/"+response.getId()); 
                         }
                     });
  
                return ctn;
                }


          

  

         });
        
        
        NetworkManager.getInstance().addToQueue(con);
     
     
    }
    }
    
    

