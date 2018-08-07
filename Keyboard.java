/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sprite;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author ghost
 */
public class Keyboard implements KeyListener{
    
     @Override
    public void keyPressed(KeyEvent e) {
        if(Strength.strength>0){
            if(e.getKeyCode()==e.VK_UP  && Main.level==1 ){
                 Bird.movup=true;
            }
            else if(e.getKeyCode()==e.VK_DOWN && Main.level==1){
                Bird.movdown=true;
            }
            if(e.getKeyCode()==e.VK_UP  && Main.level==2 ){
               Bird2.movup=true;
            }
            else if(e.getKeyCode()==e.VK_DOWN && Main.level==2){
               Bird2.movdown=true;
            }
            else if(e.getKeyCode()==e.VK_V && Main.level==1){
                Net.cath=true;
            }
            else if(e.getKeyCode()==e.VK_X && Main.level==1){
                 Pillar.stop=true;
            }
            else if(e.getKeyCode()==e.VK_SPACE && Main.level==2){
                 FinalPanel.reload=true;
                 Bird2.mv=0;
            }
        }
       
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        if(e.getKeyCode()==e.VK_UP  && Main.level==1 ){
                 Bird.movup=false;
            }
            else if(e.getKeyCode()==e.VK_DOWN && Main.level==1){
                Bird.movdown=false;
            }
        if(e.getKeyCode()==e.VK_UP  && Main.level==2 ){
               Bird2.movup=false;
            }
            else if(e.getKeyCode()==e.VK_DOWN && Main.level==2){
               Bird2.movdown=false;
            }
        if(Strength.strength>0){
             if(e.getKeyCode()==e.VK_ENTER){
                Strength.k=5;
                if(Strength.strength>=198){
                    Strength.k=0;
                }
            }
            else if(e.getKeyCode()==e.VK_V && Main.level==1){
               Net.cath=false;
               Strength.strength-=25;
           }
            else if(e.getKeyCode()==e.VK_NUMPAD0 && Main.level==1){
                if(Strength.strength!=0){
                    Background.push=true;
                    Strength.strength-=20;
                }
           }
            else if(e.getKeyCode()==e.VK_Z && Main.level==1){
                Background.speed2=-3;
                Pillar.stop=false;
            }
            else if(e.getKeyCode()==e.VK_X && Main.level==1){
                //Background.speed2=0;
                //Background.supSpeed=0;
            }
             else if(e.getKeyCode()==e.VK_SPACE && Main.level==2){
                 FinalPanel.reload=false;
                 FinalPanel.shoot=false;
                 Bird2.mv=5;
            }
        } 
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }
    
}
