/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.io.*; 
import java.net.*; 
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diana
 */
public class Client extends Thread{
    
    public static void main(String[] args) throws Exception { 
        for (int i=0; i<20;i++){
            Thread hilo= new Client();
            hilo.start();
        }
    }

    @Override
    public void run() {
        print("");
        print("db");
        print("hello");
    }
    
    public static void print(String opcion){
        URL google=null; 
        try {
            google = new URL("https://parcialarem212.herokuapp.com/"+opcion);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(google.openStream()))) { 
                String inputLine = null; 
                while ((inputLine = reader.readLine()) != null) { 
                    System.out.println(inputLine); 
                } 
        } catch (IOException x) { 
            System.err.println(x); 
        } 
    }
}

