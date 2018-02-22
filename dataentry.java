import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class dataentry extends JFrame implements ActionListener
{

      JLabel l1,l2,l3,l4,l5,l6,l7;
      JTextField t1,t2,t3,t4;
      JButton b1,b2,b3;

public dataentry()
{

        setLayout(null);
 
        Font f=new Font("Comic Sans MS",Font.BOLD,60);
      
        l1=new JLabel("DATA ENTRY SCREEN");
        l1.setBounds(510,100,800,100);
        l1.setFont(f);

        Font p=new Font("Comic Sans MS",Font.BOLD,30);


        l2=new JLabel("ITEM CODE:");
        l2.setBounds(501,300,300,50);
        l2.setFont(p);
 	l3=new JLabel("ITEM NAME:");
        l3.setBounds(501,350,300,50);
        l3.setFont(p);
	l4=new JLabel("RATE:");
        l4.setBounds(501,400,300,50);
        l4.setFont(p);
	l5=new JLabel("QOH:");
        l5.setBounds(501,450,300,50);
        l5.setFont(p);
        

        b1=new JButton("INSERT/SAVE");
        b1.setBounds(425,650,300,50);
        b1.setFont(p);
        b1.addActionListener(this);
        b2=new JButton("NEXT RECORD/ITEM");
        b2.setBounds(750,650,380,50);
        b2.setFont(p);
        b2.addActionListener(this);
        b3=new JButton("EXIT");
        b3.setBounds(1150,650,200,50);
        b3.setFont(p);
        b3.addActionListener(this);
 
        t1=new JTextField(20);
        t1.setBounds(901,300,300,40);
        t1.setEditable(false);
        t2=new JTextField(20);
        t2.setBounds(901,350,300,40);
        t3=new JTextField(20);
        t3.setBounds(901,400,300,40);
        t4=new JTextField(20);
        t4.setBounds(901,450,300,40);
     
        generateicode();

        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
       
        add(t1);
        add(t2);
        add(t3);
        add(t4);
   
       
        add(b1); 
        add(b2);
        add(b3);

      
}

   
public void actionPerformed(ActionEvent ae)
{

 if(ae.getSource()==b3)
{

                        mainmenu j=new mainmenu();
			j.setExtendedState(JFrame.MAXIMIZED_BOTH);
			j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			j.setTitle("MAIN SCREEN");
			j.setVisible(true);
                        this.dispose();

}

if(ae.getSource()==b1)

{
     
      try
{

      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      Connection con=DriverManager.getConnection("jdbc:odbc:inventorydsn");
      Statement stmt=con.createStatement(); 
      String query="insert into tblstock(iname,rate,qoh) values ('"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"')";
      stmt.executeUpdate(query);
      JOptionPane.showMessageDialog(null,"Item Registered");
      t2.setText("");   
      t3.setText("");   
      t4.setText("");     
      
}

    catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
}




}

if(ae.getSource()==b2)
{     
generateicode();

}

}

public void generateicode()
{
 try
{

      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      Connection con=DriverManager.getConnection("jdbc:odbc:inventorydsn");
      Statement stmt=con.createStatement(); 
      String query="Select icode from tblstock";
      ResultSet rs=stmt.executeQuery(query);
      int ic=0;
      while(rs.next())
{     ic=rs.getInt("icode");
}
      if(ic==0)
      ic=1;
      else
      ic=ic+1;
      t1.setText(""+ic);      
}

    catch(Exception e)
{
    JOptionPane.showMessageDialog(null,e);
}

}

public static void main(String args[])
{
                        dataentry j=new dataentry();
			j.setExtendedState(JFrame.MAXIMIZED_BOTH);
			j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			j.setTitle("DATA ENTRY SCREEN");
			j.setVisible(true);
                        
}
}