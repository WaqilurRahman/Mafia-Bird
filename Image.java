/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sprite;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author ghost
 */
public class Image {
        
    public static BufferedImage back = null;
    public static BufferedImage bird = null;
    public static BufferedImage nest = null;
    public static BufferedImage Mpillar = null;
    public static BufferedImage Hpillar = null;
    public static BufferedImage mybullet = null;
    public static BufferedImage pillar = null;
    public static BufferedImage air = null;
    public static BufferedImage net = null;
    public static BufferedImage spider = null;
    public static BufferedImage beam = null;
    public static BufferedImage boss = null,finalback=null,mafia2=null,enemyBullet=null;
    public static BufferedImage newgame = null;
    public static BufferedImage instruction = null;
    public static BufferedImage quit = null;
    public static BufferedImage insPanel = null;
    public static BufferedImage menu = null;
    
    public static void Load(){
        try{
            back = ImageIO.read(new File("C:\\Users\\ghost\\Desktop\\Test\\back1.png"));
            bird = ImageIO.read(new File("C:\\Users\\ghost\\Desktop\\Test\\Mafia.png"));
            nest = ImageIO.read(new File("C:\\Users\\ghost\\Desktop\\Test\\Nest.png"));
            Mpillar = ImageIO.read(new File("C:\\Users\\ghost\\Desktop\\Test\\MonsterPillar.png"));
            Hpillar = ImageIO.read(new File("C:\\Users\\ghost\\Desktop\\Test\\HorsePillar.png"));
            mybullet = ImageIO.read(new File("C:\\Users\\ghost\\Desktop\\Test\\mybullet.png"));
            pillar = ImageIO.read(new File("C:\\Users\\ghost\\Desktop\\Test\\pillar.png"));
            air = ImageIO.read(new File("C:\\Users\\ghost\\Desktop\\Test\\air.png"));
            net = ImageIO.read(new File("C:\\Users\\ghost\\Desktop\\Test\\net.png"));
            spider = ImageIO.read(new File("C:\\Users\\ghost\\Desktop\\Test\\spider.png"));
            beam = ImageIO.read(new File("C:\\Users\\ghost\\Desktop\\Test\\beam3.png"));
            boss = ImageIO.read(new File("C:\\Users\\ghost\\Desktop\\Test\\Boss1.png"));
            finalback = ImageIO.read(new File("C:\\Users\\ghost\\Desktop\\Test\\finalback.png"));
            mafia2 = ImageIO.read(new File("C:\\Users\\ghost\\Desktop\\Test\\Mafiaweapon.png"));
            enemyBullet = ImageIO.read(new File("C:\\Users\\ghost\\Desktop\\Test\\enemyBullet.png"));
            menu = ImageIO.read(new File("C:\\Users\\ghost\\Desktop\\Test\\menu.png"));
            newgame = ImageIO.read(new File("C:\\Users\\ghost\\Desktop\\Test\\Newgame.png"));
            instruction = ImageIO.read(new File("C:\\Users\\ghost\\Desktop\\Test\\instruction.png"));
            quit = ImageIO.read(new File("C:\\Users\\ghost\\Desktop\\Test\\quit.png"));
            insPanel = ImageIO.read(new File("C:\\Users\\ghost\\Desktop\\Test\\ins.png"));
        }catch(Exception e){
            System.out.println(e);
        }
    }
          
}
