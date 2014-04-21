/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fjub.data.hhreader;

/**
 *
 * @author MaHi
 */
public class Player extends Hand{
   
    private String playeraction[] = null;
    private int     pl_nbrOfHands = 0;
    private String  pl_name = "";
    private int     pl_seatnbr = 0;
    private int     pl_stacksize = 0;
    private boolean pl_inDatabase = false;
    //Analyse
    private int     vpip_hands = 0;
    private int     pfr_hands = 0;
    //Values
    private int     vpip = 0;
    private int     pfr = 0;

    public Player(String h) {
        super(h);
        
    }
    public void preFlop(){
       playeraction = super.getHand();
       
       // ToDO
    
    }
    public int getVpip() {
        vpip = (100 * vpip_hands) / pl_nbrOfHands;
        return vpip;
    }

    public int getPfr() {
        pfr = (100 * pfr_hands) / pl_nbrOfHands;
        return pfr;
    }

    
    
    
            
    
    
}
