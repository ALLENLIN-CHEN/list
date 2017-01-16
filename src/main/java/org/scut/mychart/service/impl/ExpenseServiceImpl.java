package org.scut.mychart.service.impl;

import org.scut.mychart.mapper.*;
import org.scut.mychart.model.ExpenseModel;
import org.scut.mychart.service.ExpenseService;
import org.scut.mychart.util.DictionaryString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseMapper expenseMapper;
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
		List<ExpenseModel> data = expenseMapper.getHospitalTotalList(param);
		int total = expenseMapper.getHospitalTotalCount(param);

		int pageCount = getPageCount(total);

		result.put("data", data);
		result.put("pageCount", pageCount);
		return result;
	}

	@Override
	public Map<String, Object> getHospitalPercent(String startTime, String endTime, String p) {
		Map<String, Object> result = new HashMap<String, Object>();
		String stime = startTime + "-01-01";
		String etime = endTime + "-12-31";
		List<ExpenseModel> total = expenseMapper.getHospitalByTime("医疗费用报销申请", stime, etime);
		List<ExpenseModel> day = expenseMapper.getHospitalMaxByDay("医疗费用报销申请", stime, etime);
		Map<String, Double> per = new HashMap<String, Double>();

		int pageCount = getPageCount(total.size());

		DecimalFormat df = new DecimalFormat("#.##");
		double calPer = 0.0;
		ExpenseModel d = null;
		int index = 0;
		int days = Integer.valueOf(endTime) - Integer.valueOf(startTime) + 1;
		for(ExpenseModel m : total) {
			d = day.get(index);
			calPer = (double)m.getSum() / (d.getMaxNum() * 365 * days) * 100;
			per.put(m.getHospital(), Double.valueOf(df.format(calPer)));
			index++;
		}

		/**
		 * 用于排序
		 */
		List<Entry<String, Double>> list = new ArrayList<Entry<String,Double>>(per.entrySet());
		Collections.sort(list, new Comparator<Entry<String, Double>>() {

			@Override
			public int compare(Entry<String, Double> o1,
							   Entry<String, Double> o2) {
				if(o2.getValue() - o1.getValue() >= 0) {
					return 1;
				}else {
					return -1;
				}
			}
		});

		int offset = (Integer.valueOf(p).intValue() - 1) * PAGE_NUM;
		int len = offset+PAGE_NUM;
		if(len > list.size()) {
			len = list.size();
		}
		list = list.subList(offset, len);

		result.put("pageCount", pageCount);
		result.put("data", list);
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

		List<ExpenseModel> data = expenseMapper.getDepartmentTotal(param);
		int total = expenseMapper.getDepartmentCount(param);
		int pageCount = getPageCount(total);

		result.put("data", data);
		result.put("pageCount", pageCount);
		return result;
	}

	@Override
	public Map<String, Object> getDepartmentPercent(String startTime, String endTime, String p) {
		Map<String, Object> result = new HashMap<String, Object>();
		String stime = startTime + "-01-01";
		String etime = endTime + "-12-31";
		List<ExpenseModel> total = expenseMapper.getDepartmentByTime("医疗费用报销申请", stime, etime);
		List<ExpenseModel> day = expenseMapper.getDepartmentMaxByDay("医疗费用报销申请", stime, etime);
		Map<String, Double> per = new HashMap<String, Double>();

		int pageCount = getPageCount(total.size());

		Map<String, Integer> totalMap = new HashMap<String, Integer>();
		for(ExpenseModel m : total) {
			String key = m.getHospital() + "-" + m.getDepartment();
			if(!totalMap.containsKey(key)) {
				totalMap.put(key, m.getSum());
			}
		}

		DecimalFormat df = new DecimalFormat("#.##");
		double calPer = 0.0;
		int days = Integer.valueOf(endTime) - Integer.valueOf(startTime) + 1;
		for(ExpenseModel m : day) {
			String key = m.getHospital() + "-" + m.getDepartment();
			if(totalMap.containsKey(key)) {
				calPer = (double)totalMap.get(key) / (m.getMaxNum() * 365 * days) * 100;
				per.put(key, Double.valueOf(df.format(calPer)));
			}
		}

		/**
		 * 用于排序
		 */
		List<Entry<String, Double>> list = new ArrayList<Entry<String,Double>>(per.entrySet());
		Collections.sort(list, new Comparator<Entry<String, Double>>() {

			@Override
			public int compare(Entry<String, Double> o1,
							   Entry<String, Double> o2) {
				if(o1 == null && o2 == null) {
					return 0;
				}
				if(o1 == null) {
					return -1;
				}
				if(o2 == null) {
					return 1;
				}
				if(o2.getValue() - o1.getValue() > 0) {
					return 1;
				}
				if(o1.getValue() - o2.getValue() > 0){
					return -1;
				}
				if(o2.getValue() - o1.getValue() == 0) {
					return 0;
				}
				return 0;
			}
		});

		int offset = (Integer.valueOf(p).intValue() - 1) * PAGE_NUM;
		int len = offset+PAGE_NUM;
		if(len > list.size()) {
			len = list.size();
		}
		list = list.subList(offset, len);

		result.put("pageCount", pageCount);
		result.put("data", list);
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
