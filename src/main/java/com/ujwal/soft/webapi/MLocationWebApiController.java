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
import com.ujwal.soft.models.MLocation;
import com.ujwal.soft.repositories.MLocationRepo;

@RestController
@RequestMapping("/ujwal")
public class MLocationWebApiController {

	@Autowired
	MLocationRepo mlocRepo;
	
	@RequestMapping(value="/addNewLocation", method=RequestMethod.POST)
	public@ResponseBody MLocation addNewLocation(@RequestBody MLocation mloc) {
		return mlocRepo.save(mloc);
		
	}
	
	@RequestMapping(value="/getAllLocations", method=RequestMethod.GET)
	public@ResponseBody List<MLocation> getAllLocation() {
		return mlocRepo.findAllByDelStatus(0);
		
	}
	
	@RequestMapping(value="/getLocationById", method=RequestMethod.POST)
	public@ResponseBody MLocation getLocationId(@RequestParam int id){
		return mlocRepo.findByLocationIdAndDelStatus(id, 0);
		
	}
	
	/*@RequestMapping(value="/updateLocation", method=RequestMethod.POST)
	public@ResponseBody MLocation updateLocation(@RequestBody MLocation mloc) {
		
		MLocation location = mlocRepo.getLocationById(mloc.getCompId());
		location.setLocation_name(mloc.getLocation_name());
		location.setLocationAddress(mloc.getLocationAddress());
		location.setPhoneNo(mloc.getPhoneNo());
		location.setFaxNo(mloc.getFaxNo());
		location.setEmail(mloc.getEmail());
		location.setCompId(mloc.getCompId());
		location.setDelStatus(mloc.getDelStatus());
		location.setExInt1(mloc.getExInt1());
		location.setExInt2(mloc.getExInt2());
		location.setExInt3(mloc.getExInt3());
		location.setExtVar1(mloc.getExtVar1());
		location.setExtVar2(mloc.getExtVar2());
		location.setExtVar3(mloc.getExtVar3());
		location.setExBool1(mloc.isExBool1());
		location.setExBool2(mloc.isExBool2());
		location.setExDate1(mloc.getExDate1());
		location.setExDate2(mloc.getExDate2());
		
		return mlocRepo.save(location);
		
	}*/
	
	@RequestMapping(value="/deleteLocation", method=RequestMethod.POST)
	public@ResponseBody Info deleteLoc(@RequestParam int id) {
		
		Info info = new Info();
		
		int isDelete = mlocRepo.deleteLocation(id);
		
		if(isDelete!=0) {
			info.setError(false);
			info.setMessage("Sucess");
		}else {
			info.setError(true);
			info.setMessage("Fail");
		}
		
		return info;
		
	}
	
}
