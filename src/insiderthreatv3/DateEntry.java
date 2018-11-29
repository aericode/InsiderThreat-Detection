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
    
    public DateEntry(String rawFrom, String rawTo){
        
        
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");

        try {

            from = formatter.parse(rawFrom);
            to   = formatter.parse(rawTo);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    

    //public boolean contains(ActivityEntry entry){
    //    return true;
    //}
    

    public void show(){
        System.out.println("Main data storage frame");
        System.out.println("From: " + from);
        System.out.println("To: "   + to);
        System.out.println();
    }
    
    
}