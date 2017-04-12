package org.scut.mychart.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.scut.mychart.mapper.ClinicMapper;
import org.scut.mychart.model.ClinicModel;
import org.scut.mychart.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicServiceImpl implements ClinicService {

	@Autowired
	private ClinicMapper clinicMapper;
	
	private final static int PAGE_NUM = 15;
		
	@Override
	public Map<String, Object> getHospitalTotal(String year, String p) {
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
		List<ClinicModel> data = clinicMapper.getHospitalTotal(param);
		int total = clinicMapper.getHospitalCount(param);
		
		int pageCount = getPageCount(total);
		
		result.put("data", data);
		result.put("pageCount", pageCount);
		return result;
	}
	
	@Override
	public Map<String, Object> getDepartmentTotal(String year, String p) {
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
		
		List<ClinicModel> data = clinicMapper.getDepartmentTotal(param);
		int total = clinicMapper.getDepartmentCount(param);
		int pageCount = getPageCount(total);
		
		result.put("data", data);
		result.put("pageCount", pageCount);
		return result;
	}	

	@Override
	public Map<String, Object> getDoctorTotal(String year, String p) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		String stime = "";
		String etime = "";
		if(!year.equalsIgnoreCase("all")) {
			stime = year + "-01-01";
			etime = year + "-12-31";
			param.put("stime", stime);
			param.put("etime", etime);
		}else {
			stime = "2010-01-01";
			etime = "2015-12-31";
			param.put("stime", stime);
			param.put("etime", etime);
		}
		
		int offset = (Integer.valueOf(p).intValue() - 1) * PAGE_NUM;
		param.put("offset", offset);
		
		List<ClinicModel> data = clinicMapper.getDoctorTotal(param);
		
		int total = clinicMapper.getDoctorCount(param);
		int pageCount = getPageCount(total);
		
		result.put("pageCount", pageCount);
		result.put("data", data);
		return result;
	}	

	/**
	 * 用于返回总页数
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
}
