/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fjub.test;


/**
 * INTERFACE 
 * --------------------------------------
 */
interface Hand <T> {
    

    String dateTime = "";
    String game = "";
    Double smallBlind = 0.0;
    Double bigBlind = 0.0;
    int handNbr = 0;
    int seatMax = 0;
    int useSeats = 0;

    public T getid();

    public T getdateTime();

    public T getgame();

    public T getsmallBlind();

    public T getbigBlind();

    public T gethandNbr();

    public T getseatMax();

    public T getuseSeats();
 
}
//---------------------------------------
/**
 * FACTORY
 * 
 */
public class handfactory {
    
    public static Hand getDog(String criteria)
  {
    if ( criteria.equals("small") )
      return new swcHand();
    else if ( criteria.equals("big") )
      return new swcHand();
    else if ( criteria.equals("working") )
      return new swcHand();

    return null;
  }
    
}

/**
 * CLASS 1 IMPLEMENTS INTERFACE
 * 
 */
class swcHand implements Hand <String>
{

    @Override
    public String getid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getdateTime() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getgame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getsmallBlind() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getbigBlind() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String gethandNbr() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getseatMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getuseSeats() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
