/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;
import java.io.*;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
/**
 *
 * @author Marina
 */
public class Admin {
  // ArrayList<String> PickUpPoints=new ArrayList<>();
    //ArrayList<String> DroppingPoint=new ArrayList<>();  
    //added another list 3asahn myhslsh conflict
    //ArrayList<String> routes = new ArrayList<>();
    //Routes R = new Routes();
   Routes r = new Routes();
    Scanner in = new Scanner(System.in);

    
    public void AddRoute() throws FileNotFoundException, IOException {
        
        System.out.println("Please enter the route you wish to add in this format (pickup point-dropping point)");
        r.setRoute(in.nextLine());
        //routes.add(Route);//in.nextLine 3ashan yakhod with the space kman

        FileWriter fw = new FileWriter("Routes.txt", true);//true is for the boolean so it could append 
        try (PrintWriter out = new PrintWriter(fw)) {
            System.out.println(System.lineSeparator());
            out.print(r + System.lineSeparator());

        } finally {
            fw.close();//mafesh line geded-size leeh zero?
        }
    }
    public void deleteRoute(){
     
}
}


/*public void Write()throws IOException{
       File Admin=new File("C:\\Users\\Marina\\Desktop");
       if(Admin.exists())
       {
           System.out.println("File already exists");
           System.exit(0);
       }
 
           PrintWriter output=new PrintWriter(Admin);
          /// output.println("MARINA");
          // output.close();
       
}*/
    

