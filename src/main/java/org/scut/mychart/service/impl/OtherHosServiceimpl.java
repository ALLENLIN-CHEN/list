package org.scut.mychart.service.impl;

import java.text.DecimalFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.derby.iapi.error.ExceptionSeverity;
import org.apache.hadoop.hive.ql.parse.HiveParser_IdentifiersParser.booleanValue_return;
import org.apache.hadoop.hive.ql.parse.HiveParser_IdentifiersParser.precedenceEqualNegatableOperator_return;
import org.apache.tools.ant.taskdefs.Length;
import org.eclipse.jetty.jndi.java.javaNameParser;
import org.scut.mychart.mapper.OtherHosMapper;
import org.scut.mychart.model.OtherHosModel;
import org.scut.mychart.model.RegisterModel;
import org.scut.mychart.service.OtherHosService;
import org.scut.mychart.util.DictionaryString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stringtemplate.v4.compiler.STParser.mapExpr_return;
import org.w3c.dom.ls.LSInput;

import com.mysql.fabric.xmlrpc.base.Array;

import groovy.beans.ListenerListASTTransformation;

/**
 * 实现数据的获取
 * @author spiden
 *
 */
@Service
public class OtherHosServiceimpl implements OtherHosService{
	

	@Autowired
	private OtherHosMapper otherhos;
	
	private final static int PAGE_NUM=15;
	
	@Override
	
	public Map<String, Object> getHistogramData() {
		// TODO Auto-generated method stub
		Map<String,Object> data = new HashMap<String,Object>();
		List<OtherHosModel> list =this.otherhos.selectTotalNum();
		data.put("data", list);
		data.put("type", "histogram");
		return data;
	}

	@Override
	public Map<String, Object> getLineData() {
		Map<String,Object> data = new HashMap<String,Object>();
		List<OtherHosModel> list =this.otherhos.selectTotalNum();
		data.put("data", list);
		data.put("type", "line");
		return data;
	}

	@Override
	public Map<String, Object> getPanelData() {
	   
	    
	    Map<String, Object> haha =new HashMap<String,Object>();
	    List<OtherHosModel> list =this.otherhos.selectArea();
	    List<OtherHosModel> sum =this.otherhos.selectYearNum();
	    
	    List<String> area = new ArrayList<String>();
	    
	    for(int i=0;i<list.size();i++){
	    	if(!area.contains(list.get(i).getArea())){
	    		area.add(list.get(i).getArea());
	    	}
	    }
	    
	    
	    
	    for(int i=0;i<area.size();i++){
	    	List<Double> per =new ArrayList<Double>();
	    	for(int j=0;j<sum.size();j++){
	    		for(int k=0;k<list.size();k++){
	    			if(list.get(k).getYear().equals(sum.get(j).getYear())&&list.get(k).getArea().equals(area.get(i))){
	    				double x = (double)list.get(k).getPerson_num()/sum.get(j).getPerson_num()*100;
	    				per.add(x);
	    			}
	    		}
	    	}
	    	
	    	haha.put(area.get(i), per);
	    	
	    }
	    
		Map<String,Object> data = new HashMap<String,Object>();
		
		
	
		data.put("data", haha);
		data.put("type", "panel");
		data.put("sum", sum);
		return data;
	}

