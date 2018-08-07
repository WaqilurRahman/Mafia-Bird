/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sprite;

import java.io.File;

/**
 *
 * @author ghost
 */
public class Music {
    public static File bksnd = null;
    public static File air = null;
    public static File bim = null;
    public static File me = null;
    public static File boss = null;
    
    public static void LoadMusic(){
        bksnd = new File("C:\\Users\\ghost\\Desktop\\Test\\sound.wav");
        air = new File("C:\\Users\\ghost\\Desktop\\Test\\Birdair.wav");
        bim = new File("C:\\Users\\ghost\\Desktop\\Test\\bim2.wav");
        me = new File("C:\\Users\\ghost\\Desktop\\Test\\me.wav");
        boss = new File("C:\\Users\\ghost\\Desktop\\Test\\Boss.wav");
    }
}
