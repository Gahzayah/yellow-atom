package org.fjub.data;

public class DeltaReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        view con = new view();
        con.setVisible(false);
               
        Hand h = new Hand();
        
        h.setHandhistory();
        System.out.println(h.getCountHands()+ "......Hände eingelesen");
        System.out.println("Hand 1-----------EXAMPLE-----------");
        System.out.println(h.getHandhistory()[1]);
   
        
    }
    
}
