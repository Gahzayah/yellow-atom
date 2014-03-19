/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fjub.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author MaHi
 */
public class Hand {

    String[] handhistory;
    int countHands;
    File inputfile;
    BufferedReader reader;
    String filename = "HH20140319 1 Chip - Table 3.txt";
    String pathToHistory = "C:/Users/Fjubuu/Desktop/swc_client-Windows v0.2.18/handhistories/";

    /**
     * Construktor
     */
    public Hand() {
        this.handhistory = new String[150];
        this.countHands = 0;
    }
    /**
     * 
     * @return Array full of Handhistorys
     */
    public String[] getHandhistory() {
        return handhistory;
    }
    /**
     * Liest die Handhistory aus pathToHistory+filename in die handhistory[] ein
     */
    public void setHandhistory() {
       String temp = "";
       int row = 0;
        try {
            inputfile = new File(pathToHistory+filename);
            reader = new BufferedReader(new FileReader(inputfile));
            String line = "";
            
            while ((line = reader.readLine()) != null) {
                if(line.contains("Hand #") && row !=0){
                   countHands=countHands+1;
                   handhistory[countHands]=temp;
                   temp="";                   
                }
                
                if(!line.isEmpty()){ 
                  temp = temp + line + "\r\n";
                  row = row + 1;
                }
            }
            
            reader.close();

        } catch (IOException e) {
            System.out.println("Fehler" + e);
        }
    }
    /**
     * 
     * @return Abzahl Hände eingelesen
     */
    public int getCountHands() {
        return countHands;
    }

    
    

}
