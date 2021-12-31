/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.AccessibleContext;
import static project.Database.save;
import project.Payment.PaymentWindow;

/**
 *
 * @author Marina
 */
        public class Routes extends JFrame implements Serializable {

   

    Routes() {
     
    }

    private Routes(AccessibleContext accessibleContext, AccessibleContext accessibleContext0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    void setRoute(String nextLine) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    
    static class RouteWindow extends JFrame implements ActionListener {

        static JFrame window;

        public static void open() throws IOException, FileNotFoundException, ClassNotFoundException {
            window = new RouteWindow();
        }
         JLabel PickUpPoint= new JLabel("Pick Up Point");
         JComboBox combobox1=new JComboBox((new String[] {"Misr Elgdida","Nasr City","Sheraton","Maadi","Obour","Zamalek","El Shrouk","El Rehab","Tagamoaa"}));
         JLabel Destination= new JLabel("Destination");
         JComboBox combobox2=new JComboBox((new String[] {"Misr Elgdida","Nasr City","Sheraton","Maadi","Obour","Zamalek","El Shrouk","El Rehab","Tagamoaa"}));
          JButton Next = new JButton("Next");
        public RouteWindow(){
            GridLayout grid = new GridLayout(3, 2, 10, 10);  //3izeen nghyar el grid
            setLayout(grid);

            add(PickUpPoint);
            add(combobox1);
            add(Destination);
            add(combobox2);
            add(Next);
            Next.addActionListener(this);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(800, 400);
            setVisible(true);
           
            // this.info = new ArrayList();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(Next)) {
                Database.routes = new ArrayList<>();
                try {
                    Database.save();
                } catch (IOException ex) {
                    Logger.getLogger(Routes.class.getName()).log(Level.SEVERE, null, ex);
                }
                Routes newRoutes;
                newRoutes = new Routes(combobox1.getAccessibleContext(),combobox2.getAccessibleContext());

                try {
                    Database.save();
                } catch (IOException ex) {
                    Logger.getLogger(Routes.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
                
                window.setVisible(false);
                PaymentWindow p = new PaymentWindow();
                p.setVisible(true);
            }
        }
        }
/*public class Routes extends JFrame implements Serializable {

    private String Route;
    

    //private String CurrentLoction;
    static class Display extends JFrame implements ActionListener
            
    { static JFrame window2;
        public static void openn()
    {
       window2 = new Routes();
    }
         
       
        
        JLabel PickUpPoint= new JLabel("Pick Up Point");
        JComboBox combobox=new JComboBox((new String[] {"Misr Elgdida","Nasr City","Sheraton","Maadi","Obour","Zamalek","El Shrouk","El Rehab","Tagamoaa"}));
        JButton ok=new JButton("ok");
        
        public Display(){
             GridLayout grid = new GridLayout(7, 2, 10, 10);
            setLayout(grid);
       
       
        add(PickUpPoint);
        add(combobox);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(ok);
        setSize(800, 400);
        setVisible(true);
            }
        @Override
        public void actionPerformed(ActionEvent e) {
 if (e.getSource().equals(ok)) {
     window2.setVisible(false);
                Payment p = new Payment();
                p.setVisible(true);
 }
        }
    
    }
    public void setRoute(String Route) {
        this.Route = Route;
    }

    public String getRoute() {
        return Route;
    }
*/
    

    /* public void AddRoute() throws FileNotFoundException, IOException {
        
        System.out.println("Please enter the route you wish to add in this format (pickup point-dropping point)");
        Route = in.nextLine();
        //routes.add(Route);//in.nextLine 3ashan yakhod with the space kman

        FileWriter fw = new FileWriter("Routes.txt", true);//true is for the boolean so it could append 
        try (PrintWriter out = new PrintWriter(fw)) {
            System.out.println(System.lineSeparator());
            out.print(Route + System.lineSeparator());

        } finally {
            fw.close();//mafesh line geded-size leeh zero?
        }
    }*/
}
