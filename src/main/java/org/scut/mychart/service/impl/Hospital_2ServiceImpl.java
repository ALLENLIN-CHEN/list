package org.scut.mychart.service.impl;

import com.github.abel533.echarts.AxisPointer;
import com.github.abel533.echarts.Label;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.*;
import com.github.abel533.echarts.data.PointData;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.*;
import org.apache.commons.collections.map.HashedMap;
import org.scut.mychart.mapper.Hospital_2Mapper;
import org.scut.mychart.model.Hospital_2;
import org.scut.mychart.model.ChartTypeConstant;
import org.scut.mychart.redis.Hospital_2RedisDao;
import org.scut.mychart.service.Hospital_2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.Map;

@Service("hospital_2Service")
public class Hospital_2ServiceImpl implements Hospital_2Service {

	@Resource
	private Hospital_2Mapper hospitao_2Dao;

	@Autowired
	private Hospital_2RedisDao hospital_2RedisDao;

	private final static int PAGE_NUM = 15;

	public List<Hospital_2> getHospital_2(int title,String[] p){
		HashMap<String,String> param = new HashMap<String,String>();
		switch (title){
			case 2:
			case 3:return this.hospitao_2Dao.selectHospital_2_2(new HashMap());
			case 4:{
				param.put("address",p[0]);
				return this.hospitao_2Dao.selectHospital_2_4(param);
			}
			case 5:return this.hospitao_2Dao.selectHospital_2_5(new HashMap());
			case 6:{
				if(!p[0].equals("all")){
					param.put("year"," and year(operation_time)="+p[0]);
				}
				param.put("where","hospital as hospital");
				param.put("group","hospital");
				return this.hospitao_2Dao.selectHospital_2_6810(param);
			}
			case 8:{
				if(!p[0].equals("all")){
					param.put("year"," and year(operation_time)="+p[0]);
				}
				param.put("where","hospital as hospital, department as department");
				param.put("group","hospital,department");
				return this.hospitao_2Dao.selectHospital_2_6810(param);
			}
			case 10:{
				if(!p[0].equals("all")){
					param.put("year"," and year(operation_time)="+p[0]);
				}
				param.put("where","hospital as hospital, department as department, doctor as doctor");
				param.put("group","hospital,department,doctor");
				return this.hospitao_2Dao.selectHospital_2_6810(param);
			}
			case 7:{
				param.put("date","and year(operation_time)>="+p[0]+" and year(operation_time) <="+p[1]);
				param.put("type","A.hospital as hospital");
				param.put("where","hospital");
				param.put("join","A.hospital=B.hospital");
				return this.hospitao_2Dao.selectHospital_2_7911(param);
			}
			case 9:{
				param.put("date","and year(operation_time)>="+p[0]+" and year(operation_time) <="+p[1]);
				param.put("type","A.hospital as hospital,A.department as department");
				param.put("where","hospital,department");
				param.put("join","A.hospital=B.hospital and A.department=B.department");
				return this.hospitao_2Dao.selectHospital_2_7911(param);
			}
			case 11:{
				param.put("date","and year(operation_time)>="+p[0]+" and year(operation_time) <="+p[1]);
				param.put("type","A.hospital as hospital,A.department as department,A.doctor as doctor");
				param.put("where","hospital,department,doctor");
				param.put("join","A.hospital=B.hospital and A.department=B.department and A.doctor=B.doctor");
				return this.hospitao_2Dao.selectHospital_2_7911(param);
			}
		}
		return  null;
	}

	/**
	 * 根据title来获取redis的key
	 */
	public String getHospital_2RedisKey(int title) {
		switch (title){
			case 2:return ChartTypeConstant.HOSPITAL_2_2_REDIS;
			case 3:return ChartTypeConstant.HOSPITAL_2_3_REDIS;
			case 4:return ChartTypeConstant.HOSPITAL_2_4_REDIS;
			case 5:return ChartTypeConstant.HOSPITAL_2_5_REDIS;
			case 6:return ChartTypeConstant.HOSPITAL_2_6_REDIS;
			case 7:return ChartTypeConstant.HOSPITAL_2_7_REDIS;
			case 8:return ChartTypeConstant.HOSPITAL_2_8_REDIS;
			case 9:return ChartTypeConstant.HOSPITAL_2_9_REDIS;
			case 10:return ChartTypeConstant.HOSPITAL_2_10_REDIS;
			case 11:return ChartTypeConstant.HOSPITAL_2_11_REDIS;
		}
		return null;
	}

