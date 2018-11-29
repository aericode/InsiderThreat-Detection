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
    
    //frame escolhido pelo user para analisar o banco de dados
    protected List<PcNode> analysisFrame;
    
    //frame escolhido pelo user para analisar o banco de dados   
    protected List<PcNode> after;
    protected List<PcNode> before;
    
    public DateNode(DateEntry dateEntry){
        this.dateEntry = dateEntry;
        
        analysisFrame = new ArrayList<PcNode>();
        before        = new ArrayList<PcNode>();
        after         = new ArrayList<PcNode>();

        
    }

    
    public void addChild(ActivityEntry activityEntry){
        //verifica se está antes ou depois do local de armazenamento
        int position = dateEntry.TimeLocation(activityEntry);
        
        PcNode node = new PcNode(activityEntry);
        
        //checa se há redundância no nó correspondente antes de criar um nó correspondente ao PC da atividade
        
        if(position == 0){
            if(!isRedundant(analysisFrame, activityEntry ) ){
                analysisFrame.add(node);
            }
            
        }else if(position == -1){
            if(!isRedundant(before, activityEntry ) ){
                before.add(node);
            }
            
        }else if(position == 1){
            if(!isRedundant(after, activityEntry ) ){
                after.add(node);
            }
            
        }
    }
    
    public boolean isRedundant(List<PcNode> pcContainer,ActivityEntry activityEntry){
        for (PcNode current : pcContainer) {
            if(current.contains(activityEntry)){
                return true;
            }
        }
        return false;
    }
    



    public void show(){
        dateEntry.show();
    }
    
}