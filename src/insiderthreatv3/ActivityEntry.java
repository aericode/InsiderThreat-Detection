package insiderthreatv3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityEntry{

    private String id;
    private Date date;
    private String user;
    private String pc;
    private String activity;

    public ActivityEntry(String id,String date,String user,String pc,String activity){
        this.id       = id;
        setDate(date);
        this.user     = user;
        this.pc       = pc;
        this.activity = activity;
    }


    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }


    public void setDate(String date){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        try {

            this.date = formatter.parse(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public Date getDate(){
        return date;
    }


    public void setUser(String user){
        this.user = user;
    }
    public String getUser(){
        return user;
    }

    
    public void setPc(String pc){
        this.pc = pc;
    }
    public String getPc(){
        return pc;
    }

    
    public void setActivity(String activity){
        this.activity = activity;
    }
    public String getActivity(){
        return activity;
    }

    public void show(){
        System.out.println("ID da atividade:    "     + id);
        System.out.println("Data da atividade:      " + date);
        System.out.println("Usuário responsável: "    + user);
        System.out.println("PC da atividade:   "      + pc);
        System.out.println("Atividade:  "             + activity);
        System.out.println();
    }
    
    
}