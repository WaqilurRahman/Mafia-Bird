/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sprite;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author ghost
 */
public class EnemyShoot{
    ArrayList<Beam> bm = new ArrayList<>();
    
    public void addBeam(Beam bl){
        bm.add(bl);
    }
    public void removeBeam(Beam bl){
        bm.remove(bl);
    }
    
    public void draw(Graphics g){
        for(int i=0;i<bm.size();++i){
            if(bm.size()>1){
                bm.remove(0);
            }
            if(bm.size()!=0){
                bm.get(i).drawBeam(g);
            }
            if(bm.get(i).sx>3000){
                removeBeam(bm.get(i));
            }
        }
    }
}
