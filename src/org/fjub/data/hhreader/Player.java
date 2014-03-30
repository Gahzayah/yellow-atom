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
   
    String  pl_name = "";
    int     pl_seatnbr = 0;
    int     pl_stacksize =0;
    boolean pl_sittingAction = false; // true = sitting in false= sitting out

    public Player(String h) {
        super(h);
    }
    
            
    
    
}
