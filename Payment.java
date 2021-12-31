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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
/**
 *
 * @author Marina
 */
public class Payment {
    
private double amount;
    private String Ways_Of_Payment;
    Scanner in = new Scanner(System.in);

    private Payment(ButtonModel selection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public double getAmount()
    {
        return amount;
    }
    public void setAmount(double amount)
    {
        this.amount=amount;
    }
    public void setway(String way)
    {
        this.Ways_Of_Payment=way;
    }
    public String getway()
    {
        return Ways_Of_Payment;
    }
     static class PaymentWindow extends JFrame implements ActionListener {

        static JFrame window;

        public static void open() throws IOException, FileNotFoundException, ClassNotFoundException {
            window = new PaymentWindow();
        }
         JLabel PaymentMethod= new JLabel("Payment Method");
         JRadioButton Visa =new JRadioButton("Visa");
         JRadioButton Cash =new JRadioButton("Cash");
         ButtonGroup choice=new ButtonGroup();
         JButton pay=new JButton("Pay");
        public PaymentWindow(){
            GridLayout grid = new GridLayout(3, 2, 10, 10);  //3izeen nghyar el grid
            setLayout(grid);

            add(PaymentMethod);
            add(Visa);
            add(Cash);
            choice.add(Visa);
            choice.add(Cash);
            add(pay);
            
            pay.addActionListener(this);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(800, 400);
            setVisible(true);
           
            // this.info = new ArrayList();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(pay)) {
                Database.Payment = new ArrayList<>();
                try {
                    Database.save();
                } catch (IOException ex) {
                    Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
                }
                Payment newPayment;
                newPayment = new Payment(choice.getSelection());

                try {
                    Database.save();
                } catch (IOException ex) {
                    Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
                
               /* window.setVisible(false);
                Routes r = new Routes();
                r.setVisible(true);*/
            
        }
        }

  /*  public void way() throws ParseException{
        System.out.println("Enter your way of payment: ");
        Ways_Of_Payment = in.nextLine();
        if(Ways_Of_Payment.equalsIgnoreCase("cash")){
            Cash c$  = new Cash();
              c$.pay(amount);
        }
       else if(Ways_Of_Payment.equalsIgnoreCase("visa")){
            Visa v = new Visa();
            v.info();
        }
        else 
           System.out.println("you should enter a way");
        
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); *///To change body of generated methods, choose Tools | Templates.
    }
    
}

