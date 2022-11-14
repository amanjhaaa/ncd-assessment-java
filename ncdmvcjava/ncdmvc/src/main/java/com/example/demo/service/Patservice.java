package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.Repo;
import com.example.demo.model.PatientInfo;

public class Patservice {
	@Autowired
	Repo pd;
	
	public List<PatientInfo> getPatientByFirstname(String firstname)
	{
		return pd.findByFirstname(firstname);
	}

}
