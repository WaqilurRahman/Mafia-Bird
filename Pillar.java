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
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author ghost
 */
public class Pillar {
    
    private Random r = new Random();
    
    public int X;
    public int Y = r.nextInt(Background.h-300)+250;
    public int height = Background.h-Y;
    public int width = 80;
    public int gap = 200;
    
    public Pillar(int X){
        this.X=X;
    }
    
    public Timer tim;
    public static boolean stop = false;
    public boolean t=false;
    
    public void drawPillar (Graphics g){
        g.drawImage(Image.pillar, X, Y,null);
        g.drawImage(Image.pillar, X,(-Background.h)+(Y-gap),null);
        tim = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(stop==true){
                    if(Background.speed2!=0){
                        ++Background.speed2;
                        System.out.println(Background.speed2);
                    }
                }
            }
        });
        if(t==false){
            tim.start();
            t=true;
        }
        movep();
    }
    
    public int getX(){
        return X;
    }
    public int getY(){
        return Y;
    }
    public void setX(int x){
        this.X = x;
    }
    
    public void movep(){
        if(Background.gameover!=true){
            X+=Background.speed2;
            if(X<=-80){
                p_reset();  
            }
        }
    }
    public  void p_reset(){
        X=Background.w;
        Y= r.nextInt(Background.h-300)+250;
        height = Background.h-Y;
        Background.pHcount+=1;
        Background.pMcount+=1;
        Background.pS+=1;
    } 
    public Rectangle getPillar1(){
        Rectangle dwrect = new Rectangle(X,Y,width,height);
        return dwrect;
    }
    public Rectangle getPillar2(){
        Rectangle uRect = new Rectangle(X,0, width,Background.h-(height+gap));
        return uRect;
    }
}
