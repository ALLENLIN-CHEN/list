package org.scut.mychart.service.impl;

import org.scut.mychart.mapper.SpecialMapper;
import org.scut.mychart.model.SpecialModel;
import org.scut.mychart.service.SpecialService;
import org.scut.mychart.util.DictionaryString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;
/**
 * Created by linqidi on 2016/12/9.
 */

@Service
public class SpecialServiceImpl implements SpecialService {

	@Autowired
	private SpecialMapper specialMapper;
	private final static int PAGE_NUM = 15;
	@Override
	public Map<String, Object> getCountByGender() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<SpecialModel> data = specialMapper.getCountByGender(DictionaryString.BUSINESS_TSYL);
		List<Integer> maleCount = new ArrayList<Integer>();
		List<Integer> femaleCount = new ArrayList<Integer>();

		for(SpecialModel m : data) {
			if(m.getSex().equals(DictionaryString.MALE)) {
				maleCount.add(m.getSum());
			}else if(m.getSex().equals(DictionaryString.FEMALE)) {
				femaleCount.add(m.getSum());
			}
		}

		result.put("type", DictionaryString.TSYL_BAR_X);
		result.put("male", maleCount);
		result.put("female", femaleCount);
		return result;
	}

	@Override
	public Map<String, Object> getCountByGenderLine() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<SpecialModel> data = specialMapper.getCountByGender(DictionaryString.BUSINESS_TSYL);
		List<Integer> maleCount = new ArrayList<Integer>();
		List<Integer> femaleCount = new ArrayList<Integer>();

		for(SpecialModel m : data) {
			if(m.getSex().equals(DictionaryString.MALE)) {
				maleCount.add(m.getSum());
			}else if(m.getSex().equals(DictionaryString.FEMALE)) {
				femaleCount.add(m.getSum());
			}
		}

		result.put("type", DictionaryString.TSYL_LINE);
		result.put("male", maleCount);
		result.put("female", femaleCount);
		return result;
	}

	@Override
	public Map<String, Object> getAreaCoverage() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<SpecialModel> data = specialMapper.getAreaCoverage(DictionaryString.BUSINESS_TSYL);
		Map<String, Integer> total = new HashMap<String, Integer>();
		String temp = "";
		for(SpecialModel m : data) {
			temp = String.valueOf(m.getYear());
			if(total.containsKey(temp)) {
				total.put(temp, total.get(temp) + m.getSum());
			}else {
				total.put(temp, m.getSum());
			}
		}

		Map<String, List<Double>> coverage = new HashMap<String, List<Double>>();

		DecimalFormat df = new DecimalFormat("#.##");

		for(SpecialModel m : data) {
			temp = String.valueOf(m.getYear());
			m.setCoverage((double)m.getSum() / total.get(temp) * 100);
			if(coverage.containsKey(m.getArea())) {
				coverage.get(m.getArea()).add(Double.valueOf(df.format(m.getCoverage())));
			}else {
				coverage.put(m.getArea(), new ArrayList<Double>());
				coverage.get(m.getArea()).add(Double.valueOf(df.format(m.getCoverage())));
			}
		}

		result.put("type", DictionaryString.TSYL_GAUGE);
		result.put("coverage", coverage);
		return result;
	}
	public Map<String, Object> getAgeRange() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<SpecialModel> data = specialMapper.getAgeRange(DictionaryString.BUSINESS_TSYL);

		Map<String, Map<String, Integer>> dataSet = new HashMap<String, Map<String,Integer>>();
		String temp = "";
		for(SpecialModel m : data) {
			temp = String.valueOf(m.getYear());
			if(dataSet.containsKey(temp)) {
				dataSet.get(temp).put("total", dataSet.get(temp).get("total") + m.getSum());
			}else {
				dataSet.put(temp, new HashMap<String, Integer>());
				dataSet.get(temp).put("total", m.getSum());
			}

			if(m.getYear() - m.getBirth() <= 6) {
				if(dataSet.get(temp).containsKey(DictionaryString.CHILD)) {
					dataSet.get(temp).put(DictionaryString.CHILD, dataSet.get(temp).get(DictionaryString.CHILD) + m.getSum());
				}else {
					dataSet.get(temp).put(DictionaryString.CHILD, m.getSum());
				}
			} else if(m.getYear() - m.getBirth() >= 7 && m.getYear() - m.getBirth() <= 40) {
				if(dataSet.get(temp).containsKey(DictionaryString.YOUTH)) {
					dataSet.get(temp).put(DictionaryString.YOUTH, dataSet.get(temp).get(DictionaryString.YOUTH) + m.getSum());
				}else {
					dataSet.get(temp).put(DictionaryString.YOUTH, m.getSum());
				}
			} else if(m.getYear() - m.getBirth() >= 41 && m.getYear() - m.getBirth() <= 65) {
				if(dataSet.get(temp).containsKey(DictionaryString.MIDLIFE)) {
					dataSet.get(temp).put(DictionaryString.MIDLIFE, dataSet.get(temp).get(DictionaryString.MIDLIFE) + m.getSum());
				}else {
					dataSet.get(temp).put(DictionaryString.MIDLIFE, m.getSum());
				}
			} else if(m.getYear() - m.getBirth() >= 66) {
				if(dataSet.get(temp).containsKey(DictionaryString.OLDER)) {
					dataSet.get(temp).put(DictionaryString.OLDER, dataSet.get(temp).get(DictionaryString.OLDER) + m.getSum());
				}else {
					dataSet.get(temp).put(DictionaryString.OLDER, m.getSum());
				}
			}
		}

		result.put("type", DictionaryString.TSYL_FUNNEL);
		result.put("ageRange", dataSet);

		return result;
	}

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
		List<SpecialModel> data = specialMapper.getHospitalTotalList(param);
		int total = specialMapper.getHospitalTotalCount(param);

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
		List<SpecialModel> total = specialMapper.getHospitalByTime(DictionaryString.BUSINESS_TSYL, stime, etime);
		List<SpecialModel> day = specialMapper.getHospitalMaxByDay(DictionaryString.BUSINESS_TSYL, stime, etime);
		Map<String, Double> per = new HashMap<String, Double>();

		int pageCount = getPageCount(total.size());

		DecimalFormat df = new DecimalFormat("#.##");
		double calPer = 0.0;
		SpecialModel d = null;
		int index = 0;
		int days = Integer.valueOf(endTime) - Integer.valueOf(startTime) + 1;
		for(SpecialModel m : total) {
			d = day.get(index);
			calPer = (double)m.getSum() / (d.getMaxNum() * 365 * days) * 100;
			per.put(m.getHospital(), Double.valueOf(df.format(calPer)));
			index++;
		}

		/**
		 * 用于排序
		 */
		List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String,Double>>(per.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {

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

		List<SpecialModel> data = specialMapper.getDepartmentTotal(param);
		int total = specialMapper.getDepartmentCount(param);
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
		List<SpecialModel> total = specialMapper.getDepartmentByTime(DictionaryString.BUSINESS_TSYL, stime, etime);
		List<SpecialModel> day = specialMapper.getDepartmentMaxByDay(DictionaryString.BUSINESS_TSYL, stime, etime);
		Map<String, Double> per = new HashMap<String, Double>();

		int pageCount = getPageCount(total.size());

		Map<String, Integer> totalMap = new HashMap<String, Integer>();
		for(SpecialModel m : total) {
			String key = m.getHospital() + "-" + m.getDepartment();
			if(!totalMap.containsKey(key)) {
				totalMap.put(key, m.getSum());
			}
		}

		DecimalFormat df = new DecimalFormat("#.##");
		double calPer = 0.0;
		int days = Integer.valueOf(endTime) - Integer.valueOf(startTime) + 1;
		for(SpecialModel m : day) {
			String key = m.getHospital() + "-" + m.getDepartment();
			if(totalMap.containsKey(key)) {
				calPer = (double)totalMap.get(key) / (m.getMaxNum() * 365 * days) * 100;
				per.put(key, Double.valueOf(df.format(calPer)));
			}
		}

		/**
		 * 用于排序
		 */
		List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String,Double>>(per.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {

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
