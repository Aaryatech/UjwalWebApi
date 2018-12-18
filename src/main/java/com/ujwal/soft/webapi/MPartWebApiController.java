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
		return mpartRepo.findAllPart();
		
	}
	
	@RequestMapping(value="/getPartById", method=RequestMethod.POST)
	public@ResponseBody MPart getPartById(@RequestParam int id){
		return mpartRepo.findByPartIdAndPartDelStatus(id, 0);
		
	}
	
	
	
	@RequestMapping(value="/deletePartId", method=RequestMethod.POST)
	public @ResponseBody Info delPart(@RequestParam int id) {
		
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
	@RequestMapping(value = { "/deleteMultiPart" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiPart(@RequestParam("partIds") List<Integer> partIds) {

		Info info = new Info();

		try {
			int delete = mpartRepo.deleteMultiPart(partIds);

			if (delete >= 1) {
				info.setError(false);
				info.setMessage("successfully Multiple Deleted");
			} else {
				info.setError(true);
				info.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Deleted to Delete");

		}
		return info;

	}
}
