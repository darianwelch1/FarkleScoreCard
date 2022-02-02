/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juiceline.scoring;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author darianwelch
 */
public class GamerScore {
    private String name;
    private LinkedList<Integer> score;
    
    public GamerScore(){
    }
    
    public GamerScore(String name, LinkedList score) {
        this.name = name;
        this.score = score;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getScore() {
        return score;
    }

    public void setScore(LinkedList<Integer> score) {
        this.score = score;
    }
    

}
    