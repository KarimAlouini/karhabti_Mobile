/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.views;

import com.codename1.controllers.CoursController;
import com.codename1.entities.Cours;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.io.Util;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.BaseForm;
import com.codename1.uikit.cleanmodern.NewsfeedForm;
import com.codename1.uikit.cleanmodern.ProfileForm;
import com.sun.mail.smtp.SMTPTransport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author USER
 */
public class ConsulterCours extends BaseForm {

    public ConsulterCours(Resources res) {
        
      super("ConsulterCours", BoxLayout.y());
    
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
//        setTitle("ConsulterCours");
        getContentPane().setScrollVisible(false);
        
//        super.addSideMenu(res);
//        tb.addSearchCommand(e -> {});
        Image img = res.getImage("code-accelere.png");
         img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 2);
         add(img);
        
        super.addSideMenu(res);
        tb.addCommandToRightBar("Back",res.getImage("back-command.png"), new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                new NewsfeedForm(res).showBack();
            }
        });
        
        CoursController cours = new CoursController();
        Container ctn = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        add(ctn);
        ConnectionRequest con = new ConnectionRequest();
        
        
       con.setUrl("http://localhost/karhabti/select.php");
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println(getListCours(new String(con.getResponseData())));

                ArrayList<Cours> listCours;

              listCours = getListCours(new String(con.getResponseData()));

                for (int i = 0; i < listCours.size(); i++) {
                    ctn.add(Createcontainer(listCours.get(i), cours, res));
                }


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
       Label ltype=new Label(c.getPermis().toString());
       Label ldate=new Label(c.getDateajout().toString());
        
       Label l = new Label("--------------------------------------------------------------------");
     
       Button btpdf = new Button("consulter Cours");
       Button raiting = new Button("Avis");
       Button sms = new Button("Add");
       
               Container  ctn=new Container(new BoxLayout(BoxLayout.Y_AXIS));
               ctn.add(ltitre);
               ctn.add(lcontenue);
              
               ctn.add(ltype);
               ctn.add(ldate);
               ctn.add(l);
               ctn.add(raiting);
               ctn.add(btpdf);
               ctn.add(sms);
               
        sms.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent evt) {
              sendMessageCode("23448501", "un randonneur demande du secours , Latitude= ");
           }
       });

       btpdf.addActionListener(e -> {
      FileSystemStorage fs = FileSystemStorage.getInstance();
     String fileName = fs.getAppHomePath() + "chap1_demarrage.pdf";
      if(!fs.exists(fileName)) {
        Util.downloadUrlToFile("http://www.d-booker.net/GALERIE/public/cn1/extraits/_0345_cn1_chap1_demarrage.pdf", fileName, true);
    }
    Display.getInstance().execute(fileName);
       
   });   
       raiting.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent evt) {
               new Raiting(res).show();
           }
       });
  
                return ctn;
                }
         });
        NetworkManager.getInstance().addToQueue(con);
     
    }
  
    public String sendMessageCode(String to, String text) {

        String myURL = "https://rest.nexmo.com/sms/json?api_key=4286d1ed&api_secret=b79333ace690deed&to=216"
                + to + "&from=karhabty&text=" + text;

        System.out.println(myURL);
        StringBuilder sb = new StringBuilder();

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(myURL);
        Dialog.show("bonjour", "cours ajouté avec succés " 
                , "ok", null);
        NetworkManager.getInstance().addToQueue(con);

        return sb.toString();
    }
}
     
  

    

