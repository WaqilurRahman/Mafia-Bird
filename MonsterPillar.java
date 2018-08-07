/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sprite;

//import static com.test.sprite.HorsePillar.n;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author ghost
 */
public class MonsterPillar {
    public static int x;
    public static int y = Background.h-200;
    
    Random rm = new Random();
    
    public boolean nest = true;
    
    Nest nst;
    
    public MonsterPillar(int x){
        this.x=x;
        nst = new Nest(x-40, this.y+60);
    }
    
    public void drawMpillar(Graphics g){
        g.drawImage(Image.Mpillar, x, y, null);
        if(nest==false){
            Background.bag.add(nst);
            Background.ncount = Background.bag.size();
        }
        
        if(nest == true){
            nst.drawNest(g);
        }
        move();
    }
    public void move(){
        if(Background.gameover!=true){
            x+=Background.speed2;
            nst.x+=Background.speed2;
            if(x<=-150){
                reset();
            }
        }
        
    }
    public Rectangle getMonster(){
        Rectangle MRect = new Rectangle(x+50,y, 50, Background.h);
        return MRect;
    }
    public Rectangle getNest(){
        Rectangle Nstrect = new Rectangle(nst.x, nst.y,70, 35);
        return Nstrect;
    }
    public void reset(){
        Background.pMcount=0;
        Background.Mpillar=false;
        Background.pM = rm.nextInt(10)+1;
    }
}
