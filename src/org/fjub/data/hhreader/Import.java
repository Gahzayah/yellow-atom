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
/**
 *
 * @author MaHi
 */
public class Import {
    
    List<Hand> handHistory = null;            // Zwischenablage der importierten Hände
    Hand hand = null;
    int countImports;
    File inputfile;
    BufferedReader reader;
    String filename = "aatest6max.txt";
    String pathToHistory = "C:/Users/Fjubuu/Desktop/swc_client-Windows v0.2.18/handhistories/";

    /**
     * Construktor
     */
    public Import() {
        this.countImports = 0;
        this.handHistory = new ArrayList<>();
    }
    public List getHandhistory() {
        return handHistory;
    }

    /**
     * Liest die Handhistory aus pathToHistory+filename in die handhistory[] ein
     */
    public void importHandHistory() {
        String makeHandStr = null;   // Zusammengesetzer String
        String line = "";   // Inhalt-Linie
        int row = 0;        // Zeile-Nummer
        
        try {
            // File Einlesen
            inputfile = new File(pathToHistory + filename);
            reader = new BufferedReader(new FileReader(inputfile));
            
            while ((line = reader.readLine()) != null) {
                // Wenn Hand# gefunden einmal in handHistory abspeichern
                if (line.contains("Hand #") && row != 0) {
                    countImports +=1;
                    // Test: Integrate Hand Class
                    hand = new Hand(makeHandStr);
                    handHistory.add(hand);
                    makeHandStr = null;
                    row = 0;
                }
                // Solange keine Leerzeilen String erweitern mit Zeilenumbruch
                if (!line.isEmpty()) {
                    if (row == 0) {
                        makeHandStr = line;
                    } else {
                        makeHandStr = makeHandStr + "\r\n" + line;                     
                    }
                    row += 1;
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
        return countImports;
    }

    public List getHandhistoryOB() {
        return handHistory;
    }
    
    

}
