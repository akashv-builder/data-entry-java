import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.sql.*;


public class deleteuser extends JFrame implements ActionListener
{       

        JLabel deleteuser,username,currentpass,background;

        JTextField usernametxt;
      
        JPasswordField currentpasstxt;
 
        ImageIcon i;

        JButton confirm,clear,cancel;

        Font f,f1;

        public deleteuser()
{

        setLayout(null);

        f=new Font("Comic Mans MS",Font.BOLD,30);  
        f1=new Font("Comic Mans MS",Font.BOLD,80);        

        deleteuser=new JLabel("DELETE USER");
        deleteuser.setFont(f1);
        deleteuser.setBounds(650,30,800,100);
        deleteuser.setForeground(Color.blue);

        username=new JLabel("USERNAME:");
        username.setFont(f);
        username.setBounds(650,300,500,50);
        username.setForeground(Color.blue);

        currentpass=new JLabel("PASSWORD:");
        currentpass.setFont(f);
        currentpass.setBounds(650,400,500,50);
        currentpass.setForeground(Color.blue);

        usernametxt=new JTextField(20);
        usernametxt.setBounds(900,300,300,50);

        currentpasstxt=new JPasswordField(20);
        currentpasstxt.setBounds(900,400,300,50);

       
        confirm=new JButton("CONFIRM");
        confirm.setFont(f);
        confirm.setBounds(620,600,200,50);
        confirm.addActionListener(this);

        clear=new JButton("CLEAR");
        clear.setFont(f);
        clear.setBounds(830,600,200,50);
        clear.addActionListener(this);

        cancel=new JButton("CANCEL");
        cancel.setFont(f);
        cancel.setBounds(1040,600,200,50);
        cancel.addActionListener(this);

        i=new ImageIcon("6.jpg");
        background=new JLabel(i);
        background.setBounds(0,0,1900,952);


        add(deleteuser); 
        add(username);
        add(usernametxt);
        add(currentpass);
        add(currentpasstxt);
        add(confirm);
        add(clear);
        add(cancel);
        add(background);
}

       public void actionPerformed(ActionEvent ae) 

{

      if(ae.getSource()==confirm)

{    

      try
{     
      

      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      Connection con=DriverManager.getConnection("jdbc:odbc:inventorydsn");
      Statement stmt=con.createStatement(); 
      String query="delete from tbllogin where username='"+usernametxt.getText()+"' and password='"+currentpasstxt.getText()+"'";
      stmt.executeUpdate(query);
      JOptionPane.showMessageDialog(null,"User Deleted");
      JOptionPane.showMessageDialog(null,"You have been logged out");
       login s=new login();
         s.setSize(2000,2000);
         s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         s.setVisible(true);
         s.setExtendedState(JFrame.MAXIMIZED_BOTH);
         s.setTitle("LOGIN SCREEN");
         this.dispose();
}


    catch(Exception e)
{
    JOptionPane.showMessageDialog(null,e);
}
       
}
      
       
        
      if(ae.getSource()==clear)
{
 
      usernametxt.setText("");
      currentpasstxt.setText("");
     
      usernametxt.requestFocus();
}



      if(ae.getSource()==cancel)
{

         mainmenu s=new mainmenu();
         s.setSize(2000,2000);
         s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         s.setVisible(true);
         s.setExtendedState(JFrame.MAXIMIZED_BOTH);
         s.setTitle("LOGIN SCREEN");
         this.dispose();

}
       
}


public static void main(String args[])

{

         deleteuser s=new deleteuser();
         s.setSize(2000,2000);
         s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         s.setVisible(true);
         s.setExtendedState(JFrame.MAXIMIZED_BOTH);
         s.setTitle("NEW USER");
        

}
}       


  

      