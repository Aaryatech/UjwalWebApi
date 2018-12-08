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
import com.ujwal.soft.models.MCustomer;
import com.ujwal.soft.repositories.MCustomerRepo;

@RestController
@RequestMapping("/ujwal")
public class MCustomerWebApiController {
	@Autowired
	MCustomerRepo mcustRepo;
	
	@RequestMapping(value="/addNewCustomer", method=RequestMethod.POST)
	public@ResponseBody MCustomer addNewCustomer(@RequestBody MCustomer mcust) {
		return mcustRepo.save(mcust);
		
	}
	
	@RequestMapping(value="/getAllCustomer", method=RequestMethod.GET)
	public@ResponseBody List<MCustomer> getAllCustomer(){
		return mcustRepo.findAllByCustDelStatus(0);
		
	}
	
	@RequestMapping(value="/getCustomerById", method=RequestMethod.POST)
	public@ResponseBody MCustomer getCustomerById(@RequestParam int id){
		return mcustRepo.findByCustIdAndCustDelStatus(id, 0);
		
	}
	
	
	
	@RequestMapping(value="/deleteCustmer", method=RequestMethod.POST)
	public @ResponseBody Info delCustomer(@RequestParam int id) {
		
		Info info =new Info();
		int isDelete = mcustRepo.deleteCustomer(id);
		
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
