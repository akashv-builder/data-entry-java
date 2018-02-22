import javax.swing.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class itemreciept extends JFrame implements ActionListener
{

      JLabel l1,l2,l3,l4,l5,l6,l7;
      JTextField t2,t3,t4,t5,t6;
      JButton b1,b2,b3;
      JComboBox icodes;
      int day,month,year;

public itemreciept()
{

        setLayout(null);
 
        Font f=new Font("Comic Sans MS",Font.BOLD,60);
      
        l1=new JLabel("ITEM RECIEPT SCREEN");
        l1.setBounds(490,100,800,100);
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
        l6=new JLabel("DOR(DD-MM-YY):");
        l6.setBounds(501,500,300,50);
        l6.setFont(p);
        l7=new JLabel("QUANTITY RECIEVED:");
        l7.setBounds(501,550,350,50);
        l7.setFont(p);

        b1=new JButton("CONFIRM");
        b1.setBounds(601,750,200,50);
        b1.setFont(p);
        b1.addActionListener(this);
        b2=new JButton("CANCEL");
        b2.setBounds(850,750,200,50);
        b2.setFont(p);
        b2.addActionListener(this);
 
        icodes=new JComboBox();
        icodes.setBounds(901,300,300,40);

        icodes.addFocusListener(new FocusAdapter()
{       public void focusLost(FocusEvent fe)
{       getDetails();
}
});        
     
        t2=new JTextField(20);
        t2.setBounds(901,350,300,40);
        t3=new JTextField(20);
        t3.setBounds(901,400,300,40);
        t4=new JTextField(20);
        t4.setBounds(901,450,300,40);
        t5=new JTextField(20);
        t5.setBounds(901,500,300,40);
        GregorianCalendar date=new GregorianCalendar();
        day=date.get(Calendar.DAY_OF_MONTH);
        month=date.get(Calendar.MONTH);
        year=date.get(Calendar.YEAR);
        t5.setText(""+day+"/"+month+"/"+year);

        t6=new JTextField(20);
        t6.setBounds(901,550,300,40);
       
       geticode();


        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(icodes);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(t6);
        add(b1); 
        add(b2);

      
}

   
public void actionPerformed(ActionEvent ae)
{

       if(ae.getSource()==b2)
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
      String query="insert into tblreciept(icode,iname,rate,dor,qr) values ("+icodes.getSelectedItem().toString()+",'"+t2.getText()+"',"+t3.getText()+",'"+t5.getText()+"',"+t6.getText()+")";
      stmt.executeUpdate(query);
      JOptionPane.showMessageDialog(null,"Item Recieved");
      t2.setText("");
      t3.setText("");
      t4.setText("");
      t5.setText("");
      t6.setText("");
      
      
  
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
       t2.setText(rs.getString("iname"));
       t3.setText(""+rs.getInt("rate"));
       t4.setText(""+rs.getInt("qoh")); 
}

}
    catch(Exception e)
{
    JOptionPane.showMessageDialog(null,e);
}


}



public static void main(String args[])
{
                        itemreciept j=new itemreciept();
			j.setExtendedState(JFrame.MAXIMIZED_BOTH);
			j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			j.setTitle("ITEM RECIEPT SCREEN");
			j.setVisible(true);
                        
}
}