/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sprite;

//import static com.test.sprite.Background.kb;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author ghost
 */
public class Main extends JFrame{
    
    public static Timer tim,tm;
    public static int level=1;
    public static enum State{Menu,Game,Instruction};
    
    public static State st = State.Menu;
    public static Keyboard kb;
    //public static SoundPlayer sn = new SoundPlayer();
    //MouseInput ms;
    
    public Main(){
        setSize(Background.w,Background.h);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image.Load();
        Music.LoadMusic();
        startnow();
        kb = new Keyboard();
        this.addKeyListener(kb);
        this.setFocusable(true);
        this.addMouseListener(new MouseInput());
    }
    
    public  void startnow(){
        Background bg = new Background();
        
            tim = new Timer(20, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        bg.repaint();
                        bg.moveRight();
                }
            });
            tim.start();
            this.add(bg);
            this.setVisible(true);
    }
    
    public static void main(String[] args) {
        Main m = new Main();
        
    }
    
}
