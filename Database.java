/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Marina
 */
public class Database 
{
   public static ArrayList<Customer> customers;
   public static ArrayList<Routes> routes;
   public static ArrayList<Admin> admin;
   public static ArrayList<Bus> bus;
    public static ArrayList<Ticket> ticket;
    public static ArrayList<Payment> payment;           //arraylist wel variable bt3ha
   private static File routeData = new File("routeData.dat");
   private static File customerData = new File("customerData.dat");
   private static File adminData=new File("adminData.dat");
   private static File busData=new File("busData.dat");
   private static File ticketData=new File("ticketData.dat");
   private static File paymentData=new File("paymentData.dat");      //da esm elfile
    static ArrayList<Object> Payment;
   Database() throws IOException, FileNotFoundException, ClassNotFoundException
   {
       if(!customerData.exists()) customerData.createNewFile();
       customers = (ArrayList<Customer>) readFile(customerData);
       
       if(!routeData.exists()) routeData.createNewFile();
       routes = (ArrayList<Routes>) readFile(routeData);
       
       if(!adminData.exists()) adminData.createNewFile();
       admin = (ArrayList<Admin>) readFile(adminData);
       
       if(!busData.exists()) busData.createNewFile();
      bus = (ArrayList<Bus>) readFile(busData);
      
       if(!ticketData.exists()) ticketData.createNewFile();
      ticket = (ArrayList<Ticket>) readFile(ticketData);
      
      if(!paymentData.exists()) paymentData.createNewFile();        //lw el file msh mwgood create one 
      payment = (ArrayList<Payment>) readFile(paymentData);      
       
   }
   
   private static Object readFile(File data) throws FileNotFoundException, IOException, ClassNotFoundException
   {
       FileInputStream fileIn = new FileInputStream(data);
       ObjectInputStream in = new ObjectInputStream(fileIn);
       
       Object obj = in.readObject();
       
       fileIn.close();
       in.close();
       
       return obj;
   }
   
   private static void writeFile(File data, Object outData) throws IOException
   {
       FileOutputStream fileOut = new FileOutputStream(data);
       ObjectOutputStream out = new ObjectOutputStream(fileOut);
       out.writeObject(outData);
       fileOut.close();
       out.close();       
   }
      
    public static void save() throws IOException
    {
        writeFile(customerData, customers);
        writeFile(routeData, routes);
        writeFile(adminData,admin);
        writeFile(busData,bus);
        writeFile(ticketData,ticket);
        writeFile(paymentData,payment);
        
       
    }
}
