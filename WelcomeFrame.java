package hms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class WelcomeFrame extends JFrame {
	public WelcomeFrame() {
	setTitle("Hospital Management System");
	Choice user = new Choice();
	user.add("Doctor");
	user.add("Patient");
	JButton registerButton = new JButton("Register");
	JButton loginButton = new JButton("Login");
	loginButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			String str = user.getItem(user.getSelectedIndex());
			new LoginFrame(str);
			dispose();
		}
	});
	registerButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			String str = user.getItem(user.getSelectedIndex());
			if(str.equals("Doctor")) {
				new ADoctor();
				dispose();
			}
			else {
				new APatient();
				dispose();
			}
		}
	});
	setLayout(new FlowLayout());
	setSize(300,500);
	add(user);
	add(registerButton);
	add(loginButton);
	setVisible(true);
	}
	public static void main(String[] args) {
		new WelcomeFrame();
	}
}

class LoginFrame extends JFrame {
	String filename;
	public LoginFrame(String str) {
		setSize(300,500);
		setTitle("Login");
		setLayout(new FlowLayout());
		filename = str + "Info.txt";
		JLabel userNameLabel = new JLabel("Username",JLabel.LEFT);
		JLabel displayLabel = new JLabel();
		JLabel warningLabel = new JLabel();
		warningLabel.setBounds(50,400,200,200);
		JTextField userNameField = new JTextField(20);
		JLabel passwordLabel = new JLabel("Password",JLabel.LEFT);
		JPasswordField passwordField = new JPasswordField(20);
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Doctor doc;
				Patient pt;
				FileIO reader = new FileIO();
				if(str.equals("Doctor")) {
					doc = (Doctor) reader.readFromFile("DoctorInfo.txt");
					while(doc != null) {
						doc = (Doctor)reader.readFromFile("DoctorInfo.txt");
						if(userNameField.getText().equals(doc.getUser_id()) && passwordField.getText().equals(doc.getPwd())) {
							new DoctorDet(doc);
							dispose();
							break;
						}
						else {
							dispose();
						}
						doc = (Doctor) reader.readFromFile("DoctorInfo.txt");
					}
				}
				if(str.equals("Patient")) {
					pt = (Patient) reader.readFromFile("PatientInfo.txt");
					while(pt != null) {
						pt = (Patient)reader.readFromFile("PatientInfo.txt");
						if(userNameField.getText().equals(pt.getUser_id()) && passwordField.getText().equals(pt.getPwd())) {
							new PatientDet(pt);
							dispose();
							break;
						} else {
							dispose();
							warningLabel.setText("Incorrect Password!");
						}
						pt = (Patient) reader.readFromFile("PatientInfo.txt");
					}
				}
			}
		});
		add(userNameLabel);
		add(userNameField);
		add(passwordLabel);
		add(passwordField);
		add(loginButton);
		add(displayLabel);
		add(warningLabel);
		setVisible(true);
	}
}
