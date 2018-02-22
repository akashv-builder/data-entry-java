import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.sql.*;


public class createuser extends JFrame implements ActionListener
{       

        JLabel l1,l2,l3,l4;

        JTextField t1;
      
        JPasswordField t2;
 
        ImageIcon i;

        JButton b1,b2,b3;

        Font f,f1;

        public createuser()
{

        setLayout(null);

        f=new Font("Comic Mans MS",Font.BOLD,30);  
        f1=new Font("Comic Mans MS",Font.BOLD,80);        

        l1=new JLabel("ENTER A USERNAME:");
        l1.setFont(f);
        l1.setBounds(600,300,500,50);
        l1.setForeground(Color.yellow);

        l2=new JLabel("CHOSSE PASSWORD:");
        l2.setFont(f);
        l2.setBounds(600,500,500,50);
        l2.setForeground(Color.yellow);

        l4=new JLabel("NEW USER");
        l4.setFont(f1);
        l4.setBounds(740,50,500,100);
        l4.setForeground(Color.red);


        t1=new JTextField(20);
        t1.setBounds(1000,300,300,50);

        t2=new JPasswordField(20);
        t2.setBounds(1000,500,300,50);

        b1=new JButton("CONFIRM");
        b1.setFont(f);
        b1.setBounds(650,700,200,50);
        b1.addActionListener(this);

        b2=new JButton("CLEAR");
        b2.setFont(f);
        b2.setBounds(860,700,200,50);
        b2.addActionListener(this);

        b3=new JButton("CANCEL");
        b3.setFont(f);
        b3.setBounds(1070,700,200,50);
        b3.addActionListener(this);

        i=new ImageIcon("3.jpg");
        l3=new JLabel(i);
        l3.setBounds(0,0,1900,952);


        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l4);
        add(b1);
        add(b2);
        add(b3);
        add(l3);
}

       public void actionPerformed(ActionEvent ae) 

{

        if(ae.getSource()==b1)

{
    
       
      try
{

      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      Connection con=DriverManager.getConnection("jdbc:odbc:inventorydsn");
      Statement stmt=con.createStatement(); 
      String query="insert into tbllogin(username,password) values ('"+t1.getText()+"','"+t2.getText()+"')";
      stmt.executeUpdate(query);
      JOptionPane.showMessageDialog(null,"User Registered");
      
       t1.setText("");
       t2.setText("");
}

    catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
}

}  
      if(ae.getSource()==b2)
{
 
       t1.setText("");
       t2.setText("");
     
       t1.requestFocus();


}

      if(ae.getSource()==b3)
{
this.dispose();

         login s=new login();
         s.setSize(2000,2000);
         s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         s.setVisible(true);
         s.setExtendedState(JFrame.MAXIMIZED_BOTH);
         s.setTitle("LOGIN SCREEN");
         

}
       
}


public static void main(String args[])

{

         createuser s=new createuser();
         s.setSize(2000,2000);
         s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         s.setVisible(true);
         s.setExtendedState(JFrame.MAXIMIZED_BOTH);
         s.setTitle("NEW USER");
        

}
}       


  

      