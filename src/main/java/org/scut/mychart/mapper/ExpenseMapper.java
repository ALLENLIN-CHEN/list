package org.scut.mychart.mapper;

import org.scut.mychart.model.ExpenseModel;
import java.util.List;
import java.util.Map;

public interface ExpenseMapper {

    public List<ExpenseModel> getHospitalTotalList(Map<String, Object> param);

    public int getHospitalTotalCount(Map<String, Object> param);

    public List<ExpenseModel> getHospitalByTime(String business, String startTime, String endTime);

    public List<ExpenseModel> getHospitalMaxByDay(String business, String startTime, String endTime);

    public List<ExpenseModel> getDepartmentTotal(Map<String, Object> param);

    public int getDepartmentCount(Map<String, Object> param);

    public List<ExpenseModel> getDepartmentByTime(String business, String startTime, String endTime);

    public List<ExpenseModel> getDepartmentMaxByDay(String business, String startTime, String endTime);

    public List<ExpenseModel> getAreaByYear();

}
