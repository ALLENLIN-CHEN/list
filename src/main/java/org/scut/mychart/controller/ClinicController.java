package org.scut.mychart.controller;

import java.util.Map;

import org.scut.mychart.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/charts/clinic", produces="application/json;charset=UTF-8")
public class ClinicController {
	
	@Autowired
	private ClinicService clinicService;
	
	@RequestMapping("/hospitalTotal")
	@ResponseBody
	public Map<String, Object> getHospitalTotal(@RequestParam String year, @RequestParam String p){
		Map<String, Object> result = clinicService.getHospitalTotal(year, p);
		return result;
	} 
	
	@RequestMapping("/departmentTotal")
	@ResponseBody
	public Map<String, Object> getDepartmentTotal(@RequestParam String year, @RequestParam String p){
		Map<String, Object> result = clinicService.getDepartmentTotal(year, p);
		return result;
	}
	
	@RequestMapping("/doctorTotal")
	@ResponseBody
	public Map<String, Object> getDoctorTotal(@RequestParam String year, @RequestParam String p){
		Map<String, Object> result = clinicService.getDoctorTotal(year, p);
		return result;
	} 
	
}
