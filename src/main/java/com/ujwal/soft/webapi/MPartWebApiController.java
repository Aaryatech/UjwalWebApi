package com.ujwal.soft.webapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ujwal.soft.models.Info;
import com.ujwal.soft.models.MCompany;
import com.ujwal.soft.models.MPart;
import com.ujwal.soft.repositories.MCompanyRepo;
import com.ujwal.soft.repositories.MPartRepo;
@RestController
@RequestMapping("/ujwal")
public class MPartWebApiController {
	@Autowired
	MPartRepo mpartRepo;
	
	@RequestMapping(value="/addNewPart", method=RequestMethod.POST)
	public@ResponseBody MPart addNewPart(@RequestBody MPart mpart) {
		return mpartRepo.save(mpart);
		}
	
	@RequestMapping(value="/getAllPart", method=RequestMethod.GET)
	public@ResponseBody List<MPart> getAllPart(){
		return mpartRepo.findAllByPartDelStatus(0);
		
	}
	
	@RequestMapping(value="/getPartById", method=RequestMethod.POST)
	public@ResponseBody MPart getPartById(@RequestParam int id){
		return mpartRepo.findByPartIdAndPartDelStatus(id, 0);
		
	}
	
	
	
	@RequestMapping(value="/deleteCustomer", method=RequestMethod.POST)
	public @ResponseBody Info delCustomer(@RequestParam int id) {
		
		Info info =new Info();
		int isDelete = mpartRepo.deletePart(id);
		
		if(isDelete!=0) {
			info.setError(false);
			info.setMessage("sucess");
		}else {
			info.setError(true);
			info.setMessage("Fail");
		}
		return info;
		
	}
}
