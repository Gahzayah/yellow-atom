/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fjub.data.hhreader;

import java.util.Arrays;
import java.util.List;

public class Hand {

    private String hand[] = null;
    // init tableinfos
    private String site = null;
    private String game = null;
    private int tableSize = 0;
    final int MAX_SEATS = 10;
    private String hand_ID = null;
    private int hand_nbr = 0;
    private String date = null;
    private String time = null;
    private int minBuyin = 0;
    private int maxBuyin = 0;

    public Hand(String h) {
        this.hand = h.split("\\r?\\n");
        formatCheck();
        initNL();
        System.out.println("Hand ID     = " + getHand_ID());
        System.out.println("Hand number = " + getHand_nbr());
        System.out.println("Date        = " + getDate());
        System.out.println("Time        = " + getTime());
        System.out.println("MaxBuyin    = " + getMaxBuyin());
        System.out.println("MinBuyin    = " + getMinBuyin());
        System.out.println("Seite       = " + getSite());
        System.out.println("Spielart    = " + getGame());
        System.out.println("Tischgröße  = " + getTableSize());

    }

    public void formatCheck() {
        boolean check = true;
        for (int v = 0; v < hand.length; v++) {
            if (!(hand[v].contains("#") && hand[v].contains("-")) && hand[v].contains("Hand")) {
                System.out.println("hh_convert_Error_item_1_line_conistenz " + hand[v]);
            }
        }
    }

    public void initNL() {
        List<String> items = Arrays.asList(hand[0].split("\\s+"));
        int start = 0;
        int end = 0;
        // Line 1 -------------------------------------------
        try {
            for (int z = 0; z < items.get(1).length(); z++) {
                if (items.get(1).charAt(z) == '#') {
                    start = z;
                }
                if (items.get(1).charAt(z) == '-') {
                    end = z;
                }
            }

            setHand_nbr(Integer.parseInt(items.get(1).substring(end + 1)));
            if (items.get(1).substring(start + 1, end).length() == 8) {
                setHand_ID(items.get(1).substring(start + 1, end));
            } else {
                throw new ErrorHRead("hh_convert_Error_item_1_HandID_length " + items.get(1).substring(start + 1, end - 1));
            }
            if (items.get(3).length() == 10) {
                setDate(items.get(3));
            } else {
                throw new ErrorHRead("hh_convert_Error_item_3_date_format" + items.get(3));
            }
            if (items.get(4).length() == 8) {
                setTime(items.get(4));
            } else {
                throw new ErrorHRead("hh_convert_Error_item_4_time_format " + items.get(4).length());
            }
        } catch (ErrorHRead err) {
            System.out.println(err.getMessage());
        }
        // Line 2 -------------------------------------------
        items = Arrays.asList(hand[1].split("\\s+"));

        try {
            // String temp = items.get(3) + items.get(5);
            if (items.get(3).contains("(") && items.get(5).contains(")")) {
                setMinBuyin(Integer.parseInt(items.get(3).replaceAll("\\W", "")));
                setMaxBuyin(Integer.parseInt(items.get(5).replaceAll("\\W", "")));
            } else {
                throw new ErrorHRead("hh_convert_Error_item_4&5_min_max_buyin ");
            }
        } catch (ErrorHRead err) {
            System.out.println(err.getMessage());
        }
        // Line 3 -------------------------------------------
        try {
            if (hand[2].contains("Seals With Clubs")) {
                setSite("Seals With Clubs");
            } else {
                throw new ErrorHRead("hh_convert_Error_item_4&5_min_max_buyin 232");
            }
        } catch (ErrorHRead err) {
            System.out.println(err.getMessage());
        }
        // Line 4 -------------------------------------------
        items = Arrays.asList(hand[3].split("\\s+"));

        try {
            switch (items.get(2)) {
                case "6max":
                    setTableSize(6);
                    break;
                case "9max":
                    setTableSize(9);
                    break;
                case "HU":
                    setTableSize(2);
                    break;
                default:
                    throw new ErrorHRead("hh_convert_Error_item_2_TableSize_");

            }
            if (items.get(1).contains("NLHE")) {
                setGame("NoLimit");
            } else {
                throw new ErrorHRead("hh_convert_Error_item_1_Game_");
            }
        } catch (ErrorHRead err) {
            System.out.println(err.getMessage());
        }

        // Line 5 -------------------------------------------
        end = 0;
        for (int i = 4; i <= MAX_SEATS + 4; i++) {
            // Anzahl Sitze
            if (hand[i].contains("Seat")) {
                end++;
                System.out.println(hand[i]);

            }
        }

        System.out.println("----------------------");

        items = null;
    }

    public String getSite() {
        return site;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public int getTableSize() {
        return tableSize;
    }

    public void setTableSize(int tableSize) {
        this.tableSize = tableSize;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getHand_ID() {
        return hand_ID;
    }

    public void setHand_ID(String hand_ID) {
        this.hand_ID = hand_ID;
    }

    public int getHand_nbr() {
        return hand_nbr;
    }

    public void setHand_nbr(int hand_nbr) {
        this.hand_nbr = hand_nbr;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getMinBuyin() {
        return minBuyin;
    }

    public void setMinBuyin(int minBuyin) {
        this.minBuyin = minBuyin;
    }

    public int getMaxBuyin() {
        return maxBuyin;
    }

    public void setMaxBuyin(int maxBuyin) {
        this.maxBuyin = maxBuyin;
    }

    public String[] getHand() {
        return hand;
    }
    
    

}
