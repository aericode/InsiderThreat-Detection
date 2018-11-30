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
import java.util.Scanner;

/**
 *
 * @author eric
 */
public class Tree {
    
    private RootNode root;
    
    public Tree(){
        root = new RootNode();
    }
    
    
    public void initializeRoutine(){
              
        
        initializeUsers("../r1/LDAP/2010-04.csv");
        System.out.println("carregando banco de usuarios...");
        
        System.out.println("carregando paginas acessadas...");
        initializeActivity("../r1/http.csv");
        System.out.println("carregando dispositivos acessados...");
        initializeActivity("../r1/device.csv");
        System.out.println("carregando registro de logins...");
        initializeActivity("../r1/logon.csv");
        
        
        ActivityEntry key;
        key = new ActivityEntry("{I0C6-Q9AW80AI-5286YZOX}","01/04/2010 06:26:16","DTAA/CBP0628","PC-4750","Logon");
        
        searchEntry(key);
    }
    
    private void initializeUsers(String csvFile) {

        
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        UserEntry userEntry;
        
        
        //ADIÇÃO DE FRAMES NOS DATENODES
        Scanner scanner;
        scanner = new Scanner(System.in);
        
        String fromRaw;
        String toRaw;
        
        System.out.println("Selecione a data de início para a análise ");
        fromRaw  = scanner.nextLine();
        System.out.println("Selecione a data do final da análise");
        toRaw    = scanner.nextLine();  


        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] logEntry = line.split(cvsSplitBy);    
                
                userEntry = new UserEntry(logEntry[0] , logEntry[1] , logEntry[2] , logEntry[3] , logEntry[4]);

                //adiciona um UserNode
                root.addChild(userEntry);
                //adiciona DateNode no nó adicionado
                root.lastAdded().addChild(fromRaw,toRaw);

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
    
    private void initializeActivity(String csvFile) {

        ActivityEntry activityEntry;
        
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        


        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] logEntry   = line.split(cvsSplitBy);
                   
                
                activityEntry = new ActivityEntry(logEntry[0] , logEntry[1] , logEntry[2] , logEntry[3] , logEntry[4]);

                //adiciona um UserNode
                
                
                String[] path     = csvFile.split("\\\\");
                String originFile = path[path.length-1];
                
                activityEntry.setOrigin(originFile);
                
                UserNode level1 = root.findSon(activityEntry);
                if(level1 == null)continue;
                DateNode level2 = level1.findSon(activityEntry);
                //também checa redundâncias, caso já haja um registro
                level2.addChild(activityEntry);
                PcNode  level3  = level2.findSon(activityEntry);
                level3.addChild(activityEntry);
                
                //adiciona DateNode no nó adicionado

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
