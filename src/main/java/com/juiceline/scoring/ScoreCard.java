/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juiceline.scoring;

import java.util.*;
import javafx.collections.ObservableList;


/**
 *
 * @author darianwelch
 */
public class ScoreCard {
    private static LinkedList<Integer> row = new LinkedList<>();
    private static GamerScore gamer;
    private static ArrayList<GamerScore> scorecard = new ArrayList<>();
    
    public static void makeRowHeader() {
        scorecard = new ArrayList<>();
        for(Integer i=1; i<=20;i++){
            row.add(i);
            System.out.println("Row Header: "+ i);
        }
        GamerScore rowHeader = new GamerScore("Name",row);
        System.out.println("rowHeader name: "+rowHeader.getName());
        for(Integer i : rowHeader.getScore())System.out.print("row numbs: "+rowHeader.getScore().get(i-1)+",");
        System.out.println("making of row header: ");
        scorecard.add(rowHeader);
        
        
    }
    
    public static void addGamer(GamerScore g){
        if(scorecard.isEmpty())makeRowHeader();
        scorecard.add(g);
    }
    
    public static GamerScore getGamer(String name){
        gamer=new GamerScore();
        boolean found = false;
        for(int i = 0; i < scorecard.size(); i++){
            if (scorecard.get(i).getName().equals(name)){
                gamer=scorecard.get(i);
                found = true;
            }
        }
        if(!found){ 
            gamer.setName("NoName");
            System.out.println("Gamer score not found in score card");
        }
        return gamer;
    }
    
    public static void addGamer(ObservableList<GamerScore> gamer) {
        
        for(GamerScore g : gamer){
            scorecard.add(g);
        }
    }
        
    public static ArrayList<GamerScore> getScoreList() {
        return scorecard;
    }
    
  
    
}
