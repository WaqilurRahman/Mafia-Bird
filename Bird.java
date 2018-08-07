/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sprite;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author ghost
 */
public class Bird {
    
    public int px=100,py=500,sx=0,sy=0,r=700;
    public int accel=1;
    public static int mv =5;
    public int timeDelay=70; 
    public static boolean movup = false,movdown=false;
    
   
    
    public int Bspeed =2;
    public int acce =1;
    
    public boolean t = false;
    
    public static Timer tim;
    Net nt;
    public Bird(int mv){
        this.mv=mv;
        nt = new Net();
    }
    
    
    public void drawBird(Graphics g){
        g.drawImage(Image.bird, px, py, px+80, py+80, sx, sy, sx+100, sy+100,null);
        if(Net.cath==true){
           nt.setXY(px,py);
           nt.drawNet(g);
        }
        tim = new Timer(timeDelay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(sx==r){
                   sx=0;
               }
               else sx+=100;
            }
        });
        if(t==false){
            tim.start();
            t=true;
            
        }
        if(py<0 /*|| Bird.py>Background.h*/){
            Strength.strength=0;
        }
        if(movup==true){
            py-=mv;
        }
        else if(movdown==true){
            py+=mv;
        }
//        if(Spider.getSpider().intersects(getBird())){
//               
//            }
    }
    
    public void freez(){
        Bspeed=0;
        r=300;
        sx=0;
        Strength.k=0;
        Strength.strength=0;
    }
    
    public void dead(){
            Bspeed+=accel;
            py+=Bspeed;
            Background.gameover=true;
    }
    public Rectangle getBird(){
        Rectangle brect = new Rectangle(px,py,50,45);
        return brect;
    }
    
}
