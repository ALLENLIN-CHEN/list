package org.scut.mychart.mapper;

import java.util.List;
import java.util.Map;

import org.scut.mychart.model.ClinicModel;

public interface ClinicMapper {	

	public List<ClinicModel> getHospitalTotal(Map<String, Object> param);
	
	public int getHospitalCount(Map<String, Object> param);
	
	public List<ClinicModel> getDepartmentTotal(Map<String, Object> param);
	
	public int getDepartmentCount(Map<String, Object> param);
	
	public List<ClinicModel> getDoctorTotal(Map<String, Object> param);
	
	public int getDoctorCount(Map<String, Object> param);
	
}
