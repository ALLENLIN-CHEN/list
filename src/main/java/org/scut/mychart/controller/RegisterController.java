package org.scut.mychart.controller;

import java.util.Map;

import org.scut.mychart.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/charts/register", produces="application/json;charset=UTF-8")
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping("/countByGender")
    @ResponseBody
    public Map<String, Object> getCountByGender(){
		Map<String, Object> result = registerService.getCountByGender();
		return result;
    }  
	
	@RequestMapping("/countByGenderLine")
    @ResponseBody
    public Map<String, Object> getCountByGenderLine(){
		Map<String, Object> result = registerService.getCountByGenderLine();
		return result;
    } 
	
	@RequestMapping("/areaCoverage")
    @ResponseBody
    public Map<String, Object> getAreaCoverage(){
		Map<String, Object> result = registerService.getAreaCoverage();
		return result;
    } 
	
	@RequestMapping("/ageRange")
    @ResponseBody
    public Map<String, Object> getAgeRange(){
		Map<String, Object> result = registerService.getAgeRange();
		return result;
    } 

	@RequestMapping("/hospitalTotal")
	@ResponseBody
	public Map<String, Object> getHospitalTotal(@RequestParam String year, @RequestParam String p){
		Map<String, Object> result = registerService.getHospitalTotal(year, p);
		return result;
	} 

	@RequestMapping("/hospitalPercent")
	@ResponseBody
	public Map<String, Object> getHospitalPercent(@RequestParam String startTime, @RequestParam String endTime, @RequestParam String p){
		Map<String, Object> result = registerService.getHospitalPercent(startTime, endTime, p);
		return result;
	} 
	
	@RequestMapping("/departmentTotal")
	@ResponseBody
	public Map<String, Object> getDepartmentTotal(@RequestParam String year, @RequestParam String p){
		Map<String, Object> result = registerService.getDepartmentTotal(year, p);
		return result;
	}
	
	@RequestMapping("/departmentPercent")
	@ResponseBody
	public Map<String, Object> getDepartmentPercent(@RequestParam String startTime, @RequestParam String endTime, @RequestParam String p){
		Map<String, Object> result = registerService.getDepartmentPercent(startTime, endTime, p);
		return result;
	} 
	
	@RequestMapping("/docotorTotal")
	@ResponseBody
	public Map<String, Object> getDoctorTotal(@RequestParam String year, @RequestParam String p){
		Map<String, Object> result = registerService.getDoctorTotal(year, p);
		return result;
	} 

	@RequestMapping("/docotorPercent")
	@ResponseBody
	public Map<String, Object> getDocotorPercent(@RequestParam String startTime, @RequestParam String endTime, @RequestParam String p){
		Map<String, Object> result = registerService.getDoctorPercent(startTime, endTime, p);
		return result;
	} 

}
