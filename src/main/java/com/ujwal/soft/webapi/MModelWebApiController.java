package com.ujwal.soft.webapi;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ujwal.soft.models.Info;
import com.ujwal.soft.models.MModelBean;
import com.ujwal.soft.repositories.MModelRepo;

@RestController
@RequestMapping("/ujwal")
public class MModelWebApiController {

	@Autowired MModelRepo modRepo;
	
	@RequestMapping(value="/insertNewModel", method=RequestMethod.POST)
	public @ResponseBody MModelBean addNewModel(@RequestBody MModelBean mod){
		return modRepo.save(mod);
		
	}
	
	@RequestMapping(value="/getModelById", method = RequestMethod.POST)
	public @ResponseBody MModelBean getModelById(@RequestParam("id") int modelId) {
		return modRepo.findByModelIdAndDelStatus(modelId, 0);
				
	}
	
	@RequestMapping(value="/getModelByDelStatus", method = RequestMethod.GET)
	public @ResponseBody List<MModelBean> getModelByDelStatus() {
		
		return modRepo.findAllByDelStatus(0);
				
	}
	
	@RequestMapping(value="/changeModelDelStatus", method = RequestMethod.POST)
	public @ResponseBody int changeStatus(@RequestParam("modelId") int modelId) {
		return modRepo.delModel(modelId);
		
	}
	
	@RequestMapping(value = { "/deleteMultiModels" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiCustomer(@RequestParam("modelIds") List<Integer> modelIds) {

		Info info = new Info();

		try {
			int delete = modRepo.deleteMultiModel(modelIds);

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

	@RequestMapping(value="/getModelByCompanyId", method=RequestMethod.POST)
	public @ResponseBody List<MModelBean> getModelByCompanyId(@RequestParam ("companyId") int companyId){
	
		return modRepo.findAllByCompanyIdAndDelStatus(companyId, 0);
		
	}
}
