package com.ujwal.soft.webapi;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ujwal.soft.models.BillHeader;

@RestController
public class BillHeaderWebApiController {
	
	@RequestMapping(value="/inserteader", method=RequestMethod.POST)
	public @ResponseBody String insertHeader(@RequestBody BillHeader billHead) {
		return null;
		
	}
}
