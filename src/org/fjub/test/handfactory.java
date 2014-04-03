package org.fjub.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.fjub.data.hhreader.Hand;

public class handfactory {

    List<String> handHistory = null;            // Zwischenablage der importierten Hände
    Hand hand = null;
    int countImports;
    File inputfile;
    BufferedReader reader;
    String filename = "HH20140319 1 Chip - Table 3.txt";
    String pathToHistory = "C:/Users/Fjubuu/Desktop/swc_client-Windows v0.2.18/handhistories/";

    public handfactory() {

        this.countImports = 0;
        this.handHistory = new ArrayList<>();
    }

    public void importHandHistory() {
        String makeHandStr = null;   // Zusammengesetzer String
        String line = "";   // Inhalt-Linie
        int row = 0;        // Zeile-Nummer

        try {
            // File Einlesen
            inputfile = new File(pathToHistory + filename);
            reader = new BufferedReader(new FileReader(inputfile));
            // CHECK1 HANDHISTORY TODO
            while ((line = reader.readLine()) != null) {
                // Wenn Hand# gefunden einmal in handHistory abspeichern
                if (line.contains("Hand #") && row != 0) {
                    countImports += 1;
                    // Test: Integrate Hand Class
                    // CHECK2 HAND TODO
                    handHistory.add(makeHandStr);
                    makeHandStr = null;
                    row = 0;
                }
                // Solange keine Leerzeilen String erweitern mit Zeilenumbruch
                if (!line.isEmpty()) {
                    if (row == 0) {
                        makeHandStr = makeHandStr + line;
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

}

/**
 * CLASS 1 IMPLEMENTS INTERFACE
 *
 */
class swcHand {

}
