package org.scut.mychart.controller;

import java.util.Map;

import org.scut.mychart.service.INetPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/charts/netpoint",produces = "application/json;charset=UTF-8")
public class NetPointController {
	@Autowired	
	private INetPointService netPointService;
	
	@RequestMapping("/getTerminalAmount")
	@ResponseBody
	public Map<String,Object> getTerminalAmount(@RequestParam String year, @RequestParam String p){		
		Map<String, Object> result = netPointService.getTerminalAmount(year, p);
		return result;
	}
	
	@RequestMapping("/getWorkState")
	@ResponseBody
	public Map<String, Object> getWorkState(@RequestParam String year, @RequestParam String p) {
		Map<String, Object> result = netPointService.getWorkState(year, p);
		return result;
	}
	
	@RequestMapping("/getOperationAmount")
	@ResponseBody
	public Map<String, Object> getOperationAmount(@RequestParam String year, @RequestParam String p){
		Map<String, Object> result = netPointService.getOperationAmout(year, p);
		return result;
	}

}
