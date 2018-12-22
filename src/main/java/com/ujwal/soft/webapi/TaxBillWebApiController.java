package com.ujwal.soft.webapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ujwal.soft.models.ItemBean;
import com.ujwal.soft.models.TaxBillBean;
import com.ujwal.soft.repositories.BillTaxRepo;

@RestController
@RequestMapping(value = "/ujwal")
public class TaxBillWebApiController {

	@Autowired BillTaxRepo billtxRepo;
	@RequestMapping(value = "/getBillTaxReport", method=RequestMethod.POST)
	
	public List<TaxBillBean> getTaxWiseBilleport(@RequestParam("comp_id") int comp_id, @RequestParam("fromDate") String froDate, 
			@RequestParam("toDate") String toDate){
		
		List<TaxBillBean> taxList=null;
		//taxList = billtxRepo.getBillTaxReport(comp_id, froDate, toDate);
		if(comp_id==0)
		{
			taxList = billtxRepo.getBillTaxReport(froDate, toDate);
		}
		else {
			taxList = billtxRepo.getBillTaxReportById(comp_id, froDate, toDate);
		}
		
		
				return taxList;
		
	}
}
