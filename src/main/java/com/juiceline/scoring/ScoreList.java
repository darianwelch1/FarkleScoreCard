/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juiceline.scoring;

/**
 *
 * @author darianwelch
 */
public class ScoreList {
    
    Integer score;

    public ScoreList() {
        score = (Integer)0;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        String s = score.toString();
        return s;
    }
    

}
