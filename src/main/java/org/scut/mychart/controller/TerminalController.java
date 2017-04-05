package org.scut.mychart.controller;

import org.scut.mychart.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping(value="/charts/terminal", produces="application/json;charset=UTF-8")
public class TerminalController {

	@Autowired
	private TerminalService terminalService;

	@RequestMapping("/getTypeData")
	@ResponseBody
	public Map<String, Object> getTypeOption(@RequestParam String year, @RequestParam String p){
		Map<String, Object> result = terminalService.getTerminalType(year,p);
		return  result;
	}

	@RequestMapping("/getBusinessData")
	@ResponseBody
	public Map<String, Object> getBusinessOption(@RequestParam String year, @RequestParam String p){
		Map<String, Object> result = terminalService.getTerminalBusiness(year,p);
		return  result;
	}

	@RequestMapping("/getStatusData")
	@ResponseBody
	public Map<String, Object> getStatusOption(@RequestParam String year, @RequestParam String p){
		Map<String, Object> result = terminalService.getTerminalStatus(year,p);
		return  result;
	}
}
