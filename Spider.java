/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sprite;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author ghost
 */
public class Spider {
    public int spx=0,spy=0;
    

    public Spider(int x,int y) {
        spx=x;
        spy=y;
    }
    
    public void drawSpider(Graphics g){
        g.drawImage(Image.spider, spx, spy, null);
        move();
    }
    
    public void move(){
        spx+=Background.speed2;
        if(spx<=-90){
            Background.pS=0;
            Background.s=false;
        }
    }
    
    public Rectangle getSpider(){
        Rectangle r1 = new Rectangle(spx+25, spy,30,200);
        return r1;
    }
}
