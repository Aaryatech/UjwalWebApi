package com.ujwal.soft.webapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ujwal.soft.models.CradentialValidator;
import com.ujwal.soft.models.Info;
import com.ujwal.soft.models.MUser;
import com.ujwal.soft.repositories.MUserRepo;

@RequestMapping("/ujwal")
@RestController
public class MUserWebApiController {

	@Autowired MUserRepo muser;
	
	@RequestMapping(value = "/getUserById", method = RequestMethod.POST)
	public@ResponseBody MUser getUserDetailById(@RequestParam int id) {
		
		return muser.findUserById(id);
		
	}
	
	@RequestMapping(value="/insertNewUser", method=RequestMethod.POST)
	public@ResponseBody MUser addNewUser(@RequestBody MUser mUser) {
		return muser.save(mUser);
		
	}
	
	@RequestMapping(value="/deleteUser", method=RequestMethod.POST)
	public @ResponseBody Info deleteUser(@RequestParam int id) {
		
		Info info =new Info();
		int isDelete = muser.deleteUser(id);
		
		if(isDelete!=0) {
			info.setError(false);
			info.setMessage("sucess");
		}else {
			info.setError(true);
			info.setMessage("Fail");
		}
		return info;
		
	}
	

	@RequestMapping(value = { "/loginUser" }, method = RequestMethod.POST)
	public @ResponseBody CradentialValidator loginUser(@RequestParam("usrMob") String usrMob,
			@RequestParam("userPass") String userPass) {

		CradentialValidator loginResponse = new CradentialValidator();
		try {

			MUser mu = muser.findByUserMobileAndUserPwdAndDelStatus(usrMob, userPass, 0);
			if (mu == null) {
				loginResponse.setError(true);
				loginResponse.setMsg("login Failed");
			} else {
				loginResponse.setError(false);
				loginResponse.setMsg("login successfully");
				loginResponse.setMusr(mu);
			}

		} catch (Exception e) {

			e.printStackTrace();
			loginResponse.setError(true);
			loginResponse.setMsg("login Failed");
		}

		return loginResponse;
	}

	
	
	
	/*public @ResponseBody CradentialValidator validateLogin(@RequestParam String mobile, @RequestParam String password) {
	
		String flag = muser.validateCredentials(mobile, password);
		
		CradentialValidator cv = new CradentialValidator();
		if(flag!=null) {
			cv.getMusr();
		}
		else {
			cv.getInfo();
		}
		
		return cv;
		
	}*/

}
