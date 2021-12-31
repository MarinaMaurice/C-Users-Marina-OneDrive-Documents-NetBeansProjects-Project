/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.GridLayout;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.Routes.RouteWindow;

/**
 *
 * @author Marina
 */
public class Customer implements Serializable {

    private String fname;
    private String lname;
    private String phoneNumber;
    private int age;
    //private int pass;

    //public ArrayList <String> info;
    static ArrayList<Customer> info = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public Customer(String fname, String lname, String phoneNumber, int age) {
        this.fname = fname;
        this.lname = lname;
        this.phoneNumber = phoneNumber;
        this.age = age;
        // this.pass = pass;
    }

    
    public String getfname() {
        return fname;
    }

 
    public String getlname() {
        return lname;
    }

  
    public String getnum() {
        return phoneNumber;
    }

  
    public int getage() {
        return age;
    }

    /*public void setpass(int pass) {
        this.pass = pass;
    }

    public int getpass() {
        return pass;
    }*/
    // ArrayList <String> Customers = new ArrayList<>();
    public void registerCustomer() throws IOException, FileNotFoundException, ClassNotFoundException {
        FileReader re = new FileReader("C:\\Users\\Marina\\OneDrive\\Desktop\\project.txt");
        re.read();
        System.out.println("Enter your first name: ");
        fname = in.nextLine();
        System.out.println("Enter your last name: ");
        lname = in.nextLine();
        System.out.println("Enter your age: ");
        age = in.nextInt();
        in.nextLine();
        System.out.println("Enter your phone number: ");
        phoneNumber = in.nextLine();
        /*System.out.println("Enter your password in 4 numbers: ");
        pass = in.nextInt();*/

        new Database();
        //info.add(getfname()+" "+ getlname()+" " + getage()+" " + getnum()+" " + getpass()+" ");
        File Cusromer = new File("C:\\Users\\Marina\\OneDrive\\Desktop");
        FileWriter fw = new FileWriter("C:\\Users\\Marina\\OneDrive\\Desktop\\project.txt", true);//true is for the boolean so it could append 

        try ( PrintWriter out = new PrintWriter(fw)) {
            out.print(info);

        }
    }

    public void login() throws FileNotFoundException, IOException {
        System.out.println("Enter your phone number to login: ");
        Scanner in = new Scanner(System.in);
        long pn = in.nextLong();
        if (pn == 123456789) {
            System.out.println("Please enter your password: ");
            int pa = in.nextInt();
            if (pa == 1234) {
                System.out.println("Hi, Admin");
                Admin a = new Admin();
                a.AddRoute();
            }

        } else {
            File reader = new File("C:\\Users\\Marina\\OneDrive\\Desktop\\project.txt");
            Scanner re = new Scanner(reader);
            while (re.hasNext()) {
                String s = re.next();
                //System.out.println(s);
                if (s.equals(pn)) {
                    System.out.println("Please enter your password: ");
                    int pa = in.nextInt();
                }

            }

          
        }
    }

    static class Register extends JFrame implements ActionListener {

        static JFrame window;

        public static void open() {
            window = new Register();
        }
        JLabel FirstName = new JLabel("First Name *");
        JTextField fn = new JTextField(10);
        JLabel LastName = new JLabel("Last Name *");
        JTextField ln = new JTextField(10);
        JLabel PhoneNumber = new JLabel("Phone Number *");
        JTextField pn = new JTextField(11);
        JLabel Age = new JLabel("Age *");
        JTextField a = new JTextField(2);
        JButton save = new JButton("Save");

        public Register() {
            GridLayout grid = new GridLayout(7, 2, 10, 10);
            setLayout(grid);

            add(FirstName);
            add(fn);
            add(LastName);
            add(ln);
            add(PhoneNumber);
            add(pn);
            add(Age);
            add(a);
            add(save);
            save.addActionListener(this);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            setSize(800, 400);
            setVisible(true);
            // this.info = new ArrayList();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(save)) {
                if("".equals(ln.getText()) ||"".equals(fn.getText( ))||"".equals(pn.getText()) || "".equals(a.getText()))
                {    JOptionPane.showMessageDialog(null,"*required field*","Alert",JOptionPane.WARNING_MESSAGE);

                    System.err.println("must be required field");
                    return;
                }
                Database.customers = new ArrayList<>();
                try {
                    Database.save();
                } catch (IOException ex) {
                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                }
                Customer newCustomer;
               try {
                   newCustomer = new Customer(fn.getText(), ln.getText(), pn.getText(), Integer.valueOf(a.getText()).intValue());
               }
               catch (NumberFormatException x) {
                    newCustomer = new Customer(fn.getText(), ln.getText(), pn.getText(), 0);
               }

                try {
                    Database.save();
                } catch (IOException ex) {
                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                }
                window.setVisible(false);
                RouteWindow r = new RouteWindow();
                r.setVisible(true);
            }
        }

    }
}

