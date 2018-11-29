package insiderthreatv3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateEntry{

    private Date from;
    private Date to;
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    
    public DateEntry(String rawFrom, String rawTo){
        try {

            from = formatter.parse(rawFrom);
            to   = formatter.parse(rawTo);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    public int TimeLocation(ActivityEntry activityEntry){
        Date activityTime = activityEntry.getDate();
        
        if(activityTime.before(from))return -1;
        if(activityTime.after (to)  )return  1;
        return 0;        
    }    

    public void show(){
        System.out.println("Main data storage frame");
        System.out.println("From: " + formatter.format(from));
        System.out.println("To: "   + formatter.format(to));
        System.out.println();
    }
    
    
}