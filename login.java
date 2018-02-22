import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.sql.*;

public class login extends JFrame implements ActionListener
{       

        JLabel l1,l2,l3,l4;

        JTextField t1;
      
        JPasswordField t2;
 
        ImageIcon i;

        JButton b1,b2;

        Font f,f1;

        public login()
{

        setLayout(null);

        f=new Font("Comic Mans MS",Font.BOLD,30);  
        f1=new Font("Comic Mans MS",Font.BOLD,80);        

        l1=new JLabel("USERNAME:");
        l1.setFont(f);
        l1.setBounds(600,300,500,50);
        l1.setForeground(Color.yellow);

        l2=new JLabel("PASSWORD:");
        l2.setFont(f);
        l2.setBounds(600,500,500,50);
        l2.setForeground(Color.yellow);

        l4=new JLabel("LOGIN");
        l4.setFont(f1);
        l4.setBounds(760,50,500,100);
        l4.setForeground(Color.red);


        t1=new JTextField(20);
        t1.setBounds(900,300,300,50);

        t2=new JPasswordField(20);
        t2.setBounds(900,500,300,50);

        b1=new JButton("LOGIN");
        b1.setFont(f);
        b1.setBounds(600,700,200,50);
        b1.addActionListener(this);

        b2=new JButton("CREATE USER");
        b2.setFont(f);
        b2.setBounds(900,700,300,50);
        b2.addActionListener(this);


        i=new ImageIcon("4.jpg");
        l3=new JLabel(i);
        l3.setBounds(0,0,1900,952);


        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l4);
        add(b1);
        add(b2);
        add(l3);
}

       public void actionPerformed(ActionEvent ae) 

{

        if(ae.getSource()==b1)

{
       

       String s1,s2;

       s1=t1.getText();
       s2=t2.getText();

       int i,j;
       
       i=s1.length();

       j=s2.length();

       
       if(i==0 || j==0)
{
       JOptionPane.showMessageDialog(null,"LOGIN UNSUCESSFULL,TEXT FEILDS CANT BE EMPTY!");

       t1.requestFocus();
}
       else
      
{        try
{

      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      Connection con=DriverManager.getConnection("jdbc:odbc:inventorydsn");
      Statement stmt=con.createStatement(); 
      String query="Select * from tbllogin where username='"+t1.getText()+"' and password='"+t2.getText()+"'";
      ResultSet rs=stmt.executeQuery(query);
      int ctr=0;
      while(rs.next())
{     ctr++;
}

     if(ctr==0)
     JOptionPane.showMessageDialog(null,"LOGIN UNSUCESSFULL,NO SUCH USER REGISTERD");

     else
{    JOptionPane.showMessageDialog(null,"LOGIN SUCESSFULL");
     mainmenu r=new mainmenu();
     r.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     r.setSize(2000,2000);
     r.setVisible(true); 
     r.setExtendedState(JFrame.MAXIMIZED_BOTH);
     r.setTitle("Main Screen");
     this.dispose();

}


}
    
    catch(Exception e)
{
    JOptionPane.showMessageDialog(null,e);
}

}  
      
        if(ae.getSource()==b2)
{
         createuser s=new createuser();
         s.setSize(2000,2000);
         s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         s.setVisible(true);
         s.setExtendedState(JFrame.MAXIMIZED_BOTH);
         s.setTitle("NEW USER");
         this.dispose();
       
}
         
}
}


public static void main(String args[])

{

         login s=new login();
         s.setSize(2000,2000);
         s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         s.setVisible(true);
         s.setExtendedState(JFrame.MAXIMIZED_BOTH);
         s.setTitle("LOGIN SCREEN");
        

}
}       


  

      