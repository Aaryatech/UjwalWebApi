/*package com.ujwal.soft.webapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ujwal.soft.models.BillDetails;
import com.ujwal.soft.models.BillHeader;
import com.ujwal.soft.repositories.BillHeaderRepo;

@RestController
public class BillHeaderWebApiController {
	
	@Autowired

BillHeaderRepo getBillRepo;
	@RequestMapping(value = { "/saveBill" }, method = RequestMethod.POST)
	public @ResponseBody BillHeader saveOrder(@RequestBody BillHeader billHeader) {

		System.err.println("header body " + billHeader.toString());

		BillHeader billRes = null;

		try {

			billRes = getBillRepo.save(billHeader);

			for (int i = 0; i < billHeader.getBillDetailList().size(); i++) {

				billHeader.getBillDetailList().get(i).setBillDetailId(billRes.getBillHeaderId());

			}

			List<BillDetails> billDetList = getBillRepo.saveAll(billHeader.getBillDetailList());

			getBillRepo.setBillDetailList(billDetList);

		} catch (Exception e) {

			System.err.println("exce in saving order head and detail " + e.getMessage());

			e.printStackTrace();

		}
		System.err.println("Bill " + billRes.toString());

		return billRes;

	}

}
*/