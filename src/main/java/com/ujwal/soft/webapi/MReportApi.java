package com.ujwal.soft.webapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujwal.soft.common.DateConvertor;
import com.ujwal.soft.models.BillHeader;
import com.ujwal.soft.repositories.GetBillReportRepo;

@Controller
public class MReportApi {
	@Autowired
	GetBillReportRepo getBillReportReportrepo;

	
	@RequestMapping(value = { "/getContractorBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<BillHeader> getContractorBetweenDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {
System.out.println("aZSxdcfgvbhjnmk");
		List<BillHeader> headerList = new ArrayList<BillHeader>();

		try {

			headerList = getBillReportReportrepo.getBillBetweenDate(fromDate, toDate);

		
		} catch (Exception e) {

			e.printStackTrace();

		}
		return headerList;

	}
}
