package hms;

import java.io.Serializable; 

class Patient implements Serializable
{
	private String pname;
	private int age;
	private String user_id;
	private String pwd;
	 private String diagnosis;
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	
	 
	public Patient(String pname, int age, String user_id, String pwd, String diagnosis) {
		super();
		this.pname = pname;
		this.age = age;
		this.user_id = user_id;
		this.pwd = pwd;
		this.diagnosis = diagnosis;
	}
}