	public String getHospital_2_2ChartOption(){

		String type = getHospital_2RedisKey(2);

		String Hospital_2_2Data = hospital_2RedisDao.getWordcloudData(type);

		if(Hospital_2_2Data != null && !Hospital_2_2Data.isEmpty()) {
			return Hospital_2_2Data;
		}

		GsonOption option = new GsonOption();

		option.title("社保待遇支付各年份男女人员数量");
		option.tooltip().trigger(Trigger.axis);
		option.legend().data("男","女");

		option.toolbox().show(true).feature(Tool.mark, Tool.dataView,
				Tool.restore, Tool.saveAsImage);
		option.calculable(true);

		//生成category 和 series
		CategoryAxis category = new CategoryAxis();
		Bar male = new Bar();
		Bar female = new Bar();
		List<Hospital_2> totalList = getHospital_2(2,null);
		for (Hospital_2 list:totalList){
			if (list.getsex().equals("男")){
				category.data(list.getyear()+"年");
				male.data(list.getperson_num());
			}else{
				female.data(list.getperson_num());
			}
		}

		male.markPoint().data(new PointData().type(MarkType.max).name("最大值"), new PointData().type(MarkType.min).name("最小值"));
		male.markLine().data(new PointData().type(MarkType.average).name("平均值"));
		female.markPoint().data(new PointData().type(MarkType.max).name("最大值"), new PointData().type(MarkType.min).name("最小值"));
		female.markLine().data(new PointData().type(MarkType.average).name("平均值"));
		male.name("男");
		female.name("女");

		option.xAxis(category);
		option.yAxis(new ValueAxis());
		option.series(male,female);
		//return option;

		//插入缓存中
		hospital_2RedisDao.setWordcloudData(type, option.toString());

		return option.toString();
	}

	public String getHospital_2_3ChartOption(){

		String type = getHospital_2RedisKey(3);

		String Hospital_2Data = hospital_2RedisDao.getWordcloudData(type);

		if(Hospital_2Data != null && !Hospital_2Data.isEmpty()) {
			//return Hospital_2Data;
		}

		GsonOption option = new GsonOption();

		option.title("就医人数随时间变化情况");
		option.tooltip().trigger(Trigger.axis);
		option.tooltip().axisPointer(new AxisPointer().type(PointerType.shadow));
		option.legend().data("男","女");

		option.toolbox().show(true).feature(Tool.mark, Tool.dataView,
				Tool.restore, Tool.saveAsImage);
		option.calculable(true);

		//生成category 和 series
		CategoryAxis category = new CategoryAxis();
		Line male = new Line();
		Line female = new Line();
		List<Hospital_2> totalList = getHospital_2(3,null);
		for (Hospital_2 list:totalList){
			if (list.getsex().equals("男")){
				category.data(list.getyear()+"年");
				male.data(list.getperson_num());
			}else{
				female.data(list.getperson_num());
			}
		}

		male.markPoint().data(new PointData().type(MarkType.max).name("最大值"), new PointData().type(MarkType.min).name("最小值"));
		male.markLine().data(new PointData().type(MarkType.average).name("平均值"));
		female.markPoint().data(new PointData().type(MarkType.max).name("最大值"), new PointData().type(MarkType.min).name("最小值"));
		female.markLine().data(new PointData().type(MarkType.average).name("平均值"));
		male.name("男");
		female.name("女");

		option.xAxis(category);
		option.yAxis(new ValueAxis());
		option.series(male,female);


		//return option;

		//插入缓存中
		hospital_2RedisDao.setWordcloudData(type, option.toString());

		return option.toString();
	}

