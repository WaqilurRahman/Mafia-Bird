/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sprite;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author ghost
 */
public class Menu extends JPanel{
    
    public static int nx=0,ny=0,ix=0,iy=0,qx=0,qy=0;
    public int bx=Background.w/2-200,by=Background.h/2-100;
    
    
    public void draw(Graphics g){
        
        g.drawImage(Image.menu, 0,0,Background.w,Background.h, null);
        g.drawImage(Image.newgame,bx,by,bx+250,by+100,nx,ny,nx+250,ny+100, null);
        g.drawImage(Image.instruction,bx,by+100,bx+250,by+200, ix, iy, ix+250, iy+100, null);
        g.drawImage(Image.quit,bx,by+200,bx+250,by+300, qx, qy, qx+250, qy+100, null);
    }
}
