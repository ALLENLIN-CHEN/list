package org.scut.mychart.service;

import java.util.Map;

/**
 * Created by linqidi on 2016/12/9.
 */
public interface SpecialService {
    public Map<String, Object> getCountByGender();

    public Map<String, Object> getCountByGenderLine();

    public Map<String, Object> getAreaCoverage();

    public Map<String, Object> getAgeRange();

    public Map<String, Object> getHospitalTotal(String year, String p);

    public Map<String, Object> getHospitalPercent(String startTime, String endTime, String p);

    public Map<String, Object> getDepartmentTotal(String year, String p);

    public Map<String, Object> getDepartmentPercent(String startTime, String endTime, String p);
}
