/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sprite;

import java.awt.Graphics;

/**
 *
 * @author ghost
 */
public class Nest {
    public int x;
    public int y;
    
    public Nest(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    public void drawNest(Graphics g){
        g.drawImage(Image.nest, x, y, null);
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
