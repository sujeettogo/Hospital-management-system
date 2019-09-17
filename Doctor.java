package project;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
class AWTDoctor implements ActionListener
{
	JFrame d=new JFrame("Welcome Doctor");
	JTextField t1,t2;
	JLabel l;
	JButton b1,b2,b3;
	AWTDoctor()
	{
		l=new JLabel("Specialized in:");
		t1=new JTextField();
		b1=new JButton("Patients");
		l.setBounds(20,40,300,15);
		t1.setBounds(40,80,500,80);
		b1.setBounds(110,240,100,80);
		d.add(t1);
		d.add(l);
		d.add(b1);
		b1.addActionListener(this);
		d.setLayout(null);
		d.setVisible(true);
		d.setSize(800,500);
		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		t1.setText(" ");
		if(e.getSource()==b1)
		t1.setText(t1.getText().concat("Patients:"));
	}
}
public class Doctor {
	public static void main(String args[])
    {
        AWTDoctor a=new AWTDoctor();
    }
}
