import javax.swing.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.sql.*;

public class modify extends JFrame implements ActionListener
{

      JLabel l1,l2,l3,l4,l5;
      JTextField t3,t4,t5;
      JButton b1,b2,b3;
      JComboBox icodes;



public modify()
{

        setLayout(null);
 
        Font f=new Font("Comic Sans MS",Font.BOLD,60);
      
        l1=new JLabel("STOCK UPDATION SCREEN");
        l1.setBounds(450,100,1000,100);
        l1.setFont(f);

        Font p=new Font("Comic Sans MS",Font.BOLD,30);

        icodes=new JComboBox();
        icodes.setBounds(901,300,300,40);

        icodes.addFocusListener(new FocusAdapter()
{       public void focusLost(FocusEvent fe)
{       getDetails();
}
});        
   
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
        

        b1=new JButton("MODIFY/UPDATE");
        b1.setBounds(450,650,300,50);
        b1.setFont(p);
        b1.addActionListener(this);
        b2=new JButton("DELETE");
        b2.setBounds(800,650,200,50);
        b2.setFont(p);
        b2.addActionListener(this);
        b3=new JButton("CANCEL");
        b3.setBounds(1050,650,200,50);
        b3.setFont(p);
        b3.addActionListener(this);
 
     
       
        t3=new JTextField(20);
        t3.setBounds(901,350,300,40);
        t4=new JTextField(20);
        t4.setBounds(901,400,300,40);
        t5=new JTextField(20);
        t5.setBounds(901,450,300,40);
        
        geticode();

        
        add(l1);
        add(l2);
        add(icodes);
        add(l3);
        add(l4);
        add(l5);
        add(t3);
        add(t4);
        add(t5);
       
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
{  try
{

      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      Connection con=DriverManager.getConnection("jdbc:odbc:inventorydsn");
      Statement stmt=con.createStatement(); 
      String query="Update tblstock set iname='"+t3.getText()+"',rate="+t4.getText()+",qoh="+t5.getText()+" where icode="+icodes.getSelectedItem().toString();
      stmt.executeUpdate(query);
      JOptionPane.showMessageDialog(null,"Stock Updated");
      t3.setText("");
      t4.setText("");
      t5.setText("");
     

}

    catch(Exception e)
{
       JOptionPane.showMessageDialog(null,e);
}
       
}


if(ae.getSource()==b2)
{
 try
{     
      

      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      Connection con=DriverManager.getConnection("jdbc:odbc:inventorydsn");
      Statement stmt=con.createStatement(); 
      String query="delete from tblstock where icode="+icodes.getSelectedItem().toString()+" and iname='"+t3.getText()+"' and rate="+t4.getText()+" and qoh="+t5.getText();
      stmt.executeUpdate(query);
      JOptionPane.showMessageDialog(null,"Item Deleted");
      t3.setText("");
      t4.setText("");
      t5.setText("");
}


    catch(Exception e)
{
    JOptionPane.showMessageDialog(null,e);
}


}


}

public void geticode()
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
      icodes.addItem(ic);
}

      if(ic==0)
      JOptionPane.showMessageDialog(null,"No Data Found");
}
    catch(Exception e)
{
    JOptionPane.showMessageDialog(null,e);
}


}

public void getDetails()
{ 
      try
{

      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      Connection con=DriverManager.getConnection("jdbc:odbc:inventorydsn");
      Statement stmt=con.createStatement(); 
      String query="Select * from tblstock where icode="+icodes.getSelectedItem().toString();
      ResultSet rs=stmt.executeQuery(query);
    

       if(rs.next())
{ 
       t3.setText(rs.getString("iname"));
       t4.setText(""+rs.getInt("rate"));
       t5.setText(""+rs.getInt("qoh")); 
}

}
    catch(Exception e)
{
    JOptionPane.showMessageDialog(null,e);
}


}



public static void main(String args[])
{
                        modify j=new modify();
			j.setExtendedState(JFrame.MAXIMIZED_BOTH);
			j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			j.setTitle("STOCK UPDATION SCREEN");
			j.setVisible(true);
                        
}
}