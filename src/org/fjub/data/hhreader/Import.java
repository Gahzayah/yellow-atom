/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fjub.data.hhreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.fjub.data.dbhandler.dbhandler;

/**
 *
 * @author MaHi
 */
public class Import {

    String[] handhistory;
    List<Hand> handhistoryOB = null;            // Zwischenablage der importierten Hände
    Hand hand = null;
    int countHands;
    File inputfile;
    BufferedReader reader;
    String filename = "HH20140319 1 Chip - Table 3.txt";
    String pathToHistory = "C:/Users/Fjubuu/Desktop/swc_client-Windows v0.2.18/handhistories/";
    // Database 

    /**
     * Construktor
     */
    public Import() {
        this.handhistory = new String[150];
        this.countHands = 0;
        this.handhistoryOB = new ArrayList<>();
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
        String temp = "";   // Zusammengesetzer String
        String line = "";   // Inhalt-Linie
        int row = 0;        // Zeile-Nummer
        
        try {
            // File Einlesen
            inputfile = new File(pathToHistory + filename);
            reader = new BufferedReader(new FileReader(inputfile));

            while ((line = reader.readLine()) != null) {
                // Wenn Hand# gefunden einmal in HH abspeichern
                if (line.contains("Hand #") && row != 0) {
                    countHands += 1;
                    // Test: Integrate Hand Class
                    hand = new Hand(temp);
                    handhistoryOB.add(hand);


                    

                    //handhistory[countHands] = temp;
                    temp = "";
                    row = 0;
                }
                // Solange keine Leerzeilen String erweitern mit Zeilenumbruch
                if (!line.isEmpty()) {
                    if (row == 0) {
                        temp = temp + line;
                        row += 1;
                    } else {
                        temp = temp + "\r\n" + line;
                        row += 1;
                    }
                } else {
                    // LeerZeile zwischen den Händen
                }
            }
                    handhistoryOB.get(30).init1();
                    handhistoryOB.get(30).init2();
                    handhistoryOB.get(30).init3();
                    handhistoryOB.get(30).init4();
                    handhistoryOB.get(30).init5();
                    handhistoryOB.get(30).init6();
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

    public List getHandhistoryOB() {
        return handhistoryOB;
    }
    
    

}
