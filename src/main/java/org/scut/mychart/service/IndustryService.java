package org.scut.mychart.service;

import java.util.List;
import java.util.Map;

public interface IndustryService  {
    public Map<String, Object> getIndustry_LineOption(String industry_code) ;
    public Map<String, Object> getIndustry_FunnelOption(String industry_code) ;
    public Map<String, Object> getIndustry_BarOption() ;
    public List<String> getIndustryNameList();
    public Map<String, Object> getListDataOrderByCardinality(String year, String p);
}
