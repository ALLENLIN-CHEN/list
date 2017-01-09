package org.scut.mychart.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.plaf.DesktopIconUI;

import org.scut.mychart.mapper.CompanyMapper;
import org.scut.mychart.model.CompanyModel;
import org.scut.mychart.service.CompanyService;
import org.scut.mychart.util.DictionaryString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyMapper companyMapper;
	
	private final static int PAGE_NUM = 15;
	
	@Override
	public Map<String, Object> getCountByGender() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<CompanyModel> data = companyMapper.getCountByGender();
		Map<String, Map<String, Integer>> maleCount = new HashMap<String, Map<String,Integer>>();
		Map<String, Map<String, Integer>> femaleCount = new HashMap<String, Map<String,Integer>>();
		String temp = "";
		
		for(CompanyModel m : data) {
			temp = String.valueOf(m.getYear());
			if(m.getSex().equalsIgnoreCase(DictionaryString.MALE)) {
				if(!maleCount.containsKey(temp)) {
					maleCount.put(temp, new HashMap<String, Integer>());
				}
				maleCount.get(temp).put(m.getCtype(), m.getTotal());
				if(!maleCount.get(temp).containsKey("total")) {
					maleCount.get(temp).put("total", 0);
				}
				
				maleCount.get(temp).put("total", maleCount.get(temp).get("total") + m.getTotal());
			} else if(m.getSex().equalsIgnoreCase(DictionaryString.FEMALE)) {
				if(!femaleCount.containsKey(temp)) {
					femaleCount.put(temp, new HashMap<String, Integer>());
				}
				femaleCount.get(temp).put(m.getCtype(), m.getTotal());
				if(!femaleCount.get(temp).containsKey("total")) {
					femaleCount.get(temp).put("total", 0);
				}
				
				femaleCount.get(temp).put("total", femaleCount.get(temp).get("total") + m.getTotal());
			}
		}
		
		result.put("type", DictionaryString.COMPANY_GENDER_LINE);
		result.put("male", maleCount);
		result.put("female", femaleCount);
		return result;
	}
	
	@Override
	public Map<String, Object> getAgeRange() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<CompanyModel> data = companyMapper.getAgeRange();
		
		Map<String, Map<String, Integer>> total = new HashMap<String, Map<String,Integer>>();
		Map<String, Map<String, Map<String, Integer>>> companyNum = new HashMap<String, Map<String,Map<String,Integer>>>();
		String temp = "";
		String year = "";
		for(CompanyModel m : data) {
			temp = m.getCtype();
			if(!total.containsKey(temp)) {
				total.put(temp, new HashMap<String, Integer>());
			}
			year = String.valueOf(m.getYear());
			if(!total.get(temp).containsKey(year)) {
				total.get(temp).put(year, 0);
			}
			
			total.get(temp).put(year, total.get(temp).get(year) + 1);
			
			if(!companyNum.containsKey(temp)) {
				companyNum.put(temp, new HashMap<String, Map<String,Integer>>());
			}
			
			if(!companyNum.get(temp).containsKey(year)) {
				companyNum.get(temp).put(year, new HashMap<String, Integer>());
			}
			
			// 用于设置年龄
			if(m.getAge() >= 18 && m.getAge() < 22) {
				if(!companyNum.get(temp).get(year).containsKey("18-22岁")) {
					companyNum.get(temp).get(year).put("18-22岁", 0);
				}
				
				companyNum.get(temp).get(year).put("18-22岁", companyNum.get(temp).get(year).get("18-22岁") + 1);
			} else if(m.getAge() >= 22 && m.getAge() < 25) {
				if(!companyNum.get(temp).get(year).containsKey("22-25岁")) {
					companyNum.get(temp).get(year).put("22-25岁", 0);
				}
				
				companyNum.get(temp).get(year).put("22-25岁", companyNum.get(temp).get(year).get("22-25岁") + 1);
			} else if(m.getAge() >= 25 && m.getAge() < 30) {
				if(!companyNum.get(temp).get(year).containsKey("25-30岁")) {
					companyNum.get(temp).get(year).put("25-30岁", 0);
				}
				
				companyNum.get(temp).get(year).put("25-30岁", companyNum.get(temp).get(year).get("25-30岁") + 1);
			} else if(m.getAge() >= 30 && m.getAge() < 40) {
				if(!companyNum.get(temp).get(year).containsKey("30-40岁")) {
					companyNum.get(temp).get(year).put("30-40岁", 0);
				}
				
				companyNum.get(temp).get(year).put("30-40岁", companyNum.get(temp).get(year).get("30-40岁") + 1);
			} else if(m.getAge() >= 40 && m.getAge() < 50) {
				if(!companyNum.get(temp).get(year).containsKey("40-50岁")) {
					companyNum.get(temp).get(year).put("40-50岁", 0);
				}
				
				companyNum.get(temp).get(year).put("40-50岁", companyNum.get(temp).get(year).get("40-50岁") + 1);
			} else if(m.getAge() >= 50) {
				if(!companyNum.get(temp).get(year).containsKey("50岁以上")) {
					companyNum.get(temp).get(year).put("50岁以上", 0);
				}
				
				companyNum.get(temp).get(year).put("50岁以上", companyNum.get(temp).get(year).get("50岁以上") + 1);
			}
		}
		
		DecimalFormat df = new DecimalFormat("#.##");
		double per = 0.0;
		Map<String, Map<String, Map<String, Double>>> range = new HashMap<String, Map<String,Map<String,Double>>>();
		for(Map.Entry<String, Map<String, Integer>> e : total.entrySet()) {
			temp = e.getKey();
			if(!range.containsKey(temp)) {
				range.put(temp, new HashMap<String, Map<String,Double>>());
			}
			
			for(Map.Entry<String, Integer> me : e.getValue().entrySet()) {
				year = me.getKey();
				
				if(!range.get(temp).containsKey(year)) {
					range.get(temp).put(year, new HashMap<String, Double>());
				}
				
				for(Map.Entry<String, Integer> ageMap : companyNum.get(temp).get(year).entrySet()) {
					per = (double)ageMap.getValue() / me.getValue() * 100;
					range.get(temp).get(year).put(ageMap.getKey(), Double.valueOf(df.format(per)));
				}
			}
		}
		
		result.put("type", DictionaryString.COMPANY_AGE_FUNNEL);
		result.put("range", range);
		return result;
	}

	@Override
	public Map<String, Object> getCompany(String year, String p) {
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
		
		List<CompanyModel> companyTotal = companyMapper.getCompanyInsuranceTotal(param);
		List<CompanyModel> personTotal = companyMapper.getCompanyInsurancePersonTotal(param);
		
		int pageCount = getPageCount(companyTotal.size());
		
		Map<String, Double> allRank = new HashMap<String, Double>();
		String company;
		DecimalFormat df = new DecimalFormat("#.##");
		double per = 0.0;
		for(CompanyModel m : companyTotal) {
			company = m.getCtype();
			allRank.put(company, (double)m.getTotal());
		}
		
		for(CompanyModel m : personTotal) {
			company = m.getCtype();
			per = allRank.get(company) / m.getPersonTotal();
			allRank.put(company, Double.valueOf(df.format(per)));
		}
		
		List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String,Double>>(allRank.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {

			@Override
			public int compare(Entry<String, Double> o1,
					Entry<String, Double> o2) {
				if(o2.getValue() - o1.getValue() > 0) {
					return 1;
				}
				if(o2.getValue() - o1.getValue() == 0) {
					return 0;
				}
				if(o2.getValue() - o1.getValue() < 0){
					return -1;
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