	@Override
	public Map<String, Object> getFunnelData() {
		Map<String,Object> data = new HashMap<String,Object>();
		
		List<OtherHosModel> list =this.otherhos.selectAge();
		List<OtherHosModel> llll=new ArrayList<OtherHosModel>();
		
		List<String> temp =new ArrayList<String>();
		temp.add("儿童");
		temp.add("青年");
		temp.add("中年");
		temp.add("老年");
		
		List<Integer> year=new ArrayList<Integer>();
		List<Integer> sum=new ArrayList<Integer>();
		
		for(int i=0;i<list.size();i++){
			String str=list.get(i).getYear();
			if(!year.contains(Integer.valueOf(str))){
				year.add(Integer.valueOf(str));
			}
		}
		
		for(int m=0;m<year.size();m++){
		
			int cnt=0;
			int cur=0;
			int k=0;
			for(int i =0;i<list.size();i++){
				if(list.get(i).getYear().equals(year.get(m).toString())){
					cnt+=list.get(i).getPerson_num();
					cur++;
					llll.add(list.get(i));
					k=i;
				}
			}
			
			if(cur<4){
				List<String> exist=new ArrayList<String>();
				
				for(int j=k;j>k-cur;j--){
					exist.add(list.get(j).getAge());
				
				}
			    for(int n=0;n<temp.size();n++){
			    	if(!exist.contains(temp.get(n))){
						OtherHosModel otherHosModel =new OtherHosModel();
						otherHosModel.setAge(temp.get(n));
						otherHosModel.setYear(year.get(m).toString());
						otherHosModel.setPerson_num(0);
						
						llll.add(otherHosModel);
			    	}
			    }
			}
			sum.add(cnt);	
		}
		
	
		data.put("data", llll);
		data.put("type", "funnel");
		data.put("total", sum);
		return data;
		
	}

	
	@Override
	public Map<String, Object> getHistogramData_hos(String year,String p) {
		// TODO Auto-generated method stub
		
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
		List<OtherHosModel> data =this.otherhos.selectHospital(param);
		int total = this.otherhos.getHospitalTotalCount(param);
		
		int pageCount = getPageCount(total);
		
		result.put("data", data);
		result.put("pageCount", pageCount);
		return result;
		
	}

	@Override
	public Map<String, Object> getHistogramData_dep(String year,String p) {
		// TODO Auto-generated method stub
		
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
		
		List<OtherHosModel> data = this.otherhos.selectDepartment(param);
		int total = this.otherhos.getDepartmentCount(param);
		int pageCount = getPageCount(total);
		
		result.put("data", data);
		result.put("pageCount", pageCount);
		return result;
	}

	@Override
	public Map<String, Object> getHistogramData_hosPercent(String sTime, String eTime,String p) {
		// TODO Auto-generated method stub
		
		Map<String, Object> result = new HashMap<String, Object>();
		String stime = sTime + "-01-01";
		String etime = eTime + "-12-31";
		List<OtherHosModel> total = this.otherhos.selectHosPercent(stime, etime);
		List<OtherHosModel> day = this.otherhos.selectHosMax(stime, etime);
		Map<String, Double> per = new HashMap<String, Double>();
		
		int pageCount = getPageCount(total.size());
		
		DecimalFormat df = new DecimalFormat("#.##");
		double calPer = 0.0;
		OtherHosModel d = null;
		int index = 0;
		int days = Integer.valueOf(eTime) - Integer.valueOf(sTime) + 1;
		for(OtherHosModel m : total) {
			d = day.get(index);
			calPer = (double)m.getPerson_num() / (d.getPerson_num() * 365 * days) * 100;
			per.put(m.getHos_name(), Double.valueOf(df.format(calPer)));
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
	public Map<String, Object> getHistogramData_depPercent(String sTime, String eTime,String p) {
		// TODO Auto-generated method stub
		
		Map<String, Object> result = new HashMap<String, Object>();
		String stime = sTime + "-01-01";
		String etime = eTime + "-12-31";
		List<OtherHosModel> total = this.otherhos.selectDepPercent(stime, etime);
		List<OtherHosModel> day = this.otherhos.selectDepMax(stime, etime);
		Map<String, Double> per = new HashMap<String, Double>();
		
		int pageCount = getPageCount(total.size());
		
		Map<String, Integer> totalMap = new HashMap<String, Integer>();
		for(OtherHosModel m : total) {
			String key = m.getHos_name() + "-" + m.getDep_name();
			if(!totalMap.containsKey(key)) {
				totalMap.put(key, m.getPerson_num());
			}
		}
		
		DecimalFormat df = new DecimalFormat("#.##");
		double calPer = 0.0;
		int days = Integer.valueOf(eTime) - Integer.valueOf(sTime) + 1;
		for(OtherHosModel m : day) {
			String key = m.getHos_name() + "-" + m.getDep_name();
			if(totalMap.containsKey(key)) {
				calPer = (double)totalMap.get(key) / (m.getPerson_num() * 365 * days) * 100;
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
