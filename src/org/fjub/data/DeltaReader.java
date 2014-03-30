package org.fjub.data;

import org.fjub.data.hhreader.Import;

public class DeltaReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        view con = new view();
        con.setVisible(false);
               
        Import h = new Import();
        
        h.setHandhistory();
        System.out.println(h.getCountHands()+ "......Hände eingelesen");
        System.out.println("Hand 1-----------EXAMPLE-----------");
        //System.out.println(h.getHandhistory()[1]);
        

    
    }
    
}
