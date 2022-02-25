/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juiceline.scoring;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.juiceline.scoring.ScoreList;
import java.util.List;

/**
 *
 * @author darianwelch
 */
public class GamerScore {
    private String name;
    private ObservableList<ScoreList> score = FXCollections.observableArrayList();
    private Integer totalScore;
    private int farkelCount;
    
    public GamerScore(){
        name = "noName";
        
        score = null;
        totalScore = 0;
        farkelCount = 0;
    }

   

    
    public GamerScore(String name) {
        this.name = name;
        ScoreList sL = new ScoreList();
        score.add(sL);
        totalScore=0;
    }
    public GamerScore(String name, List<ScoreList> score) {
        this.name = name;
        this.score.addAll(score);
    }

    public String getName() {
        return name;
    }
    public int getFarkelCount() {
        return farkelCount;
    }
    public ObservableList<ScoreList> getScore() {
        return score;
    }
    
    public void insertScore(ScoreList sL,int index){
        score.set(index, sL);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public void setFarkelCount(int farkelCount) {
        this.farkelCount = farkelCount;
    }
    public void setScore(ScoreList s){
        ScoreList sL = s;
        int index = score.size();
//        System.out.println("Score sent to GamerScore to set: "+s.toString()
//            +"list length: "+score.size());
        this.score.add(sL);
    }
    
    public void printToConsole(){
        System.out.print("\n");
        System.out.println("Gamer name: " + this.name);
        for(int i = 0; i<score.size(); i++){ 
            System.out.print(this.score.get(i).toString() + " ");
        }
        System.out.print("\n");
    }
    
    public Integer totalScore(){
        int ts = 0;
        for(int i=0; i< score.size(); i++)ts = ts + score.get(i).getScore().intValue();
        totalScore = (Integer)ts;
//        System.out.println("Total Score is:" + totalScore);
//        System.out.println("Name called for total:" + name);
        return totalScore;
    }
}
    