package org.scut.mychart.service;

import java.util.Map;

/**
 * Created by Allen on 2017/1/9.
 */
public interface IExternalListService {
    public Map<String,Object>getExternalHospitalTotal(String year,String p);
    public Map<String, Object> getExternalHospitalPercent(String startTime, String endTime, String p);

    public Map<String, Object> getExternalDepartmentTotal(String year, String p);

    public Map<String, Object> getExternalDepartmentPercent(String startTime, String endTime, String p);

    public Map<String, Object> getExternalDoctorTotal(String year, String p);

    public Map<String, Object> getExternalDoctorPercent(String startTime, String endTime, String p);
}
