/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sprite;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author ghost
 */
public class MouseInput implements MouseListener {

    int w=320;
    int h=w/12*9;
    
    
    
    @Override
    public void mouseClicked(MouseEvent me) {
            int mx=me.getX();
            int my=me.getY();
            if((mx<=540 && mx>=330 ) && (my>=240 && my<=320)&& Main.st==Main.State.Menu){
                Main.st=Main.State.Game;
            }
            else if((mx<=540 && mx>=330 ) && (my>=340 && my<=450) && Main.st==Main.State.Menu){
                Main.st=Main.State.Instruction;
            }
            else if((mx<=540 && mx>=330 ) && (my>=440 && my<=550) && Main.st==Main.State.Menu){
                System.exit(0);
            }
            else if((Background.gameover==true) && Main.st==Main.State.Game){
                Main.st=Main.State.Menu;
                Main.level=1;
            }
            else if((FinalPanel.win==true) && Main.st==Main.State.Game){
                Main.st=Main.State.Menu;
                Main.level=1;
            }
            else if((Main.st==Main.State.Instruction)){
                Main.st = Main.State.Menu;
            }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
    
}
