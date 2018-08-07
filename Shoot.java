/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sprite;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author ghost
 */
public class Shoot {
    ArrayList<Bullet>  b = new ArrayList<>();
    public int speed=15;
    
    public int range = Background.w;
    
    public void addBullet(Bullet bl){
        b.add(bl);
    }
    public void removeBullet(Bullet bl){
        b.remove(bl);
    }
    public void setRange(int x){
        range=x;
    }
    
    public void setSpeed(int x){
        speed=x;
    }
    
    public void draw(Graphics g){
        for(int i=0;i<b.size();++i){
            if(b.size()!=0){
                b.get(i).speed=this.speed;
                b.get(i).move();
                b.get(i).drawBullet(g);
            }
            
            if(b.get(i).getX()>range){
                removeBullet(b.get(i));
            }
            
        }
        
    }
}
