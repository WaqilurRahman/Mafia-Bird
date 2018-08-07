/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sprite;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author ghost
 */
public class FinalPanel{
    public static boolean reload=false,shoot=false;
    public static boolean win = false;
        
    Boss b = new Boss();
    Bird2 b2 =new Bird2(5);
    Strength str = new Strength();
    Reload r = new Reload();
    Shoot s = new Shoot();
    SoundPlayer Msn = new SoundPlayer();
    
    public void draw(Graphics g){
        g.drawImage(Image.finalback, 0, 0, null);
        b.drawBoss(g);
        if(win!=true){
            drawBossBeam(g);
        }
        b2.drawBird(g);
        if(shoot==false){
            if(reload==true){
                if(Reload.r<=99){
                    Reload.r+=4;
                }
            }
            else if(Reload.r>=0){
                Reload.r-=2;
            }
        }
        if(Reload.r>=99){
            Msn.play(Music.me,"start");
            s.addBullet(new Bullet(b2.px+25,b2.py+20,Image.mybullet,25, 15));
            Reload.r=0;
            shoot=true;
        }
        if(s.b.size()!=0){
            s.draw(g);
        }
        collision();
        if(Background.gameover==true){
            b2.dead();
            g.setFont(new Font("Dots and Lines",Font.BOLD,80));
            g.setColor(Color.red);
            g.drawString("Game Over",Background.w/2-150, Background.h/2-100);
        }
        if(win==true){
            b.dead();
            g.setFont(new Font("Dots and Lines",Font.BOLD,80));
            g.setColor(Color.green);
            g.drawString("You Win",Background.w/2-150, Background.h/2-100);
        }
        str.drawStrength(g);
        g.setFont(new Font("Dots and Lines",Font.BOLD,30));
        g.setColor(Color.blue);
        r.draw(g);
        g.drawString("Life: "+b2.life,30,550);
        g.setColor(Color.red);
        g.drawString("Boss: "+b.bossLife,Background.w-100,50);
    }
    
    public void drawBossBeam(Graphics g){
        if(b.beam.bim==true){
                b.eshoot.draw(g);
                b.bsn.play(Music.bim,"start");
                b.soot=true;
                b.beam.stop=true;
                b.tim3.stop();
            }
            if(b.beam.stop==false){
                b.move();
                b.soot=false;
            }
    }
    
    public void collision(){
        if(s.b.size()!=0){
            for(int i =0;i<s.b.size();++i){
                if(s.b.get(i).getBullet().intersects(b.getBoss())){
                    --b.bossLife;
                    s.b.remove(i);
                }
            }
        }
        if(b.st.b.size()!=0){
            for(int i=0;i<b.st.b.size();++i){
                if(b.st.b.get(i).getBullet().intersects(b2.getBird())){
                    if(b2.life!=0){
                        --b2.life;
                    }
                    b.st.b.remove(i);
                }
            }
        }
        if(b.eshoot.bm.size()!=0){
                if(b.eshoot.bm.get(0).getBeam().intersects(b2.getBird())){
                Background.gameover=true;
                b2.life=0;
            }
        }
    }
}
