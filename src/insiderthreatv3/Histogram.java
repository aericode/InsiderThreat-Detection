/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insiderthreatv3;

import java.util.Date;

/**
 *
 * @author eric
 */
public class Histogram {
    private int[] hourlyAccess;
    
    public Histogram(){
        hourlyAccess = new int[24];
    }
    
    public void update(ActivityEntry activityEntry){
        Date date = activityEntry.getDate();
        int  hour = date.getHours();
        hourlyAccess[hour]++;
    }
    
    public int getHourlyAccess(int i){
        return hourlyAccess[i];
    }
    
    public void show(){
        for(int i = 0; i < 24; i++){
            System.out.println("hora: " + i + " - acessos: " + hourlyAccess[i]);
        }
    }
    
}
