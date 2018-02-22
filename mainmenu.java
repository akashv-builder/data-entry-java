import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;

public class mainmenu extends JFrame implements ActionListener
{                     

                      JMenuBar mbar;
                      JMenu m1,m2,m3,m4,m5;
                      JMenuItem i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12;

                      public mainmenu()

{
                      Font f=new Font("Cooper Black",Font.PLAIN,50);
                      

                      mbar=new JMenuBar();
                      setJMenuBar(mbar);

                      m1=new JMenu("       STOCK       ");
                      mbar.add(m1);
                      m1.setFont(f);

                      m1.setMnemonic('s');

                      i1=new JMenuItem("ADD ITEM",'a');
                      i1.addActionListener(this);
                      i1.setFont(f);

                      m1.add(i1);

                      i2=new JMenuItem("MODIFY/DELETE",'m');
                      i2.addActionListener(this);
                      i2.setFont(f);
                      m1.add(i2);
 
                      m1.addSeparator();

                      i3=new JMenuItem("SHOW STOCK");
                      i3.addActionListener(this);
                      i3.setFont(f);
                      m1.add(i3);

                      m2=new JMenu("    TRANSACTION       ");
                      mbar.add(m2);
                      m2.setFont(f);

              
                      i4=new JMenuItem("SALE",'s');
                      i4.addActionListener(this);
                      i4.setFont(f);

                      m2.add(i4);
 
                      m2.addSeparator();

                      i5=new JMenuItem("PURCHASE",'p');
                      i5.addActionListener(this);
                      i5.setFont(f);
                      m2.add(i5);

                      m3=new JMenu("       REPORTS       ");
                      mbar.add(m3);
                      m3.setFont(f);

 
                      i6=new JMenuItem("ALL ITEM");
                      i6.addActionListener(this);
                      i6.setFont(f);
                      m3.add(i6);
 
                      i7=new JMenuItem("ALL ISSUE");
                      i7.addActionListener(this);
                      i7.setFont(f);
                      m3.add(i7);


                      i8=new JMenuItem("ALL RECIEVED");
                      i8.addActionListener(this);
                      i8.setFont(f);
                      m3.add(i8);

                      m4=new JMenu("       USER      ");
                      mbar.add(m4);
                      m4.setFont(f);


                      i9=new JMenuItem("CHANGE PASSWORD",'c');
                      i9.addActionListener(this);
                      i9.setFont(f);
                      m4.add(i9);
 
                      i11=new JMenuItem("DELETE USER",'c');
                      i11.addActionListener(this);
                      i11.setFont(f);
                      m4.add(i11);

                      m5=new JMenu("       EXIT       ");
                      mbar.add(m5);
                      m5.setFont(f);


                      i12=new JMenuItem("SIGN OUT",'s');
                      i12.addActionListener(this);
                      i12.setFont(f);
                      m5.add(i12);
   
                      i10=new JMenuItem("CLOSE PROGRAM",'c');
                      i10.addActionListener(this);
                      i10.setFont(f);
                      m5.add(i10);



                    
                      

}

                      public void actionPerformed(ActionEvent ae)

{                     if(ae.getSource()==i1)

{                       dataentry j=new dataentry();
			j.setExtendedState(JFrame.MAXIMIZED_BOTH);
			j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			j.setTitle("DATA ENTRY SCREEN");
			j.setVisible(true);
                        this.dispose();

}

                     if(ae.getSource()==i2)
{
                        modify j=new modify();
			j.setExtendedState(JFrame.MAXIMIZED_BOTH);
			j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			j.setTitle("ITEM UPDATE SCREEN");
			j.setVisible(true);
                        this.dispose();

}
     
                     if(ae.getSource()==i4)
{                      
                      
                       itemissue j=new itemissue();
			j.setExtendedState(JFrame.MAXIMIZED_BOTH);
			j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			j.setTitle("ITEM ISSUE SCREEN");
			j.setVisible(true);
                        this.dispose();
}

                     if(ae.getSource()==i5)

{                       itemreciept j=new itemreciept();
			j.setExtendedState(JFrame.MAXIMIZED_BOTH);
			j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			j.setTitle("ITEM RECIEPT SCREEN");
			j.setVisible(true);
                        this.dispose();
}

                       if(ae.getSource()==i9)

{                       changepass j=new changepass();
			j.setExtendedState(JFrame.MAXIMIZED_BOTH);
			j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			j.setTitle("ITEM RECIEPT SCREEN");
			j.setVisible(true);
                        this.dispose();
}


                       if(ae.getSource()==i11)

{                       deleteuser j=new deleteuser();
			j.setExtendedState(JFrame.MAXIMIZED_BOTH);
			j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			j.setTitle("ITEM RECIEPT SCREEN");
			j.setVisible(true);
                        this.dispose();
}                      
                        if(ae.getSource()==i10)

{                       System.exit(0);
}

                       if(ae.getSource()==i12)

{                       login j=new login();
			j.setExtendedState(JFrame.MAXIMIZED_BOTH);
			j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			j.setTitle("LOGIN SCREEN");
			j.setVisible(true);
                        this.dispose();
}


}
                      public static void main(String args[])
{                   
                      mainmenu m=new mainmenu();
                     // m.setSize(2000,1000);				
		      m.setVisible(true);
                      m.setTitle("MAIN SCREEN");
                      m.setExtendedState(JFrame.MAXIMIZED_BOTH);
}
}

                      