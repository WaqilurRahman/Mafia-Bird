/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sprite;

import static com.test.sprite.Bird.tim;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author ghost
 */
public class Bird2 extends Bird{
    
    public int speed=2,acceler=1;

    public Bird2(int mv) {
        super(mv);
    }
    
    public int life =2;
    
    @Override
    public void drawBird(Graphics g){
        g.drawImage(Image.mafia2, px,py, px+80, py+80, sx, sy, sx+100, sy+100, null);
        tim = new Timer(100, new ActionListener() {
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
        if(py<0 || py>Background.h){
            Strength.strength=0;
        }
        if(Strength.strength==0 || life==0){
            Background.gameover=true;
        }
        if(movup==true){
            py-=mv;
        }
        else if(movdown==true){
            py+=mv;
        }
    }
    @Override
    public void dead(){
            speed+=acceler;
            py+=speed;
            Strength.strength=0;
    }
    
}
