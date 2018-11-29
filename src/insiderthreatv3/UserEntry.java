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
public class UserEntry{

    private String employee_name;
    private String user_id;
    private String domain;
    private String email;
    private String role;

    
    public UserEntry(String employee_name,String user_id,String domain,String email,String role){
        this.employee_name = employee_name;
        this.user_id       = user_id;
        this.domain        = domain;
        this.email         = email;
        this.role          = role;
    }


    public void setEmployee_name(String employee_name){
        this.employee_name = employee_name;
    }
    public String getEmployee_name(){
        return employee_name;
    }


    public void setUser_id(String user_id){
        this.user_id = user_id;
    }
    public String getUser_id(){
        return user_id;
    }


    public void setDomain(String domain){
        this.domain = domain;
    }
    public String getDomain(){
        return domain;
    }

    
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    
    public void setRole(String role){
        this.role = role;
    }
    public String getRole(){
        return role;
    }

    public boolean contains(ActivityEntry activityEntry){
        String userCode = "DTAA/" + user_id;
        return userCode.equals(activityEntry.getUser());
    }

    public void show(){
        System.out.println("Nome do funcionário:    " + employee_name);
        System.out.println("ID do funcionário:      " + user_id);
        System.out.println("Domínio do funcionário: " + domain);
        System.out.println("Email do funcionário:   " + email);
        System.out.println("Função do funcionário:  " + role);
        System.out.println();
    }

    
}