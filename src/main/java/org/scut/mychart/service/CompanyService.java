package org.scut.mychart.service;

import java.util.Map;


public interface CompanyService {
	
	public Map<String, Object> getCountByGender();
	
	public Map<String, Object> getAgeRange();
	
	public Map<String, Object> getCompany(String year, String p);
	
}
