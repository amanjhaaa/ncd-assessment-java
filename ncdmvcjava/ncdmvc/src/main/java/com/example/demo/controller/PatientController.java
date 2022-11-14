package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.dao.Repo;
import com.example.demo.model.Count;
import com.example.demo.model.PatientInfo;
import com.example.demo.model.Searchpagedata;

@Controller
public class PatientController {
	@Autowired
	Repo repo;
	PatientInfo patinfo;
	
	public static int total = 0;
	public static String prescription = ""; 
	
	@RequestMapping("/" )
	public String home() {
	    return "index.jsp";
	}

	@RequestMapping("about")
	public String about() {
	    return "about.jsp";
	    		
	}


	@RequestMapping("search")
	public String search() {
	    return "search.jsp";
	}


	@RequestMapping("contact")
	public String contact() {
	    return "contact.jsp";
	}

	    
	@RequestMapping("services")
	public String services() {
	    return "services.jsp";
	}


	 
//	@RequestMapping("registration.jsp")
//	public String registration1(Model model) {
////		 PatientInfo patientinfo = new PatientInfo ();
////		 model.addAttribute("patientinfo", patientinfo);
//	    return "registration.jsp";
	    @RequestMapping("registration.jsp")
	    public String registration1() {

	    	return "registration.jsp";
	}

	@RequestMapping("/res")
	public String res() {
//		PatientInfo patientinfo = new PatientInfo ();
//		 model.addAttribute("patientinfo", patientinfo);
	    return "result1.jsp";   
	}



	@RequestMapping("/login/")
	@ModelAttribute
	public String login() {
		
//		model.addAttribute("nameinfo",patinfo);
//		model.addAttribute("patient_id",patinfo.getPatient_id());
	    
	    return "ncd1.jsp";
	}
	
	@RequestMapping("/back")  
	public String back() {  
	    //if request.method == 'POST':
	        return "ncd1.jsp";
	}

	//back 1 is used for contact.jsp
	@RequestMapping("/back1")  
	public String back1() {  
//	    if request.method == 'POST':
	        return "index.jsp";  
	}

	


	@RequestMapping(value = "/registration",method = { RequestMethod.GET, RequestMethod.POST })
	
    public String regis(@ModelAttribute PatientInfo patientinfo, Model model) {
//		System.out.println(patientinfo);
		patinfo = patientinfo;
//		System.out.println(patinfo);
		repo.save(patientinfo);
//		patientinfo = PatientInfo;
		model.addAttribute("patient_id", patientinfo.getPatient_id());
		model.addAttribute("firstname", patientinfo.getFirstname());
        return "ncd1.jsp";
    }
	public void updateCustomerContacts(long id, int sc,String res) {
		PatientInfo myPatient = repo.findById(id);
		myPatient.count = sc;
		myPatient.result= res;
	    repo.save(myPatient);
	}
	
@PostMapping("/ncd1.jsp")
public String evaluateNcd(Model model) {
	model.addAttribute("Count", new Count());
	return "ncd1.jsp";
}
@RequestMapping(value = "/result1", method = { RequestMethod.GET, RequestMethod.POST })
	
    public String updatePatient(PatientInfo patientinfo, @ModelAttribute Count count,BindingResult result, Model model) {
//	System.out.println("This is patient id object "+patientinfo);
	
	total = count.getAge()+count.getAlcohol()+count.getMeasurement()+count.getPhysical()+count.getSmoke()+count.getHistory();
	prescription = "";
	if (total>4) {
		prescription = "Screening is needed";
	}
	else {
	prescription = "Screening is not needed";
	}
	
	model.addAttribute("count",total);
	model.addAttribute("firstname",patinfo.getFirstname());
    model.addAttribute("result",prescription);

	long id = patinfo.getPatient_id();
	
    updateCustomerContacts(id,total, prescription);

	

            return "result1.jsp";
    }

@RequestMapping("/searching1")
public String search(PatientInfo patientinfo, Searchpagedata sp, Model model) {

//	System.out.println("seach input value :"+sp.getPk());
//    System.out.println("drop downlist  value :"+sp.getChoice());
	
    List<PatientInfo> pat=(List<PatientInfo>) repo.findAll();
	
    List<PatientInfo> result= new ArrayList<PatientInfo>();
    for(PatientInfo p : pat)
    {
//    	System.out.println(p);
    	if("PATIENT ID".equals(sp.getChoice()))
    	{
    		String patid=String.valueOf(p.getPatient_id());
    		if(patid.equals(sp.getPk()))
    		{
//    			System.out.println("Inside Patient id choices");
    			result.add(p);
//    			System.out.println(result);
    			
    		}
    	}
    	
    	if("FIRST NAME".equals(sp.getChoice()))
    	{
    		String fname=p.getFirstname();
    		if(fname.equals(sp.getPk()))
    		{
//    			System.out.println("Inside firstname choices");
    			result.add(p);
//    			System.out.println(result);
    			
    		}
    	}
    	if("LAST NAME".equals(sp.getChoice()))
    	{
    		String lname=p.getLastname();
    		if(lname.equals(sp.getPk()))
    		{
//    			System.out.println("Inside lastname choices");
    			result.add(p);
//    			System.out.println(result);
    			
    		}
    	}
    	
    }
    
//    System.out.println("this is last result ");
//    System.out.println(result);
    model.addAttribute("records",result);
//    System.out.println(((PatientInfo) result).getFirstname());
    
    

	return "search.jsp";
}


//for all type of error 
@Controller
public class MyErrorController implements ErrorController  {

@RequestMapping("/error")
public String handleError(HttpServletRequest request) {
  Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
  
  if (status != null) {
      Integer statusCode = Integer.valueOf(status.toString());
  
      if(statusCode == HttpStatus.NOT_FOUND.value()) {
          return "404.jsp";
      }
      else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
          return "500.jsp";
      }
  }
  return "error.jsp";
}
}
}
