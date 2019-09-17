package hms;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import java.*;
class DoctorDet
{	
	public DoctorDet(Doctor doc) {
		JFrame frame =  new JFrame();
		frame.setTitle("Doctor Details");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(null);
		JLabel name = new JLabel("Name : " + doc.getDname());
		JLabel age = new JLabel("Age : " + doc.getAge());
		JLabel specialty = new JLabel("Specialization : " + doc.getSpecialization());
		name.setBounds(20,40,100,20);
		age.setBounds(20,60,100,20);
		specialty.setBounds(20,80,200,20);
		frame.add(name);
		frame.add(age);
		frame.add(specialty);
		frame.setSize(300,250);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new DoctorDet(new Doctor("Steve",23,"Cardio","Steven","ihearutalk2fish"));
	}
}

