package hms;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import java.*;
class ADoctor implements ActionListener
{
	JFrame d=new JFrame("Doctor Registration");
	JTextField nameField,ageField,specializationField,t4,usernameField;
	JPasswordField passwordField1,passwordField2;
	JLabel nameLabel,ageLabel,speciaizationLabel,warningLabel,successLabel,usernameLabel,passwordLabel1,passwordLabel2;
	JButton registerButton,b2,b3;
	int w=1;
	ADoctor()
	{
		nameLabel=new JLabel("Name");
		ageLabel=new JLabel("Age");
		speciaizationLabel=new JLabel("Specialization");
		//warningLabel=new JLabel("All entries must be filled !!!");
		successLabel=new JLabel("");
		nameField=new JTextField();
		ageField=new JTextField();
		specializationField=new JTextField();
		t4=new JTextField();
		usernameField = new JTextField();
		passwordField1 = new JPasswordField();
		passwordField2 = new JPasswordField();
		usernameLabel = new JLabel("Username");
		passwordLabel1 = new JLabel("Enter password : ");
		passwordLabel2 = new JLabel("Enter password again : ");
		registerButton=new JButton("Register");
		nameLabel.setBounds(20,40,80,20);
		ageLabel.setBounds(20,60,80,20);
		speciaizationLabel.setBounds(20,80,90,20);
		//warningLabel.setBounds(110,500,100,80);
		nameField.setBounds(105,40,100,20);
		ageField.setBounds(105,60,100,20);
		specializationField.setBounds(105,80,100,20);
		usernameLabel.setBounds(20,120,90,20);
		usernameField.setBounds(105,120,100,20);
		passwordLabel1.setBounds(20,140,120,20);
		passwordField1.setBounds(135,140,100,20);
		passwordLabel2.setBounds(20,160,160,20);
		passwordField2.setBounds(165,160,100,20);
		successLabel.setBounds(105,330,200,30);
		registerButton.setBounds(110,240,100,80);
		d.add(nameField);
		d.add(nameLabel);
		d.add(registerButton);
		d.add(ageLabel);
		d.add(speciaizationLabel);
		d.add(ageField);
		d.add(specializationField);
		d.add(usernameLabel);
		d.add(usernameField);
		d.add(passwordField1);
		d.add(passwordField2);
		d.add(passwordLabel1);
		d.add(passwordLabel2);
		d.add(successLabel);
		registerButton.addActionListener(this);
		d.setLayout(null);
		d.setVisible(true);
		d.setSize(600,500);
		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if((e.getSource()==registerButton)&&w==1)
		{
			
			if(nameField.getText().equals("")||ageField.getText().equals("")||specializationField.getText().equals(""))
			{
				successLabel.setText("All fields must be filled");
			}
			else if(w==1)
			{
				if(passwordField1.getText().equals(passwordField2.getText())) {
				Doctor doc = new Doctor(nameField.getText(),Integer.parseInt(ageField.getText()),specializationField.getText(),usernameField.getText(),passwordField1.getText());
				FileIO writer = new FileIO();
				writer.writeToFile(doc, "DoctorInfo.txt");
				w=0;
				successLabel.setText("Registration Successfull!!!");
				nameLabel.setText("");
				ageLabel.setText("");
				speciaizationLabel.setText("");
				nameField.setVisible(false);
				ageField.setVisible(false);
				specializationField.setVisible(false);
				registerButton.setText("Continue");
				}
			}
		}
			else if((e.getSource()==registerButton)&&w==0)
			{
				new WelcomeFrame();
				d.dispose();
			}
	}
}
public class DoctorRegist 
{
	public static void main(String args[])
    {
        ADoctor ap=new ADoctor();
    }
}
