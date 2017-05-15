/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.controllers;

import com.codename1.entities.Marque;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USER
 */
public class MarqueService {
    List<Marque> listMarques = new ArrayList();
    Marque mar = new Marque();

    

    public Marque findMarById(Integer id) {

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/karhabti/karim/Marque/SelectMarqueById.php?id=" + id + "");
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {

                mar = getOneMarque(new String(con.getResponseData()));
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(con);
        return mar;
    }

    

    

    public Marque getOneMarque(String json) {
        Marque ma = new Marque();
        try {

            JSONParser j = new JSONParser();
            Map<String, Object> marques = j.parseJSON(new CharArrayReader(json.toCharArray()));
            Map<String, Object> obj = (Map<String, Object>) marques.get("marque");

            ma.setId(Integer.parseInt(obj.get("id").toString()));
            ma.setLibelle_ma(obj.get("libelle_ma").toString());

        } catch (IOException ex) {
        }

        return ma;

    }
    
    public Marque findByNom(String libelle_ma) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/karhabti/karim//Marque/SelectMarqueByNom.php?libelle_ma=" + libelle_ma + "");
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {

                mar = getOneMarque(new String(con.getResponseData()));

            }

        });

        NetworkManager.getInstance().addToQueueAndWait(con);

        return mar;
    }


    public List<Marque> getAll() {

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/KarhabtyService/Marque/SelectMarque.php");
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                try{
                listMarques = getListMarque(new String(con.getResponseData()));
                }catch(Exception e){
                    mar = getOneMarque(new String(con.getResponseData()));
                    listMarques.add(mar);
                }
            }

        });

        NetworkManager.getInstance().addToQueueAndWait(con);
        return listMarques;

    }
    
    public ArrayList<Marque> getListMarque(String json) {
        ArrayList<Marque> listMarque = new ArrayList<Marque>();
        try {

            JSONParser j = new JSONParser();
            Map<String, Object> marques = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) marques.get("marque");

            for (Map<String, Object> obj : list) {
                Marque m = new Marque();
                m.setId(Integer.parseInt(obj.get("id").toString()));
                m.setLibelle_ma(obj.get("libelle_ma").toString());

                listMarque.add(m);

            }

        } catch (IOException ex) {
        }

        return listMarque;

    }
    
}
