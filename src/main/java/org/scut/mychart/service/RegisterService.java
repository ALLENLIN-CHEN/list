package org.scut.mychart.service;

import java.util.Map;


public interface RegisterService {
	public Map<String, Object> getCountByGender();
	
	public Map<String, Object> getCountByGenderLine();

	public Map<String, Object> getAreaCoverage();

	public Map<String, Object> getAgeRange();

	public Map<String, Object> getHospitalTotal(String year, String p);

	public Map<String, Object> getHospitalPercent(String startTime, String endTime, String p);

	public Map<String, Object> getDepartmentTotal(String year, String p);
	
	public Map<String, Object> getDepartmentPercent(String startTime, String endTime, String p);

	public Map<String, Object> getDoctorTotal(String year, String p);

	public Map<String, Object> getDoctorPercent(String startTime, String endTime, String p);
	
}
