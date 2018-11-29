/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insiderthreatv3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author eric
 */
public class Tree {
    
    private RootNode root;
    
    
    public Tree(){
        root = new RootNode(null);
        
        initializeUsers("../r1/LDAP/2010-04.csv");
        
        
        ActivityEntry key;
        key = new ActivityEntry("{I0C6-Q9AW80AI-5286YZOX}","01/04/2010 06:26:16","DTAA/CBP0628","PC-4750","Logon");
        
        searchEntry(key);
    }
    
    private void initializeUsers(String csvFile) {

        
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        UserEntry userEntry;


        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] logEntry = line.split(cvsSplitBy);    
                
                userEntry = new UserEntry(logEntry[0] , logEntry[1] , logEntry[2] , logEntry[3] , logEntry[4]);

                root.addChild(userEntry);

            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    
    private void searchEntry(ActivityEntry activityEntry){       
        UserNode userNode = root.findSon(activityEntry);
        if(userNode!=null){
            userNode.show();
        }else{
            System.out.println("Entrada não correspondente a nenhum valor armazenado");
        }
    }
}
