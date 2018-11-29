package insiderthreatv3;

import insiderthreatv3.UserEntry;
import insiderthreatv3.UserNode;
import insiderthreatv3.ActivityEntry;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author eric
 */

//nó que armazena todos os usuários
public class RootNode{

    
    protected List<UserNode> child; 
    
    public RootNode(UserEntry userEntry){
        child = new ArrayList<UserNode>();
    }

    public void addChild(UserEntry userEntry){
        UserNode node = new UserNode(userEntry);
        child.add(node);        
    }

    public UserNode findSon(ActivityEntry key){
        for (UserNode current : child) {
            if (current.contains(key)) {
                return current;
            }
        }
        return null;
    }
    
    public UserNode findId(String id){
        for (UserNode current : child) {
            if (current.checkId(id)) {
                return current;
            }
        }
        return null;
    }
    
    public UserNode lastAdded(){
        return child.get(child.size() - 1);
    }
    
}
