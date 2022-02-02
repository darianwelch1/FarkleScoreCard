/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juiceline.scoring;

import java.util.List;

/**
 *
 * @author darianwelch
 */
public class GamerScore {
    private String name;
    private List score;
    
    public GamerScore(String name, List score) {
        this.name = name;
        this.score = score;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getScore() {
        return score;
    }

    public void setScore(List score) {
        this.score = score;
    }
    

}
    