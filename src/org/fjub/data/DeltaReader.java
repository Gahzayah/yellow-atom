package org.fjub.data;

import org.fjub.data.hhreader.Import;

public class DeltaReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        view con = new view();
        con.setVisible(true);
               
        Import h = new Import();
        
        NewClass ts = new NewClass();
        ts.startmain();
        
        h.importHandHistory();
       //System.out.println(h.getCountHands()+ "......Hände eingelesen");
        //System.out.println(h.getHandhistory()[1]);
        

    
    }
    
}
