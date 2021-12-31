/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Marina
 */
public class Ticket {
    
private int SeatNO;
   private Time time;
   private java.util.Date date;
   
   Ticket()
   { 
       
   }
   public void setSeatNO(int seatno)
   {
       this.SeatNO=seatno;
   }
   public int getSeatNO()
   {
       return SeatNO;
   }
   public void setDate(java.util.Date date){
       this.date = date;
   }
   public java.util.Date getdate (){
       return date;
   }
   public void setTime(Time time){
       this.time = time;
   }
   public Time getTime(){
       return time;
   }
   public void print() 
   {
       Bus b = new Bus();
       b.getBusCode();
   }
   public void delete() 
   {
       
   }
   
   
   
   
}
