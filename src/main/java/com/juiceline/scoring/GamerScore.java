/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juiceline.scoring;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author darianwelch
 */
public class GamerScore {
    private String name;
    private ObservableList<Integer> score = FXCollections.observableArrayList();
    
    public GamerScore(){
    }
    
    public GamerScore(String name) {
        this.name = name;
    }
    
    public GamerScore(String name, ObservableList<Integer> score) {
        this.name = name;
        this.score = score;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObservableList<Integer> getScore() {
        return score;
    }
    
    public void setScore(ObservableList<Integer> score) {
        this.score = score;
    }
    
   
    public void printToConsole(){
        System.out.print("\n");
        System.out.println("Gamer name: " + this.name);
        for(int i = 0; i<score.size(); i++){ 
            int index = i;
            System.out.print(this.score.get(index) + " ");
        }
        System.out.print("\n");
        
    }
    
    public Integer totalScore(){
        Integer ts = 0;
        for(int i=0; i< score.size(); i++)ts = ts + score.get(i);
        
        System.out.println("Total Score is:" + ts);
        System.out.println("Name called for total:" + name);
        return ts;
    }
    
    public void enterScore(Integer i, int position){
        if(score.isEmpty())score.add(i);
        else score.add(i, position);
    }

}
    