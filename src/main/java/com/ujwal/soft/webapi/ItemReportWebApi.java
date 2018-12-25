package com.ujwal.soft.webapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ujwal.soft.models.BillDetails;
import com.ujwal.soft.models.BillHeader;
import com.ujwal.soft.models.ItemBean;
import com.ujwal.soft.repositories.BillDetailRepo;
import com.ujwal.soft.repositories.ItemRepo;

@RestController
@RequestMapping("/ujwal")
public class ItemReportWebApi {

	
	@Autowired ItemRepo itemRepo;
	
	@RequestMapping(value = "/getItemsBetweenDate", method=RequestMethod.POST)
	public @ResponseBody List<ItemBean>  getItemsBetweenDate(@RequestParam("itemId") int itemId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate){
		
		List<ItemBean> itemList=null;
		if(itemId==0)
		{
			itemList=itemRepo.getItemByDate(fromDate, toDate);
		}
		else {
			itemList=itemRepo.getItemByDateAndId(itemId, fromDate, toDate);
		}
		return itemList;
		
	}
}
