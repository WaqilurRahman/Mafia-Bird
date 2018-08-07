/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sprite;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author ghost
 */
public class Bullet {
    
    public int bx=0,by=0,speed=15,w,h;
    public BufferedImage a=Image.mybullet;
    
    public Bullet(int x,int y,BufferedImage b,int w,int h){
        bx=x;
        by=y;
        a=b;
        this.w=w;
        this.h=h;
    }
    
    public void move(){
        bx+=speed;
    }
    
    public int getX(){
        return bx;
    }
    public int getY(){
        return by;
    }
    
    public void setX(int x){
        bx=x;
    }
    public void setY(int y){
        by=y;
    }
    
    public void drawBullet(Graphics g){
        g.drawImage(a, bx, by, null);
    }
    
    public Rectangle getBullet(){
        Rectangle re = new Rectangle(bx, by,w,h);
        return re;
    }
}
