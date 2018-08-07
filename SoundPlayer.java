/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sprite;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author ghost
 */
public class SoundPlayer implements Runnable{
    
    public void play(File Sound,String s){
        Clip cp = null;
        try{
            cp = AudioSystem.getClip();
            cp.open(AudioSystem.getAudioInputStream(Sound));
        }catch(Exception e){
            System.out.println(e);
        }finally{
            if(s=="start"){
                cp.start();
            }
            else if(s=="stop"){
                cp.stop();
            }
            else if(s=="loop"){
                cp.loop(Clip.LOOP_CONTINUOUSLY);
            }
        }
    }

    @Override
    public void run() {
        try{
            Thread.sleep(5000);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
