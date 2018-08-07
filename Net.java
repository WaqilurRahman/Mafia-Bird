/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sprite;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author ghost
 */
public class Net {
    public int nx,ny,x,y;
    public static boolean cath = false;
    
    public void drawNet(Graphics g){
        if(cath==true){
            g.drawImage(Image.net, nx+35, ny+42, null);
        }
        
    }
    public void setXY(int x,int y){
        ny=y;
        nx=x;
    }
    public Rectangle getNet(){
        Rectangle nRect = new Rectangle(nx+60, ny+5,45,25);
        return nRect;
    }
        
}