	public String getHospital_2_4ChartOption(String[] p){

		String type = getHospital_2RedisKey(4);

		String Hospital_2Data = hospital_2RedisDao.getWordcloudData(type);

		if(Hospital_2Data != null && !Hospital_2Data.isEmpty()) {
			//return Hospital_2Data;
		}

		GsonOption baseOption = new GsonOption();
		List<GsonOption> options = new ArrayList<GsonOption>();
		List<Hospital_2> totalList = getHospital_2(4,p);
		for (int i=2010;i<=2015;i++){
			GsonOption option = new GsonOption();
			option.title(i+"年"+p[0]+"覆盖率");
			option.tooltip().formatter("{b} : {c}%");

			option.toolbox().show(true).feature(Tool.mark, Tool.dataView,
					Tool.restore, Tool.saveAsImage);

			Gauge gauge = new Gauge();
			gauge.name(i+"年"+p[0]+"覆盖率");
			gauge.detail().formatter("{value}%");

			List<HashMap<String,Object>> temp_data = new ArrayList<HashMap<String,Object>>();
			for (Hospital_2 list:totalList){
				HashMap<String,Object> temp_map = new HashMap<String,Object>();
				if(list.getyear()==i){
					temp_map.put("value",(list.getperson_num()*100/list.getperson_sum()));
					temp_map.put("name",i+"年"+p[0]+"覆盖率");
					temp_data.add(temp_map);
				}
			}
			gauge.setData(temp_data);

			option.series(gauge);
			options.add(option);
			if(i==2010){
				baseOption=option;
			}
			baseOption.timeline().data(i+"-01-01");
		}
		baseOption.timeline().setAutoPlay(true);
		baseOption.timeline().playInterval(1500);
		baseOption.timeline().label().setFormatter("function(s){return (new Date(s)).getFullYear()+'年';}");
		String result = "{\"baseOption\": "+ baseOption +",\"options\":"+options+"}";
		//插入缓存中
		hospital_2RedisDao.setWordcloudData(type, result);
		//System.out.println(optionGroup.getOptions());

		return result.toString();
	}

	public String getHospital_2_5ChartOption(){

		String type = getHospital_2RedisKey(5);

		String Hospital_2Data = hospital_2RedisDao.getWordcloudData(type);

		if(Hospital_2Data != null && !Hospital_2Data.isEmpty()) {
			//return Hospital_2Data;
		}

		GsonOption baseOption = new GsonOption();
		List<GsonOption> options = new ArrayList<GsonOption>();

		List<Hospital_2> totalList = getHospital_2(5,null);

		for (int i=2010;i<=2015;i++){
			GsonOption option = new GsonOption();
			option.title(i+"年不同年龄段占比");
			option.tooltip().trigger(Trigger.item);
			option.legend().data("0-6岁（儿童）","7-40岁（青年）","41-65岁（中年）","66岁以上（老年）");
			option.tooltip().formatter("{a} <br/>{b} : {c}%");

			option.toolbox().show(true).feature(Tool.mark, Tool.dataView,
					Tool.restore, Tool.saveAsImage);

			Funnel funnel = new Funnel();
			funnel.name(i+"年不同年龄段占比");
			funnel.width("80%");
			funnel.maxSize("80%");

			int temp_sum = 0;
			for (Hospital_2 list:totalList){
				if(list.getyear()==i){
					temp_sum+=list.getperson_num();
				}
			}

			List<HashMap<String,Object>> temp_data = new ArrayList<HashMap<String,Object>>();
			for (Hospital_2 list:totalList){
				HashMap<String,Object> temp_map = new HashMap<String,Object>();
				if(list.getyear()==i){
					temp_map.put("value",100*list.getperson_num()/temp_sum);
					temp_map.put("name",list.getage());
					temp_data.add(temp_map);
				}
			}
			funnel.setData(temp_data);

			option.series(funnel);
			options.add(option);
			if(i==2010){
				baseOption=option;
			}
			baseOption.timeline().data(i+"-01-01");
		}

		//return option;

		baseOption.timeline().setAutoPlay(true);
		baseOption.timeline().playInterval(1500);
		baseOption.timeline().label().setFormatter("function(s){return (new Date(s)).getFullYear()+'年';}");
		String result = "{\"baseOption\": "+ baseOption +",\"options\":"+options+"}";

		//插入缓存中
		hospital_2RedisDao.setWordcloudData(type, result);

		return result;
	}

