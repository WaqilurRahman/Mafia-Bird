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
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author ghost
 */
public class Boss {
   public int bsx=Background.w-300,bsy=200;
   public int sx=0,sy=0;
   public int moveSpeed=-3,fallspeed=3;
   public int ac=2;
   public boolean t = false;
   public boolean t2 = false,t3=false;
   public boolean soot = false;
   public Random r = new Random();
   public int bossLife=3;

   Timer tim;
   Shoot st = new Shoot();
   Timer tim2,tim3;
   EnemyShoot eshoot = new EnemyShoot();
   SoundPlayer bsn =new SoundPlayer();
   Beam beam;

  /* public static int getX(){
       return bsx;
   }
   public static int getY(){
       return bsy;
   }*/

    public void drawBoss(Graphics g){
            g.drawImage(Image.boss, bsx, bsy, bsx+250, bsy+250,sx,sy,sx+300,sy+300,null);

            tim = new Timer(150, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(sx>=1500){
                        sx=0;
                    }
                    else sx+=300;
                }
            });
            if(t2==false){
                tim.start();
                t2=true;
            }
            tim3 = new Timer(5000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   if(soot==false){
                        eshoot.addBeam(beam=new Beam(bsx-(Background.w-240), bsy+110));
                        beam.bim=true;
                    }
                }
            });
            if(t3==false){
                tim3.start();
                t3=true;
            }
            if(FinalPanel.win!=true){
                moveBullet();
            }
            if(st.b.size()!=0){
                st.draw(g);
            }
            if(bossLife==0){
                FinalPanel.win=true;
            }
            

    }

    public void move(){
        bsy+=(moveSpeed*(-1));
        if(bsy<=-50 || bsy>=Background.h-215){
            moveSpeed=moveSpeed*(-1);
        }
    }
    public void moveBullet(){
        tim2 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bsn.play(Music.boss,"start");
                st.addBullet(new Bullet(bsx+30,bsy+125,Image.enemyBullet,25,12));
                st.setSpeed(-15);
            } 
        });
        if(t==false){
            tim2.start();
            t=true;
        }
    }

    public void dead(){
        fallspeed+=ac;
        bsy+=fallspeed;
        bsn.play(Music.boss, "stop");
        bsn.play(Music.bim, "stop");
        tim2.stop();
    }

    public Rectangle getBoss(){
        Rectangle r = new Rectangle(bsx+10, bsy+50,250,200);
        return r;
    }
}
