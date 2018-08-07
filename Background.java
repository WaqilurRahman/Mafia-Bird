/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sprite;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.HashSet;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author ghost
 */
public class Background extends JPanel{
    
    public static int h = 600;
    public static int w = 1000;
    public static boolean Hpillar = false;
    public static boolean Mpillar = false;
    public static int sp=1;
    public static boolean reload =false; 
    public static int pHcount=0;
    public static int pH=5;
    public static int pMcount=0;
    public static int pM=8;
    public static int ncount = 0;
    public static boolean gameover = false;
    public static boolean s = false; 
    public static int pS=0;
    public static int sa = 4;
    public boolean sht = false;
    public static int speed2 = -3;
    public static boolean push = false,webPush=false,levelup=false;
    
    public int x=0;
    
    Bird bd = new Bird(5);
    
    public static HashSet<Nest> bag = new HashSet<>();
    
    Shoot st = new Shoot();
    Spider spd;
    
    Pillar p1 = new Pillar(Background.w);
    Pillar p2 = new Pillar(Background.w+(Background.w/2)+40);
    Random r = new Random();
    Strength str = new Strength();
    
    HorsePillar hp;
    MonsterPillar mp;
    Menu mn = new Menu();
    SoundPlayer sn = new SoundPlayer();
    SoundPlayer Birdsn = new SoundPlayer();
    
    FinalPanel fn;
    
    public Background(){
        st.setRange(bd.px+250);
        sn.play(Music.bksnd,"loop");
    }
    public void initial(){
        bag = new HashSet<>();
        bd = new Bird(5);
        p1 = new Pillar(Background.w);
        p1 = new Pillar(Background.w);
        p2 = new Pillar(Background.w+(Background.w/2)+40);
        st = new Shoot();
        st.setRange(bd.px+250);
        Strength.strength=200;
        FinalPanel.win=false;
        FinalPanel.reload=false;
        FinalPanel.shoot=false;
        Pillar.stop=false;
        
        Hpillar = false;
        Mpillar = false;
        sp=1;
        reload =false; 
        pHcount=0;
        pH=5;
        pMcount=0;
        pM=8;
        ncount = 0;
        gameover = false;
        s = false; 
        pS=0;
        sa = 4;
        sht = false;
        speed2 = -5;
        push = false;webPush=false;levelup=false;
        x=0;
    }
    
    @Override
    public void paint(Graphics g){
        if(Main.st==Main.State.Menu){
            initial();
            mn.draw(g);
        }
        else if(Main.st==Main.State.Game){
            if(Main.level==1){
            g.drawImage(Image.back,x, 0,1400,600, null);
            g.drawImage(Image.back,x+1400,0,1400,600, null);
                //System.out.println(bag.size());
            
            game1(g);
            }
            else if(levelup==false){
                fn =new FinalPanel();
                levelup=true;
            }
            else if(Main.level==2){
                fn.draw(g);
            }
        }
        else if(Main.st==Main.State.Instruction){
            g.drawImage(Image.insPanel,0,0,Background.w,Background.h-50, null);
        }
        
    }
    
    public void game1(Graphics g){
        if(x<-1400){
            x=0;
        } 
        if(st.b.size()==0){
            sht=false;
        }
        bd.drawBird(g);
        
        if(pHcount==pH){
            hp = new HorsePillar((Background.w)+Background.w/4);
            Hpillar=true;
        }
        if(pMcount==pM){
            mp = new MonsterPillar((Background.w)+Background.w/4);
            Mpillar=true;
        }
        if(Hpillar==true){
            hp.drawHorsePillar(g);
        }
        if(Mpillar==true){
            mp.drawMpillar(g);
        }
        
        p1.drawPillar(g);
        p2.drawPillar(g);
        if(pS==sa && s==false){
            if(p2.X<=0 || p2.X>=w){
                s=true;
                spd = new Spider(p2.X+30, p2.Y-p2.gap);
                sa=r.nextInt(5)+1;
            }
            else if(p1.X<=0 || p1.X>=w){
                s=true;
                spd = new Spider(p1.X+30, p1.Y-p1.gap);
                sa=r.nextInt(5)+1;
            }
            
        }
        if(s==true){  
            spd.drawSpider(g);
            
            if(sht==true){
                for(int i=0;i<st.b.size();++i){
                    if(st.b.get(i).getBullet().intersects(spd.getSpider())){
                        s=false;
                        Background.pS=0;
                        Background.s=false;
                        st.b.remove(i);
                    }
                }
            }
        }
        if(push==true){
            st.addBullet(new Bullet(bd.px+30, bd.py+35,Image.air,10,50));
            Birdsn.play(Music.air,"start");
            push=false;
            sht=true;
        }
        st.draw(g);
        g.setFont(new Font("Dots and Lines",Font.BOLD,30));
        g.setColor(Color.red);
        g.drawString("Egg: "+ncount,50, 70);
        str.drawStrength(g);
        if(ncount==2){
            Main.level=2;
        }
        if(gameover==true){
            bd.dead();
            Strength.strength=0;
            g.setFont(new Font("Dots and Lines",Font.BOLD,100));
            g.setColor(Color.red);
            g.drawString("Game Over",Background.w/2-180, Background.h/2-0);
            speed2=0;
        }
        moveRight();
        collision();
    }
    
    public void collision(){
        if(p1.getPillar1().intersects(bd.getBird()) || p1.getPillar2().intersects(bd.getBird())){
            gameover=true;
        }
        else if(p2.getPillar1().intersects(bd.getBird()) || p2.getPillar2().intersects(bd.getBird())){
            gameover=true;
        }
        else if(Hpillar==true && hp.getHorse().intersects(bd.getBird())){
            gameover=true;
        }
        else if(Mpillar==true && mp.getMonster().intersects(bd.getBird()) ){
            gameover=true;
            //System.out.println("yesBird");
        }
        else if(Net.cath==true){
            if(Hpillar==true && hp.getNest().intersects(bd.nt.getNet())){
                hp.nest = false;
               // System.out.println(bag.size());
            }
            if(Mpillar==true && mp.getNest().intersects(bd.nt.getNet())){
                //bag.add(hp.nst);
                mp.nest = false;
                //System.out.println("Mpillar");
            }
        }
        else if( s==true && spd.getSpider().intersects(bd.getBird())){
            bd.freez();
            speed2=0;
        }
    }
    
    public void moveRight(){
        if(gameover!=true){
            x+=(speed2);
        } 
    }
}
