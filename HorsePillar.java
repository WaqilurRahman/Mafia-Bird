/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sprite;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author ghost
 */
public class HorsePillar {
    public int x1;
    public int y1=-20;
    public int height = y1 + 250;
    
    public boolean nest = true;
    
    Random rh = new Random();
    
    Nest nst;
    
    public HorsePillar(int x){
        this.x1=x;
        nst = new Nest(x-25,this.y1+225 );
    }
    
    public void drawHorsePillar(Graphics g){
        g.drawImage(Image.Hpillar,x1, y1, null);
        if(nest==false){
            Background.bag.add(nst);
            Background.ncount=Background.bag.size();
        }
        if(nest == true){
            nst.drawNest(g);
        }
        move();
    }
    
    public void move(){
        if(Background.gameover!=true){
            x1+=Background.speed2;
            nst.x+=Background.speed2;
            if(x1<=-80){
                reset();
            }
        }
    }
    public void addNest(){
        
    }
    public void reset(){
        Background.Hpillar=false;
        Background.pHcount=0;
        Background.pH = rh.nextInt(10)+1;
    }
    public Rectangle getHorse(){
        Rectangle HRect = new Rectangle(x1+10, y1+50,65 ,height-50);
        return HRect;
    }
    public Rectangle getNest(){
        Rectangle Nstrect = new Rectangle(nst.x, nst.y,70, 35);
        return Nstrect;
    }
}
