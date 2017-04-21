package org.scut.mychart.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.scut.mychart.mapper.NetPointMapper;
import org.scut.mychart.model.NetPointModel;
import org.scut.mychart.service.INetPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groovy.ui.Console;

@Service
public class NetPointServiceImpl implements INetPointService {
	@Autowired
	private NetPointMapper netPointMapper;
	private final static int PAGE_NUM = 15;
	
	@Override
	public Map<String, Object> getTerminalAmount(String year, String p) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		String stime = "";
		String etime = "";
		if(!year.equalsIgnoreCase("all")) {
			stime = year + "-01-01";
			etime = year + "-12-31";			
		}else {
			stime = "2010-01-01";
			etime = "2015-12-31";			
		}
		param.put("stime", stime);
		param.put("etime", etime);
		
		int offset = (Integer.valueOf(p).intValue() - 1) * PAGE_NUM;
		param.put("offset", offset);
		List<NetPointModel> data = netPointMapper.selectTerminalAmout(param);
		int total = netPointMapper.countTerminal(param);
		
		int pageCount = getPageCount(total);
		
		result.put("data", data);
		result.put("pageCount", pageCount);
		return result;
	}

	@Override
	public Map<String, Object> getWorkState(String year, String p) {		
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		String stime = "";
		String etime = "";
		boolean checkAll = false;
		if(!year.equalsIgnoreCase("all")) {
			stime = year + "-01-01";
			etime = year + "-12-31";			
			checkAll = false;
		}else {
			checkAll = true;
			stime = "2010-01-01";
			etime = "2015-12-31";			
		}
		param.put("stime", stime);
		param.put("etime", etime);
		
		int offset = (Integer.valueOf(p).intValue() - 1) * PAGE_NUM;
		param.put("offset", offset);
		List<NetPointModel> data = netPointMapper.selectWorkState(param);
		int total = netPointMapper.countWorkState(param);
		
		int pageCount = getPageCount(total);		
		
		if(checkAll){	//统计2010到2015年所有的闰年
			for (NetPointModel netPointModel : data) {		//按照非闰年设置异常工作天数
				netPointModel.setNotWork(365*6-netPointModel.getWork());
			}
			for(int idx = 2010;idx<=2015;idx++)
				if(checkLeapYear(String.valueOf(idx))){
					for (NetPointModel netPointModel : data) {
						netPointModel.setNotWork(netPointModel.getNotWork()+1);
					}
				}
		}else{		//判断year是否为闰年，如果是则所有网点宜昌工作天数加1
			for (NetPointModel netPointModel : data) {		//按照非闰年设置异常工作天数
				netPointModel.setNotWork(365-netPointModel.getWork());
			}
			if(checkLeapYear(year))
				for (NetPointModel netPointModel : data) {
					netPointModel.setNotWork(netPointModel.getNotWork()+1);
				}
		}
		result.put("data", data);
		result.put("pageCount", pageCount);
		return result;
	}

	@Override
	public Map<String, Object> getOperationAmout(String year, String p) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		String stime = "";
		String etime = "";
		if(!year.equalsIgnoreCase("all")) {
			stime = year + "-01-01";
			etime = year + "-12-31";			
		}else {
			stime = "2010-01-01";
			etime = "2015-12-31";			
		}
		param.put("stime", stime);
		param.put("etime", etime);
		
		int offset = (Integer.valueOf(p).intValue() - 1) * PAGE_NUM;
		param.put("offset", offset);
		List<NetPointModel> data = netPointMapper.selectOperationAmout(param);
		int total = netPointMapper.countOperation(param);
		
		int pageCount = getPageCount(total);
		
		result.put("data", data);
		result.put("pageCount", pageCount);
		return result;
	}
	
	/**
	 * 获取页面数量
	 * @param total
	 * @return
	 */
	private int getPageCount(int total) {
		int pageCount = 0;
		if(total < PAGE_NUM) {
			pageCount = 1;
		} else {
			int rest = total % PAGE_NUM;
			pageCount = total / PAGE_NUM;
			if(rest > 0) {
				pageCount++;
			}
		}
		return pageCount;
	}
	
	/**
	 * 判断闰年
	 * @param year
	 * @return
	 */
	private boolean checkLeapYear(String year) {
		int y = Integer.valueOf(year);
		if(0 == y%400)
			return true;
		if(0 == y%4 && 0 != y%100)
			return true;
		return false;
	}
}
