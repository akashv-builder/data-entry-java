import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.sql.*;


public class changepass extends JFrame implements ActionListener
{       

        JLabel newuser,username,currentpass,newpass,confirmnewpass,background;

        JTextField usernametxt;
      
        JPasswordField currentpasstxt,newpasstxt,confirmnewpasstxt;
 
        ImageIcon i;

        JButton confirm,clear,cancel;

        Font f,f1;

        public changepass()
{

        setLayout(null);

        f=new Font("Comic Mans MS",Font.BOLD,30);  
        f1=new Font("Comic Mans MS",Font.BOLD,80);        

        newuser=new JLabel("CHANGE PASSWORD");
        newuser.setFont(f1);
        newuser.setBounds(500,30,900,100);
        newuser.setForeground(Color.yellow);

        username=new JLabel("ENTER YOUR USERNAME:");
        username.setFont(f);
        username.setBounds(550,300,500,50);
        username.setForeground(Color.yellow);

        currentpass=new JLabel("CURRENT PASSWORD:");
        currentpass.setFont(f);
        currentpass.setBounds(550,400,500,50);
        currentpass.setForeground(Color.yellow);

        newpass=new JLabel("NEW PASSWORD:");
        newpass.setFont(f);
        newpass.setBounds(550,500,500,50);
        newpass.setForeground(Color.yellow);

        confirmnewpass=new JLabel("CONFIRM NEW PASSWORD:");
        confirmnewpass.setFont(f);
        confirmnewpass.setBounds(550,600,500,50);
        confirmnewpass.setForeground(Color.yellow);

        usernametxt=new JTextField(20);
        usernametxt.setBounds(1000,300,300,50);

        currentpasstxt=new JPasswordField(20);
        currentpasstxt.setBounds(1000,400,300,50);

        newpasstxt=new JPasswordField(20);
        newpasstxt.setBounds(1000,500,300,50);
 
        confirmnewpasstxt=new JPasswordField(20);
        confirmnewpasstxt.setBounds(1000,600,300,50);


        confirm=new JButton("CONFIRM");
        confirm.setFont(f);
        confirm.setBounds(600,800,200,50);
        confirm.addActionListener(this);

        clear=new JButton("CLEAR");
        clear.setFont(f);
        clear.setBounds(810,800,200,50);
        clear.addActionListener(this);

        cancel=new JButton("CANCEL");
        cancel.setFont(f);
        cancel.setBounds(1020,800,200,50);
        cancel.addActionListener(this);

        i=new ImageIcon("5.jpg");
        background=new JLabel(i);
        background.setBounds(0,0,1900,952);


        add(newuser); 
        add(username);
        add(usernametxt);
        add(currentpass);
        add(currentpasstxt);
        add(newpass);
        add(newpasstxt);
        add(confirmnewpass);
        add(confirmnewpasstxt);
     
        add(confirm);
        add(clear);
        add(cancel);
        
        add(background);
}

       public void actionPerformed(ActionEvent ae) 

{    

      if(ae.getSource()==confirm)

{      String s1=newpasstxt.getText();
       String s2=confirmnewpasstxt.getText();
       if(s1.equals(s2))
{

       try
{

      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      Connection con=DriverManager.getConnection("jdbc:odbc:inventorydsn");
      Statement stmt=con.createStatement(); 
      String query="update tbllogin set password='"+s2+"' where username='"+usernametxt.getText()+"'";
      stmt.executeUpdate(query);
      JOptionPane.showMessageDialog(null,"Password Changed");
      JOptionPane.showMessageDialog(null,"You have been logged out,Login again with new password");
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
}      
       
        
      if(ae.getSource()==clear)
{
 
      usernametxt.setText("");
      currentpasstxt.setText("");
      newpasstxt.setText("");
      confirmnewpasstxt.setText("");
     
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

         changepass s=new changepass();
         s.setSize(2000,2000);
         s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         s.setVisible(true);
         s.setExtendedState(JFrame.MAXIMIZED_BOTH);
         s.setTitle("NEW USER");
        

}
}       


  

      