/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sprite;

import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author ghost
 */
public class Reload {
    public static int r=0;
    
    public void draw(Graphics g){
        g.drawRect(5, 25,100, 10);
        g.fillRect(5, 25,r,10);
        g.setFont(new Font("Dots and Lines",Font.BOLD,20));
        g.drawString("Load", 120,40);
    }
}
