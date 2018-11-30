/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insiderthreatv3;

/**
 *
 * @author eric
 */

//nó representando o perfil de cada usuário (nível 1)
public class UserNode{

    protected UserEntry userEntry;
    protected DateNode  child;
    
    public UserNode(UserEntry userEntry){
        this.userEntry = userEntry;
    }

    public void addChild(String from, String to){
        DateEntry timeFrame = new DateEntry(from, to);
        
        child = new DateNode(timeFrame);
    }

    public boolean contains(ActivityEntry key){
        return userEntry.contains(key);
    }

    public DateNode findSon(ActivityEntry key){
        return child;
    }
    
    public boolean checkId(String id){
        return userEntry.getUser_id().equals(id);
    }


    public void show(){
        userEntry.show();
        
        child.show();
    }
    
}