	public String getHospital_2_6810ChartOption(int title){

		String type = getHospital_2RedisKey(title);

		String Hospital_2Data = hospital_2RedisDao.getWordcloudData(type);

		if(Hospital_2Data != null && !Hospital_2Data.isEmpty()) {
			//return Hospital_2Data;
		}

		GsonOption baseOption = new GsonOption();
		List<GsonOption> options = new ArrayList<GsonOption>();
		List<Hospital_2> totalList = getHospital_2(title,null);
		for (int i=2010;i<=2015;i++){
			CategoryAxis category = new CategoryAxis();
			GsonOption option = new GsonOption();
			option.tooltip().trigger(Trigger.axis).formatter("{b} : {c}");
			option.legend().setShow(false);
			option.toolbox().show(true).feature(Tool.mark, Tool.dataView,
					Tool.restore, Tool.saveAsImage);
			option.calculable(true);

			Bar bar = new Bar();
			int t=1;
			for (Hospital_2 list:totalList){
				if(t<=10&&i==list.getyear()){
					list=totalList.get(totalList.indexOf(list)+1-t+10-t);
					if(title==6){
						option.title(i+"年医院就医服务数量排序TOP10");
						category.data(list.gethospital());
					}else if(title==8){
						option.title(i+"年科室就医服务数量排序TOP10");
						category.data(list.gethospital()+"\n"+list.getdepartment());
					}else if(title==10){
						option.title(i+"年医生就医服务数量排序TOP10");
						category.data(list.gethospital()+"\n"+list.getdepartment()+" "+list.getdoctor());
					}
					bar.data(list.getHospital_num());
					t++;
				}
			}
			option.grid().x(170);
			option.grid().borderWidth(0);
			option.series(bar);
			option.yAxis(category);
			option.xAxis(new ValueAxis());
			options.add(option);
			if(i==2010){
				baseOption=option;
			}
			baseOption.timeline().label().setFormatter("function(s){return (new Date(s)).getFullYear()+'年';}");
			baseOption.timeline().data(i+"-01-01");
		}
		//插入缓存中
		baseOption.timeline().setAutoPlay(true);
		baseOption.timeline().playInterval(1500);
		//baseOption.timeline().setShow(false);
		String result = "{\"baseOption\": "+ baseOption +",\"options\":"+options+"}";
		hospital_2RedisDao.setWordcloudData(type, result);
		return result;
	}

