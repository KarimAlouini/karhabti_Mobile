/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.controllers;

import com.codename1.entities.Client;
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
public class ClientService {
    List<Client> listClients = new ArrayList();
    Client cl = new Client();

    

    public Client findClientById(Integer id) {

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/KarhabtyService/Client/SelectClientById.php?id=" + id + "");
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {

                cl = getOneClient(new String(con.getResponseData()));
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(con);
        return cl;
    }

    

    

    public Client getOneClient(String json) {
        Client cli = new Client();
        try {

            JSONParser j = new JSONParser();
            Map<String, Object> clients = j.parseJSON(new CharArrayReader(json.toCharArray()));
            Map<String, Object> obj = (Map<String, Object>) clients.get("client");

            cli.setId(Integer.parseInt(obj.get("id").toString()));
            cli.setNom(obj.get("nom").toString());

        } catch (IOException ex) {
        }

        return cli;

    }
    
    public List<Client> getAll() {

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/KarhabtyService/Client/SelectClient.php");
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                try{
                listClients = getListClient(new String(con.getResponseData()));
                }catch(Exception e){
                    cl = getOneClient(new String(con.getResponseData()));
                    listClients.add(cl);
                }
            }

        });

        NetworkManager.getInstance().addToQueueAndWait(con);
        return listClients;

    }
    
    public ArrayList<Client> getListClient(String json) {
        ArrayList<Client> listClient = new ArrayList<Client>();
        try {

            JSONParser j = new JSONParser();
            Map<String, Object> clients = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) clients.get("client");

            for (Map<String, Object> obj : list) {
                Client m = new Client();
                m.setId(Integer.parseInt(obj.get("id").toString()));
                m.setNom(obj.get("nom").toString());

                listClient.add(m);

            }

        } catch (IOException ex) {
        }

        return listClient;

    }
    
}
