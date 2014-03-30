/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fjub.data.hhreader;

public class Hand {
    final int MAX_SEATS = 10;
    String pokerroom = "";
    String tablename = "";
    String hand[] = null;
    String hand_ID = "";
    String hand_DateTime = "";
    String hand_Game = "";
    String hand_StakeMin = "";
    String hand_StakeMax = "";
    String hand_BuyIn = "";
    String hand_Fee = "";
    String hand_smallBlind;
    String hand_bigBlind;
    String hand_Tablename = "";
    Player player[] = null;
    int hand_number = 0;
    int hand_seatMax = 0;
    private int numberofSeats;

    public Hand(String h) {
        this.hand = h.split("\\r?\\n");
    }

    private boolean checkHand() {
        boolean check = true;

        // Check Line 1 Hand&nbsp#
        // Check HandID Starts Number at 7 and Ends Charnummber 17/18/19
        if (!isInteger(hand[0].substring(7))) {
            check = false;
        }
        // Check DateTime Format

        return false;
    }

    public void init1() {
        // Line 1 - Example Hand #20742523-2 - 2014-03-18 20:45:45

        int counter = 0;
        int EndofHandID = 0;
        int StartOfHandNbr = 0;
        String ISO_8601 = "";
        String Time = "";

        for (int i = 0; i < hand[0].length(); i++) {
            // Line 1
            if (hand[0].charAt(i) == ' ') {
                counter++;          // Begins with 1
                switch (counter) {
                    case 1:
                    case 2:
                        EndofHandID = i;
                    case 3:
                        ISO_8601 = hand[0].substring(i + 1, i + 11);
                    case 4:
                        Time = hand[0].substring(i + 1, i + 9);
                    default:
                }
            }
            if (hand[0].charAt(i) == '-') {
                if (counter < 2) {
                    StartOfHandNbr = i + 1;
                }
            }
        }

        hand_ID = hand[0].substring(6, EndofHandID);
        hand_number = Integer.parseInt(hand[0].substring(StartOfHandNbr, EndofHandID));
        hand_DateTime = ISO_8601 = ISO_8601 + "T" + Time;

        System.out.println("Hand: " + hand_ID);
        System.out.println("Handnummer: " +hand_number);
        System.out.println("DateTime: " +hand_DateTime);
    }

    public void init2() {
        // Line 2 Example Game: NL Hold'em (0.95+0.05) - Blinds 10/20

        boolean tourney = false;
        int counter = 0;
        int StartOfGame = 0;
        int EndOfGame = 0;
        int StartOfStackMin = 0;
        int EndOfStackMin =0;
        int StartOfBuyin = 0;
        int EndOfBuyin = 0;
        int StartOfStackMax = 0;
        int EndOfStackMax = 0;
        int StartOfFee = 0;
        int EndOfFee = 0;
        int StartOfsmallBlinds = 0;
        int EndOfsmallBlinds = 0;
        int StartOfbigBlinds = 0;
        
        for (int i = 0; i < hand[1].length(); i++) {
            // Line 1
            if (hand[1].charAt(i) == ' ') {
                counter++;          // Begins with 1
                switch (counter) {
                    case 1:             StartOfGame = i + 1;
                    case 2:             EndOfGame = i;
                    case 3:             
                    case 4:             EndOfStackMin = i; StartOfStackMax= i + 2;
                    case 5:             
                    case 6:             StartOfsmallBlinds=i+1;
                    default:
                }
            }
            if (hand[1].charAt(i) == '(') {
                    StartOfBuyin    = i + 1;
                    StartOfStackMin = i + 1;           
            }
            if (hand[1].charAt(i) == ')') {
                    EndOfFee    = i;
                    EndOfStackMax = i + 1;           
            }
            if (hand[1].charAt(i) == '+') {
                    tourney = true;
                    EndOfBuyin    = i;
                    StartOfFee    = i + 1;          
            }
            if (hand[1].charAt(i) == '/') {                   
                EndOfsmallBlinds = i;
                StartOfbigBlinds = i+1;
            }
        }

        hand_Game           = hand[1].substring(StartOfGame, EndOfGame);
        if(tourney==false){
        hand_StakeMin       = hand[1].substring(StartOfStackMin, EndOfStackMin);
        hand_StakeMax       = hand[1].substring(StartOfStackMax, EndOfStackMax);
        }
        hand_BuyIn          = hand[1].substring(StartOfBuyin, EndOfBuyin);;
        hand_Fee            = hand[1].substring(StartOfFee, EndOfFee);;
        hand_smallBlind     = hand[1].substring(StartOfsmallBlinds, EndOfsmallBlinds);
        hand_bigBlind       = hand[1].substring(StartOfbigBlinds);

        System.out.println("Game: " + hand_Game);
        System.out.println("StakeMin: " +hand_StakeMin);
        System.out.println("StakeMax: " +hand_StakeMax);
        System.out.println("BuyIn: " +hand_BuyIn);
        System.out.println("Fee: " +hand_Fee);
        System.out.println("smallBlind: " +hand_smallBlind);
        System.out.println("bigBlind: " +hand_bigBlind);
    }

    public void init3() {
         // Line 3 Example Site: Seals With Clubs
        pokerroom = hand[2].substring(6);       
        System.out.println("Seite: " + pokerroom);
        
    }

    public void init4() {
        // Line 4 Example Site: Table: 1 Chip - Table 3
        tablename = hand[3].substring(7);
        System.out.println("Tisch: " + tablename);
    }

    public void init5() {
        int seats = 0;
        for(int i = 4;i < MAX_SEATS + 4; i++){
            // Anzahl Sitze
            if(hand[i].contains("Seat")){
            seats++;
            
            }           
        }
        numberofSeats=seats;
        System.out.println("SEATS = " +seats);
       // System.out.println(hand[4]);
       // System.out.println(hand[5]);
       // System.out.println(hand[6]);
       // System.out.println(hand[7]);
        //System.out.println(hand[8]);
       // System.out.println(hand[9]);
       // System.out.println(hand[10]);
        
    }

    public void init6() {
        // System.out.println(hand[4+numberofSeats]);
    }

    public void setHand_Game(String hand_Game) {
        this.hand_Game = hand_Game;
    }

    public String getHand_StakeMin() {
        return hand_StakeMin;
    }

    public void setHand_StakeMin(String hand_StakeMin) {
        this.hand_StakeMin = hand_StakeMin;
    }

    public String getHand_StakeMax() {
        return hand_StakeMax;
    }

    public void setHand_StakeMax(String hand_StakeMax) {
        this.hand_StakeMax = hand_StakeMax;
    }


    public String getHand_Tablename() {
        return hand_Tablename;
    }

    public void setHand_Tablename(String hand_Tablename) {
        this.hand_Tablename = hand_Tablename;
    }

    public int getHand_seatMax() {
        return hand_seatMax;
    }

    public void setHand_seatMax(int hand_seatMax) {
        this.hand_seatMax = hand_seatMax;
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

}
