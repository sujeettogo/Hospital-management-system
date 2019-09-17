package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class WelcomeFrame extends JFrame {
	public WelcomeFrame() {
	setTitle("Hospital Management System");
	//Patient Registration and Doctor Registration should be separate Options ? (Drop Down List for patient/Doctor)
	//Patient Registration can have Patient ID,Blah Blah,Sickness Blah Blah
	JButton registerButton = new JButton("Register");
	JButton loginButton = new JButton("Login");
	loginButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			new LoginFrame();
		}
	});
	registerButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			new RegisterFrame();
		}
	});
	setLayout(new FlowLayout());
	setSize(300,500);
	add(registerButton);
	add(loginButton);
	setVisible(true);
	}
}
class RegisterFrame extends JFrame {
	public RegisterFrame() {
		setSize(300,500);
		setTitle("Register");
		setLayout(new FlowLayout());
		JLabel userNameLabel = new JLabel("Enter your username : ");
		JLabel passwordLabel1 = new JLabel("Enter your password : ");
		JLabel passwordLabel2 = new JLabel("Enter your password again : ");
		JLabel warningLabel = new JLabel();
		JTextField userNameField = new JTextField(20);
		JPasswordField passwordField1 = new JPasswordField(20);
		JPasswordField passwordField2 = new JPasswordField(20);
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				char[] password = passwordField1.getPassword();
				if(!password.equals(passwordLabel2.getText())) {
					warningLabel.setText("Passwords do not match");
				}
				else {
					//Write Username and Password to a File so that it can be retrieved at the Login Page
				}
			}
		});
		add(userNameLabel);
		add(userNameField);
		add(passwordLabel1);
		add(passwordField1);
		add(passwordLabel2);
		add(passwordField2);
		add(registerButton);
		add(warningLabel);
		setVisible(true);
	}
}
class LoginFrame extends JFrame {
	public LoginFrame() {
		setSize(300,500);
		setTitle("Login");
		setLayout(new FlowLayout());
		JLabel userNameLabel = new JLabel("Username",JLabel.LEFT);
		JLabel displayLabel = new JLabel();
		JTextField userNameField = new JTextField(20);
		JLabel passwordLabel = new JLabel("Password",JLabel.LEFT);
		JPasswordField passwordField = new JPasswordField(20);
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				displayLabel.setText(userNameField.getText() + " has logged in");
				new AWTDoctor();
				//Check password from file
			}
		});
		add(userNameLabel);
		add(userNameField);
		add(passwordLabel);
		add(passwordField);
		add(loginButton);
		add(displayLabel);
		setVisible(true);
	}
}
public class HMSDem {
	public static void main(final String args[]) {
		new WelcomeFrame();
	}
}
