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
import com.ujwal.soft.models.MTax;
import com.ujwal.soft.repositories.MTaxRepo;

@RestController
@RequestMapping("/ujwal")
public class MTaxWebApiController {

	@Autowired
	MTaxRepo taxRepo;
	
	@RequestMapping(value="/addNewTax", method=RequestMethod.POST)
	public@ResponseBody MTax addnewTax(@RequestBody MTax tax) {
		return taxRepo.save(tax);
		
	}
	
	@RequestMapping(value="/getAllTaxes", method=RequestMethod.GET)
	public@ResponseBody List<MTax> getAllTaxes(){
		return taxRepo.findAllByDelStatus(0);
		
	}
	
	@RequestMapping(value="/getTaxById", method=RequestMethod.POST)
	public@ResponseBody MTax getTaxById(@RequestParam int id) {
		return taxRepo.getTaxById(id);
		
	}
	
	@RequestMapping(value="/deleteMTax", method=RequestMethod.POST)
	public @ResponseBody Info delMTax(@RequestParam int id) {
		
		Info info =new Info();
		int isDelete = taxRepo.deleteTax(id);
		
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