/* int choice = -1;
       // FileReader re = new FileReader("Customer.txt");
        while(choice!=0){
        System.out.println("1.Insert");
        choice = in.nextInt();
        switch(choice){
            case 1:
         System.out.println("Enter your first name: ");
        fname = in.nextLine();
        System.out.println("Enter your last name: ");
        lname = in.nextLine();
        System.out.println("Enter your age: ");
        age = in.nextInt();
        in.nextLine();
        System.out.println("Enter your phone number: ");
        phoneNumber = in.nextLine();
        System.out.println("Enter your password in 4 numbers: ");
        pass = in.nextInt();
        
       info.add(getfname()+" "+ getlname()+" " + getage()+" " + getnum()+" " + getpass()+" ");
        
        File Customer = new File ("C:\\Users\\Mayar\\Desktop");
       FileWriter fw = new FileWriter("C:\\Users\\Mayar\\Desktop\\Customer.txt", true);//true is for the boolean so it could append 
 
        try (PrintWriter out = new PrintWriter(fw)) {
            out.print(info);
            
            //PrintWriter.println(info.get(age))
        }
        FileReader re = new FileReader("Customer.txt");
        re.read();
        }
        }
    }
}*/
 /* System.out.println("Enter your first name: ");
        fname = in.nextLine();
        System.out.println("Enter your last name: ");
        lname = in.nextLine();
        System.out.println("Enter your age: ");
        age = in.nextInt();
        in.nextLine();
        System.out.println("Enter your phone number: ");
        phoneNumber = in.nextLine();
        System.out.println("Enter your password in 4 numbers: ");
        pass = in.nextInt();
        
       info.add(getfname()+" "+ getlname()+" " + getage()+" " + getnum()+" " + getpass()+" ");
        
        File Customer = new File ("C:\\Users\\Mayar\\Desktop");
       FileWriter fw = new FileWriter("C:\\Users\\Mayar\\Desktop\\Customer.txt", true);//true is for the boolean so it could append 
 
        try (PrintWriter out = new PrintWriter(fw)) {
            out.print(info);
            //PrintWriter.println(info.get(age))
        }
       
       
       
        //System.out.println(info.size());
       // System.out.println(info);
    }
    }*/
 /* public void SearchCustomers(){
        String Searchfor;
        in.nextLine();
        Searchfor=in.nextLine();
    if(info.contains(Searchfor))
            System.out.println("tru");
        else 
            System.out.println("false");
       }*/
 /*public void registerCustomer(){
        System.out.println("Enter your first name: ");
        fname = in.nextLine();
        System.out.println("Enter your last name: ");
        lname = in.nextLine();
        System.out.println("Enter your age: ");
        age = in.nextInt();
        in.nextLine();
        System.out.println("Enter your phone number: ");
        phoneNumber = in.nextLine();
        System.out.println("Enter your password in 4 numbers: ");
        pass = in.nextInt();
        
    }*/
 /* public void writeData() throws FileNotFoundException, IOException{
       // File Customer = new File ("C:\\Users\\Mayar\\Desktop");
       FileWriter fw = new FileWriter("C:\\Users\\Mayar\\Desktop\\Customer.txt", true);//true is for the boolean so it could append 
        try (PrintWriter out = new PrintWriter(fw)) {
            out.print(getfname() + " ");
            out.print(getlname() + " ");
            out.print(getnum() + " ");
            out.print(getage()+ " ");
            out.println(getpass());
        }
        finally{
            fw.close();
        }
    }
    public void login() throws FileNotFoundException{
        System.out.println("Enter your phone number to login: ");
        Scanner in = new Scanner (System.in);
        long pn = in.nextLong();
        if(pn == 123456789){
            System.out.println("Please enter your password: ");
            int pa = in.nextInt();
            if(pa==1234){
                System.out.println("Hi, Admin");
            Admin a = new Admin();
            }
            
        }
        else{
            File reader = new File("C:\\Users\\Mayar\\Desktop\\Customer.txt");
             Scanner re = new Scanner(reader);
            while(re.hasNext()){
                String s = re.next();
                //System.out.println(s);
                if(s.equals(pn))
                {
                    System.out.println("Please enter your password: ");
                     int pa = in.nextInt();
                }
            
        }
            /*setnum(pn);
            System.out.println("Enter your pass: ");
             int p = in.nextInt();
             setpass(p);
             FileReader reader = new FileReader("C:\\Users\\Mayar\\Desktop\\Customer.txt");
             Scanner re = new Scanner(reader);
              while(re.hasNext()){
                  int line = in.nexInt();
                  if(line.contains(p)) {
                      System.out.println(line);
                  } else {
                  }
                  
              }
             
        
        
    }
   
    }*/
