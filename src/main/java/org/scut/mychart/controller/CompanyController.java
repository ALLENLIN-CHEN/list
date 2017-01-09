package org.scut.mychart.controller;

import java.util.Map;

import org.scut.mychart.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/charts/company", produces="application/json;charset=UTF-8")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping("/countByGender")
    @ResponseBody
    public Map<String, Object> getCountByGender(){
		Map<String, Object> result = companyService.getCountByGender();
		return result;
    }  
	
	@RequestMapping("/ageRange")
	@ResponseBody
	public Map<String, Object> getAgeRange(){
		Map<String, Object> result = companyService.getAgeRange();
		return result;
	} 

	@RequestMapping("/data")
    @ResponseBody
    public Map<String, Object> getCountByGenderLine(@RequestParam String year, @RequestParam String p){
		Map<String, Object> result = companyService.getCompany(year, p);
		return result;
    } 
	
}
