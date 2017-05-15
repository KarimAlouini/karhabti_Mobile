/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.controllers;

import com.codename1.entities.Marque;
import com.codename1.entities.Type_v;
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
public class Type_vService {
    Type_v type = new Type_v();
    List<Type_v> listType_vs = new ArrayList();
    
    
    public Type_v findTypById(Integer id) {

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/KarhabtyService/Type_v/SelectTypeById.php?id=" + id + "");
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {

                type = getOneTypev(new String(con.getResponseData()));
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(con);
        return type;
    }
    
    public Type_v findByNom(String libelle_t) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/KarhabtyService/Type_v/SelectType_vByNom.php?libelle_t=" + libelle_t + "");
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {

                type = getOneTypev(new String(con.getResponseData()));

            }

        });

        NetworkManager.getInstance().addToQueueAndWait(con);

        return type;
    }

    public Type_v getOneTypev(String json) {
        Type_v tyv = new Type_v();
        try {

            JSONParser j = new JSONParser();
            Map<String, Object> typvs = j.parseJSON(new CharArrayReader(json.toCharArray()));
            Map<String, Object> obj = (Map<String, Object>) typvs.get("type_v");

            tyv.setId(Integer.parseInt(obj.get("id").toString()));
            tyv.setLibelle_t(obj.get("libelle_t").toString());

        } catch (IOException ex) {
        }

        return tyv;

    }
    public List<Type_v> getAll() {

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/KarhabtyService/Type_v/selectType_v.php");
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                try{
                listType_vs = getListType_v(new String(con.getResponseData()));
                }catch(Exception e){
                    type = getOneTypev(new String(con.getResponseData()));
                    listType_vs.add(type);
                }
            }

        });

        NetworkManager.getInstance().addToQueueAndWait(con);
        return listType_vs;

    }
    
    public ArrayList<Type_v> getListType_v(String json) {
        ArrayList<Type_v> listType_v = new ArrayList<Type_v>();
        try {

            JSONParser j = new JSONParser();
            Map<String, Object> type_vs = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) type_vs.get("type_v");

            for (Map<String, Object> obj : list) {
                Type_v tv = new Type_v();
                tv.setId(Integer.parseInt(obj.get("id").toString()));
                tv.setLibelle_t(obj.get("libelle_t").toString());

                listType_v.add(tv);

            }

        } catch (IOException ex) {
        }

        return listType_v;

    }
    
}
