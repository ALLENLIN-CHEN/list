package org.scut.mychart.mapper;

import java.util.List;
import java.util.Map;

import org.scut.mychart.model.RegisterModel;

public interface RegisterMapper {
	
	public List<RegisterModel> getCountByGender(String business);
	
	public List<RegisterModel> getAreaCoverage(String business);

	public List<RegisterModel> getAgeRange(String business);

	public List<RegisterModel> getHospitalTotal(String business);

	public List<RegisterModel> getHospitalTotalList(Map<String, Object> param);
	
	public int getHospitalTotalCount(Map<String, Object> param);

	public List<RegisterModel> getHospitalByTime(String business, String startTime, String endTime);

	public List<RegisterModel> getHospitalMaxByDay(String business, String startTime, String endTime);

	public List<RegisterModel> getDepartmentTotal(Map<String, Object> param);
	
	public int getDepartmentCount(Map<String, Object> param);
	
	public List<RegisterModel> getDepartmentByTime(String business, String startTime, String endTime);

	public List<RegisterModel> getDepartmentMaxByDay(String business, String startTime, String endTime);
	
	public List<RegisterModel> getDoctorTotal(Map<String, Object> param);
	
	public int getDoctorCount(Map<String, Object> param);
	
	public List<RegisterModel> getDoctorByTime(String business, String startTime, String endTime);

	public List<RegisterModel> getDoctorMaxByDay(String business, String startTime, String endTime);
	
	public List<RegisterModel> getAreaByYear();
}
