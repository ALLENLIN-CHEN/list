package org.scut.mychart.mapper;

import java.util.List;
import java.util.Map;

import org.scut.mychart.model.CompanyModel;

public interface CompanyMapper {
	
	public List<CompanyModel> getCountByGender();

	public List<CompanyModel> getAgeRange();

	public List<CompanyModel> getCompanyInsuranceTotal(Map<String, Object> param);

	public List<CompanyModel> getCompanyInsurancePersonTotal(Map<String, Object> param);
	
}
