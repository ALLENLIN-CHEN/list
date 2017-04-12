package org.scut.mychart.service;

import java.util.Map;

public interface ExpenseService {

    public Map<String, Object> getHospitalTotal(String year, String p);

    public Map<String, Object> getHospitalPercent(String startTime, String endTime, String p);

    public Map<String, Object> getDepartmentTotal(String year, String p);

    public Map<String, Object> getDepartmentPercent(String startTime, String endTime, String p);
}
