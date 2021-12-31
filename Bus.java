/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import javax.swing.JFrame;

/**
 *
 * @author Marina
 */
public class Bus  {
    private int BusCode;
    private int TotalSeats;
    Bus()
    {   //assigned the parameterized constructor with 0 busCode and Totalseats
        this(0,0); 
        
    }
    Bus(int BusCode,int TotalSeats)
    {
        this.BusCode=BusCode;
        this.TotalSeats=TotalSeats;
    }
    public int getBusCode()
    {
        return  BusCode; 
    }
    public void setBusCode(int BusCode)
    {
        this.BusCode=BusCode;
    }
    public int getTotalSeats()
    {
        return  TotalSeats;  
    }
    public void setTotoalSeats(int TotalSeats)
    {
        this.TotalSeats=TotalSeats;
    }
    public void SearchBuscode(){
        
    }
}