	public String getHospital_2_7911ChartOption(int title,String[] p){

		String type = getHospital_2RedisKey(title);

		String Hospital_2Data = hospital_2RedisDao.getWordcloudData(type);

		if(Hospital_2Data != null && !Hospital_2Data.isEmpty()) {
			//return Hospital_2Data;
		}

		GsonOption option = new GsonOption();
		option.tooltip().trigger(Trigger.axis).formatter("{b} : {c}");
		option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.bar),
				Tool.restore, Tool.saveAsImage);
		option.calculable(true);
		CategoryAxis category = new CategoryAxis();
		List<Hospital_2> totalList = getHospital_2(title,p);
		final int days = (Integer.parseInt(p[1])-Integer.parseInt(p[0])+1)*365;
		//将全部的Hospital_2按人数排序
		Collections.sort(totalList, new Comparator<Hospital_2>() {
			public int compare(Hospital_2 o1, Hospital_2 o2) {
				return o1.getRate(days).compareTo(o2.getRate(days));
			}
		});

		int t=1;
		NumberFormat formatter = new DecimalFormat("0.00");
		Bar bar = new Bar();
		for (Hospital_2 list:totalList) {
			if (t <= 10) {
				list=totalList.get(10-t);
				if (title == 7) {
					option.title("医院就医服务数量排序TOP10");
					category.data(list.gethospital());
					bar.data((int)((double)(list.getSum()*100)/((double)(list.getSim())*days)));
				} else if (title == 9) {
					option.title("科室就医服务数量排序TOP10");
					category.data(list.gethospital()+"\n"+list.getdepartment());
					bar.data((int)((double)(list.getSum()*100)/((double)(list.getSim())*days)));
				} else if (title == 11) {
					option.title("医生就医服务数量排序TOP10");
					category.data(list.gethospital() + "\n" + list.getdepartment() + " " + list.getdoctor());
					bar.data(formatter.format((double) (list.getSum() * 100) / ((double) (list.getSim()) * days)));
				}
			}
			t++;
		}
		option.grid().x(170);
		option.grid().borderWidth(0);
		option.series(bar);
		option.yAxis(category);
		option.xAxis(new ValueAxis());
		//插入缓存中
		hospital_2RedisDao.setWordcloudData(type, option.toString());

		return option.toString();
	}

	@Override
	public Map<String, Object> getHospitalTotal(String year, String p) {
		int pages = 0;
		Map<String, Object> data = new HashMap<String, Object>();
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		List<Hospital_2> lists = getHospital_2(6,new String[]{year});

		for(Hospital_2 list:lists){
			Map<String, Object> financial_type = new HashMap<String, Object>();
			financial_type.put("hospital",list.gethospital());
			financial_type.put("num",list.getHospital_num());
			result.add(financial_type);
		}
		int offset = (Integer.valueOf(p).intValue() - 1) * PAGE_NUM;
		int len = offset+PAGE_NUM;
		if(len > result.size()) {
			len = result.size();
		}
		pages=result.size()<=PAGE_NUM?1:result.size()/PAGE_NUM+1;
		result=result.subList(offset, len);
		data.put("pageCount",pages);
		data.put("data", result);
		return data;
	}

	@Override
	public Map<String, Object> getHospitalPercent(String startTime, String endTime, String p) {
		int pages = 0;
		final int days = (Integer.parseInt(endTime)-Integer.parseInt(startTime)+1)*365;
		Map<String, Object> data = new HashMap<String, Object>();
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		List<Hospital_2> lists = getHospital_2(7,new String[]{startTime,endTime});
		//将全部的Hospital_2按人数排序
		Collections.sort(lists, new Comparator<Hospital_2>() {
			public int compare(Hospital_2 o1, Hospital_2 o2) {
				return o1.getRate(days).compareTo(o2.getRate(days));
			}
		});

		for(Hospital_2 list:lists){
			Map<String, Object> financial_type = new HashMap<String, Object>();
			financial_type.put("hospital",list.gethospital());
			double num = (double)(list.getSum()*100)/((double)(list.getSim())*days);
			BigDecimal b = new BigDecimal(num);
			financial_type.put("num",b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
			result.add(financial_type);
		}
		int offset = (Integer.valueOf(p).intValue() - 1) * PAGE_NUM;
		int len = offset+PAGE_NUM;
		if(len > result.size()) {
			len = result.size();
		}
		pages=result.size()<=PAGE_NUM?1:result.size()/PAGE_NUM+1;
		result=result.subList(offset, len);
		data.put("pageCount",pages);
		data.put("data", result);
		return data;
	}

	@Override
	public Map<String, Object> getDepartmentTotal(String year, String p) {
		int pages = 0;
		Map<String, Object> data = new HashMap<String, Object>();
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		List<Hospital_2> lists = getHospital_2(8,new String[]{year});

		for(Hospital_2 list:lists){
			Map<String, Object> financial_type = new HashMap<String, Object>();
			financial_type.put("hospital",list.gethospital());
			financial_type.put("department",list.getdepartment());
			financial_type.put("num",list.getHospital_num());
			result.add(financial_type);
		}
		int offset = (Integer.valueOf(p).intValue() - 1) * PAGE_NUM;
		int len = offset+PAGE_NUM;
		if(len > result.size()) {
			len = result.size();
		}
		pages=result.size()<=PAGE_NUM?1:result.size()/PAGE_NUM+1;
		result=result.subList(offset, len);
		data.put("pageCount",pages);
		data.put("data", result);
		return data;
	}

	@Override
	public Map<String, Object> getDepartmentPercent(String startTime, String endTime, String p) {
		int pages = 0;
		final int days = (Integer.parseInt(endTime)-Integer.parseInt(startTime)+1)*365;
		Map<String, Object> data = new HashMap<String, Object>();
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		List<Hospital_2> lists = getHospital_2(9,new String[]{startTime,endTime});
		//将全部的Hospital_2按人数排序
		Collections.sort(lists, new Comparator<Hospital_2>() {
			public int compare(Hospital_2 o1, Hospital_2 o2) {
				return o1.getRate(days).compareTo(o2.getRate(days));
			}
		});

		for(Hospital_2 list:lists){
			Map<String, Object> financial_type = new HashMap<String, Object>();
			financial_type.put("hospital",list.gethospital());
			financial_type.put("department",list.getdepartment());
			double num = (double)(list.getSum()*100)/((double)(list.getSim())*days);
			BigDecimal b = new BigDecimal(num);
			financial_type.put("num",b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
			result.add(financial_type);
		}
		int offset = (Integer.valueOf(p).intValue() - 1) * PAGE_NUM;
		int len = offset+PAGE_NUM;
		if(len > result.size()) {
			len = result.size();
		}
		pages=result.size()<=PAGE_NUM?1:result.size()/PAGE_NUM+1;
		result=result.subList(offset, len);
		data.put("pageCount",pages);
		data.put("data", result);
		return data;
	}

	@Override
	public Map<String, Object> getDoctorTotal(String year, String p) {
		int pages = 0;
		Map<String, Object> data = new HashMap<String, Object>();
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		List<Hospital_2> lists = getHospital_2(10,new String[]{year});

		for(Hospital_2 list:lists){
			Map<String, Object> financial_type = new HashMap<String, Object>();
			financial_type.put("hospital",list.gethospital());
			financial_type.put("department",list.getdepartment());
			financial_type.put("doctor",list.getdoctor());
			financial_type.put("num",list.getHospital_num());
			result.add(financial_type);
		}
		int offset = (Integer.valueOf(p).intValue() - 1) * PAGE_NUM;
		int len = offset+PAGE_NUM;
		if(len > result.size()) {
			len = result.size();
		}
		pages=result.size()<=PAGE_NUM?1:result.size()/PAGE_NUM+1;
		result=result.subList(offset, len);
		data.put("pageCount",pages);
		data.put("data", result);
		return data;
	}

	@Override
	public Map<String, Object> getDoctorPercent(String startTime, String endTime, String p) {
		int pages = 0;
		final int days = (Integer.parseInt(endTime)-Integer.parseInt(startTime)+1)*365;
		Map<String, Object> data = new HashMap<String, Object>();
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		List<Hospital_2> lists = getHospital_2(11,new String[]{startTime,endTime});
		//将全部的Hospital_2按人数排序
		Collections.sort(lists, new Comparator<Hospital_2>() {
			public int compare(Hospital_2 o1, Hospital_2 o2) {
				return o1.getRate(days).compareTo(o2.getRate(days));
			}
		});

		for(Hospital_2 list:lists){
			Map<String, Object> financial_type = new HashMap<String, Object>();
			financial_type.put("hospital",list.gethospital());
			financial_type.put("department",list.getdepartment());
			financial_type.put("doctor",list.getdoctor());
			double num = (double)(list.getSum()*100)/((double)(list.getSim())*days);
			BigDecimal b = new BigDecimal(num);
			financial_type.put("num",b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
			result.add(financial_type);
		}
		int offset = (Integer.valueOf(p).intValue() - 1) * PAGE_NUM;
		int len = offset+PAGE_NUM;
		if(len > result.size()) {
			len = result.size();
		}
		pages=result.size()<=PAGE_NUM?1:result.size()/PAGE_NUM+1;
		result=result.subList(offset, len);
		data.put("pageCount",pages);
		data.put("data", result);
		return data;
	}
}
