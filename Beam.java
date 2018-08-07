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
public class Beam{
    public int bimx,bimy,sx=0,sy=0;
    public boolean t = false;
    public int speed=0;
    public Timer tim;
    
    public static boolean bim=false,stop=false;
    
     public Beam(int x,int y){
        bimx=x;
        bimy=y;
    }
    

    public void drawBeam(Graphics g){
        g.drawImage(Image.beam, bimx, bimy, bimx+850, bimy+80, sx, sy, sx+1000, sy+250,null);
        tim = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sx==4000){
                    sx=0;
                    bim=false;
                    stop=false;
                }
                else if(bim==true) sx+=1000;
                else sx=0;
            }
           
        });
        if(t==false){
            tim.start();
            t=true;
        }
    }

    public Rectangle getBeam(){
        Rectangle r = new Rectangle(bimx, bimy,620, 45);
        return r;
    }
}
