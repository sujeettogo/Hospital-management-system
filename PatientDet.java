package hms;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import java.*;
class PatientDet
{
	public PatientDet(Patient pat) {
		JFrame frame =  new JFrame();
		frame.setTitle("Doctor Details");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(null);
		JLabel name = new JLabel("Name : " + pat.getPname());
		JLabel age = new JLabel("Age : " + pat.getAge());
		JLabel diagnosis = new JLabel("Diagnosis : " + pat.getDiagnosis());
		name.setBounds(20,40,100,20);
		age.setBounds(20,60,100,20);
		diagnosis.setBounds(20,80,200,20);
		frame.add(name);
		frame.add(age);
		frame.add(diagnosis);
		frame.setSize(300,250);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new PatientDet(new Patient("Sourav",19,"bunny","iamafgt","AIDS"));
	}
} 
	
