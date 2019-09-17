package hms;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import java.*;
class APatient implements ActionListener
{
	JFrame d=new JFrame("Patient Registration");
	JTextField nameField,ageField,diagnosisField,t4,usernameField;
	JPasswordField passwordField1,passwordField2;
	JLabel nameLabel,ageLabel,diagnosisLabel,warningLabel,successLabel,usernameLabel,passwordLabel1,passwordLabel2;
	JButton registerButton,b2,b3;
	int w=1;
	APatient()
	{
		nameLabel=new JLabel("Name");
		ageLabel=new JLabel("Age");
		diagnosisLabel=new JLabel("Diagnosis");
		//warningLabel=new JLabel("All entries must be filled !!!");
		successLabel=new JLabel("");
		nameField=new JTextField();
		ageField=new JTextField();
		diagnosisField=new JTextField();
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
		diagnosisLabel.setBounds(20,80,90,20);
		//warningLabel.setBounds(110,500,100,80);
		nameField.setBounds(105,40,100,20);
		ageField.setBounds(105,60,100,20);
		diagnosisField.setBounds(105,80,100,20);
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
		d.add(diagnosisLabel);
		d.add(ageField);
		d.add(diagnosisField);
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
			
			if(nameField.getText().equals("")||ageField.getText().equals("")||diagnosisField.getText().equals(""))
			{
				successLabel.setText("All fields must be filled");
			}
			else if(w==1)
			{
				if(passwordField1.getText().equals(passwordField2.getText())) {
				Patient pat = new Patient(nameField.getText(),Integer.parseInt(ageField.getText()),usernameField.getText(),passwordField1.getText(),diagnosisField.getText());
				FileIO writer = new FileIO();
				writer.writeToFile(pat, "PatientInfo.txt");
				w=0;
				successLabel.setText("Registration Successfull!!!");
				nameLabel.setText("");
				ageLabel.setText("");
				diagnosisLabel.setText("");
				nameField.setVisible(false);
				ageField.setVisible(false);
				diagnosisField.setVisible(false);
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
public class PatientRegist 
{
	public static void main(String args[])
    {
        APatient ap=new APatient();
    }
}
