package org.scut.mychart.service;

import java.util.Map;

public interface ClinicService {
	public Map<String, Object> getHospitalTotal(String year, String p);
	
	public Map<String, Object> getDepartmentTotal(String year, String p);
	
	public Map<String, Object> getDoctorTotal(String year, String p);	
}
