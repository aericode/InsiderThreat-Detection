/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insiderthreatv3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eric
 */

public class DateNode{

    protected DateEntry dateEntry;
    
    public DateNode(DateEntry dateEntry){
        this.dateEntry = dateEntry;
        //child = new ArrayList<PcNode>();
    }

    /*
    public void addChild(ActivityEntry activityNode){
        PcNode node = new PcNode(activityNode);
        child.add(node);
    }
    */



    /*
    public PcNode findSon(ActivityEntry key){
        for (PcNode current : child) {
            if (current.contains(key)) {
                return current;
            }
        }
        return null;
    }
    */

    public void show(){
        dateEntry.show();
    }
    
}