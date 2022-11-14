package com.example.demo.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.PatientInfo;

//import antlr.collections.List;

public interface Repo extends JpaRepository<PatientInfo , Long>{
	PatientInfo findById(long patient_id);
	
	List<PatientInfo> findAll();

	public List<PatientInfo> findByFirstname(String firstname);
	
//	List<PatientInfo> findByTitleContainingOrContentContaining(String text, String textAgain);

}
