/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insiderthreatv3;

import java.util.Date;
import java.lang.Math;

/**
 *
 * @author eric
 */
public class MasterHistogram {
    private int[] hourlyAccess;
    private int   elementCount;
    
    public MasterHistogram(){
        hourlyAccess = new int[24];
        elementCount = 0;
    }
    
    public void addHistogram(Histogram histogram){
        elementCount++;
        for(int i = 0; i < 24; i++){
            this.hourlyAccess[i] += histogram.getHourlyAccess(i);
        }
    }
    
    public void setToAverage(){
        if(elementCount == 0)return;
        for(int i = 0; i < 24; i++){
            hourlyAccess[i] /= elementCount;
        }
    }
    
    public double distance(Histogram histogram){
        int sum = 0;
        for(int i = 0; i < 24; i++){
           sum += Math.pow(hourlyAccess[i],2) - Math.pow(histogram.getHourlyAccess(i),2);
        }
        return Math.sqrt(sum);
    }
    
    public void show(){
        for(int i = 0; i < 24; i++){
            System.out.println("hora: " + i + " - acessos: " + hourlyAccess[i]);
        }
    }
    
}
