/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

/**
 *
 * @author Marina
 */
public class Visa {
     private long cardNO;
    private String CardHolder;
    private int CVV;
    //private java.util.Date expdate;
    private String expdate;
    
    public void setcardNo(long cardNO){
        this.cardNO = cardNO;
    }
    public long getcardNO(){
        return cardNO;
    }
    public void setcardHolder(String CardHolder){
        this.CardHolder = CardHolder;
    }
     public String getcardHolder(){
        return CardHolder;
    }
    public void setCVV(int CVV){
        this.CVV = CVV;
    }
    public int getCVV(){
        return CVV;
    }
    /*public void setexpDate(java.util.Date expdate){
        this.expdate = expdate;
        
    }*/
   /* public java.util.Date getexpDate(){
        return expdate;
    }*/
    public void setexpdate(String expdate){
        this.expdate = expdate;
    }
    public String getexpdate(){
        return expdate;
    }
    public void info(){
        Scanner in = new Scanner (System.in);
            System.out.println("Enter card number: ");
            cardNO = in.nextLong();
            in.nextLine(); //to return the input that was once skipped
            System.out.println("Enter card holder name: ");  
            CardHolder = in.nextLine();
            System.out.println("Enter CVV: ");
             CVV = in.nextInt();
             System.out.println("Enter expiration date in this format (mm/yy)");
             expdate = in.next();
           /* System.out.println("Enter expiration date (dd//mm//yy): ");
             SimpleDateFormat fo = new SimpleDateFormat("dd/mm/yy");
             fo.format(expdate);*/
    }
}
