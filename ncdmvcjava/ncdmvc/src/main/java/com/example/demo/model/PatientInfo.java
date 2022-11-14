package com.example.demo.model;

import java.util.List;

//import java.io.Serializable;


import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient_info")
//public class PatientInfo implements Serializable {
public class PatientInfo{
	
	
//	private int slno;
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private int ; 
	@Id
	private long patient_id = (long) (Math.random() * (99999999999999L - 10000000000000L + 1) + 10000000000000L);
	private String firstname;
	 private String lastname;
	private String email; 
	private String gender;
	private String birthday; 
	private String pincode;

	public int count ;
	public String result;
//private String patientid=Long.toString((long)((Math.random()*(99999999999999L-10000000000000L))) ;


	public PatientInfo() {
		super();
	}


	public PatientInfo(int slno, long patient_id , String firstname, String lastname, String email, String gender , String birthday , String pincode , 
			int count , String result ) {
		super();
//		this.slno = slno;
		this.patient_id = patient_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.gender = gender;
		this.birthday = birthday;
		this.pincode = pincode;
		this.count = count;
		this.result = result;
		
		
	
		}

	public long getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(long patient_id) {
		this.patient_id = patient_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	@Override
	public String toString() {
		return "PatientInfo [patient_id=" + patient_id + ", firstname=" + firstname + ", lastname="
				+ lastname + ", email=" + email + ", gender=" + gender + ", birthday=" + birthday + ", pincode="
				+ pincode + ", count=" + count + ", result=" + result + "]";
	}


	public List<PatientInfo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


}

//public int Total() {
////	count = 
//	return age+smoke+alcohol+measurement+history+physical;
//	}
//	
//public String Result(){
//	if ((age+smoke+alcohol+measurement+history+physical)>4) {
//		System.out.println(count);
//		result = ("You need screening");
//		return result;
//	}
//	else {
//		result = ("You don't need screening");
//		return result;
//}
//}

