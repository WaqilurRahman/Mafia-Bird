/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sprite;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author ghost
 */
public class Strength {
    public static int strength = 200;
    public static int k =-1;
    public boolean t = false;
    Timer tim;
    
    public void drawStrength(Graphics g){
        g.setColor(Color.green);
        g.drawRect(5,5,200,10);
        g.setFont(new Font("Dots and Lines",Font.BOLD, 20));
        g.drawString("Strength", 220, 15);
        if(strength>=0){
            g.fillRect(5,5, strength, 10);
        }
        kill();
    }
    
    public void kill(){
        
        tim = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strength +=k;
                k=-1;
            }
        });
        if(t==false){
            tim.start();
            t=true;
        }
        
    }
}
