/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juiceline.scoring;

//import java.util.*;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author darianwelch
 */
public class ScoreCard {
//    private static List<ScoreList> cellData = new ArrayList<>(); 
    private static ObservableList<GamerScore> scorecard = FXCollections.observableArrayList();
    private static ObservableList<String> names = FXCollections.observableArrayList();
    
    private static GamerScore gamer;
    
    public static void addGamerNames(ObservableList<String> namesList){
        names = namesList;
        
    }
    public static void addGamer(String name){
        String n = name;
        if(!n.isBlank()){
            if(scorecard.isEmpty())makeRowHeader();
            gamer = new GamerScore(n);
            ScoreList sl = new ScoreList();
            gamer.setScore(sl);
            scorecard.add(gamer);
            gamer.printToConsole();
        }else System.out.println("No name to add");
    }
    public static void addScore(String name, ScoreList sL){
        gamer = getGamer(name);
        ScoreList newsL = new ScoreList();
        newsL.setScore(sL.getScore());
        gamer.setScore(newsL);
        
    }
    public static void editScore(GamerScore g, ScoreList sL, int index){
        g.insertScore(sL, index);
    }
    
    public static ObservableList<String> getNames(){
        return names;
    }
    public static GamerScore getGamer(String name){
        gamer=new GamerScore();
        boolean found = false; // to determine if name is in list
        for(int i = 0; i < scorecard.size(); i++){          // if there return name
            if (scorecard.get(i).getName().equals(name)){       
                gamer=scorecard.get(i);
                found = true;
            }
        }
        if(!found){                         // if not found, return nonname
            gamer.setName("NoName");
            System.out.println("Gamer score not found in score card");
        }
        return gamer;
    }
    public static ObservableList<GamerScore> getScoreCardList() {
        return scorecard;
    }
    public static Integer getTotalScore(GamerScore g){
        return g.totalScore();
    }
    
    public static Integer checkFarkleCount(GamerScore g){
        Integer farkle = 0;
        int count = g.getFarkelCount();
        count++;
        if(count < 3){
            g.setFarkelCount(count);
        }else {
            farkle = -300;
            g.setFarkelCount(0);
        }
        System.out.println("Sending Integer: "+farkle);
        return farkle;
    }
    public static void resetFarkleCount(GamerScore g){
        g.setFarkelCount(0);
    }
    
    public static void makeRowHeader() {
//        cellData.clear();
        List<ScoreList> cellData = new ArrayList<>(); 
        for(Integer i=1; i<=15;i++){
            ScoreList rH = new ScoreList();
            rH.setScore(i);
//            System.out.print("RowHeader ScoreList object added"+rH.toString());
            cellData.add(rH);
//            System.out.println("Row Header: "+ i);
        }
        GamerScore rowHeader = new GamerScore("Name",cellData);
        scorecard.add(rowHeader);
        rowHeader.printToConsole();
        
    }
    
        
    public static void resetGame(){
        scorecard.clear();
    }
    
    
  
    
}
