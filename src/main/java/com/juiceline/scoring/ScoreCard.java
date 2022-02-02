/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juiceline.scoring;

import java.util.*;


/**
 *
 * @author darianwelch
 */
public class ScoreCard {
    LinkedList<Integer> row = new LinkedList<>();
    
    ArrayList<GamerScore> scorecard;
    
    public ScoreCard() {
        scorecard = new ArrayList<>();
        for(int i=1; i<=20;i++){
            row.add(i);
        }
        GamerScore rowHeader = new GamerScore("Name",row);
        scorecard.add(rowHeader);
        
    }
    
    public void addGamer(GamerScore g){
        scorecard.add(g);
    }
    
    public GamerScore getGamer(String name){
        GamerScore gamer=new GamerScore();
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
        
    
}
