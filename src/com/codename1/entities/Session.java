/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.entities;

/**
 *
 * @author ali methnani
 */
public class Session {
    
    
    private static int id;
    private static String  username;
    private static String  email;
    private static int isNew;
   
    

    private static Session ses ;
    public static int getId() {
        return id;
    }
    public static void setId(int id) {
        Session.id = id;
    }
    public static Session GetInstance(){
        return ses;
    }
     public static String getEmail() {
        return email;
    }
     public static String getusername() {
        return username;
    }
      public static void setusername(String  username) {
        Session.username = username;
    }
    public static void setEmail(String  email) {
        Session.email = email;
    }
    public static void setisNEw(int  isNew) {
        Session.isNew = isNew;
    }
     public static int getisNew() {
        return isNew;
    }
   
    
    
    public Session(){}
    
}
