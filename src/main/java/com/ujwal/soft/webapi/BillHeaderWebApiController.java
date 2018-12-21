package com.ujwal.soft.webapi;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ujwal.soft.models.BillDetails;
import com.ujwal.soft.models.BillHeader;
import com.ujwal.soft.models.Document;
import com.ujwal.soft.models.GetBillDetail;
import com.ujwal.soft.models.GetBillHeader;
import com.ujwal.soft.models.Info;
import com.ujwal.soft.repositories.BillDetailRepo;
import com.ujwal.soft.repositories.BillHeaderRepo;
import com.ujwal.soft.repositories.DocumentRepo;
import com.ujwal.soft.repositories.GetBillDetailRepository;
import com.ujwal.soft.repositories.GetBillHeaderRepository;

@RestController
public class BillHeaderWebApiController {
	
	@Autowired 
    BillHeaderRepo getBillRepo;
	@Autowired 
	BillDetailRepo getDetailRepo;
	@Autowired
	DocumentRepo getDocumentRepo;
    @Autowired
    GetBillHeaderRepository getBillHeaderRepository;
    @Autowired
    GetBillDetailRepository getBillDetailRepository;

	@RequestMapping(value = { "/saveBill" }, method = RequestMethod.POST)
	public @ResponseBody BillHeader saveBill(@RequestBody BillHeader billHeader) {

		System.err.println("header body " + billHeader.toString());

		BillHeader billRes = null;
		//BillDetails billDetails=null;

		try {
			billRes = getBillRepo.save(billHeader);

			for (int i = 0; i < billHeader.getBillDetailList().size(); i++) 
			{
				billHeader.getBillDetailList().get(i).setBillHeaderId(billRes.getBillHeaderId());
			}
			List<BillDetails> billDetList = getDetailRepo.saveAll(billHeader.getBillDetailList());
			billRes.setBillDetailList(billDetList);
		} 
		catch (Exception e) 
		{
			System.err.println("exce in saving order head and detail " + e.getMessage());
			e.printStackTrace();
		}
		System.err.println("Bill " + billRes.toString());
		return billRes;
	}

	@RequestMapping(value = { "/saveDocument" }, method = RequestMethod.POST)
	public @ResponseBody Document saveDocument(@RequestBody Document document) {

		Document res = new Document();

		try {

			res = getDocumentRepo.saveAndFlush(document);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getAllDocList" }, method = RequestMethod.GET)
	public @ResponseBody List<Document> getAllDocList() {

		List<Document> docList = new ArrayList<Document>();

		try {

			docList = getDocumentRepo.findByDelStatusOrderByDocIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return docList;

	}

	@RequestMapping(value = { "/getDocument" }, method = RequestMethod.POST)
	public @ResponseBody Document getDocument(@RequestParam("docCode") int docCode) {

		Document doc = new Document();

		DateFormat dateFormat = new SimpleDateFormat("2018-12-31");
		String curDate = dateFormat.format(new Date());

		try {

			doc = getDocumentRepo.getDocuData(docCode, curDate);
			//System.err.println("getting doc " + doc.toString());

		} catch (Exception e) {
			System.err.println("Exc in  /getDocument" + e.getMessage());
			e.printStackTrace();

		}

		return doc;

	}
	@RequestMapping(value = { "/updateDocSrNo" }, method = RequestMethod.POST)
	public @ResponseBody Info updateDocSrNo(@RequestParam("docCode") int docCode, @RequestParam("srNo") int srNo) {

		Info info = new Info();

		try {

			int update = getDocumentRepo.updateDocSrNo(srNo, docCode);

			if (update == 1) {
				info.setError(false);
				info.setMessage("successfully update");
			} else {
				info.setError(true);
				info.setMessage(" failed to update");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" failed to update");

		}
		return info;

	}
	@RequestMapping(value = { "/getBillHeadersByDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetBillHeader> getBillHeadersByDate(@RequestParam("custId")int custId,@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate) {


		List<GetBillHeader> billHeaderRes = null;

		try {

			billHeaderRes = getBillHeaderRepository.getBillHeadersByDate(custId,fromDate,toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return billHeaderRes;

	}
	@RequestMapping(value = { "/getBillHeaderById" }, method = RequestMethod.POST)
	public @ResponseBody GetBillHeader getBillHeaderById(@RequestParam("billHeadId")int billHeadId) {


		GetBillHeader billHeaderRes = null;

		try {

			billHeaderRes = getBillHeaderRepository.getBillHeaderById(billHeadId);
			List<GetBillDetail> detailList=getBillDetailRepository.getBillDetailByHeaderId(billHeadId);
			billHeaderRes.setGetBillDetail(detailList);
			System.err.println(detailList.toString()+"detailList");
		} catch (Exception e) {

			e.printStackTrace();

		}

		return billHeaderRes;

	}
	@RequestMapping(value = { "/getBillHeaderByHeaderId" }, method = RequestMethod.POST)
	public @ResponseBody BillHeader getBillHeaderByHeaderId(@RequestParam("billHeadId")int billHeadId) {


		BillHeader billHeaderRes = null;

		try {

			billHeaderRes = getBillRepo.findByBillHeaderIdAndDelStatus(billHeadId,0);
			List<BillDetails> detailList=getDetailRepo.findByBillHeaderIdAndDelStatus(billHeadId,0);
			billHeaderRes.setBillDetailList(detailList);
			System.err.println(detailList.toString()+"detailList");
		} catch (Exception e) {

			e.printStackTrace();

		}

		return billHeaderRes;

	}
}
