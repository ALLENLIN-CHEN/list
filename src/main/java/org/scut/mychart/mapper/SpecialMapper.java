package org.scut.mychart.mapper;

import org.scut.mychart.model.SpecialModel;
import java.util.List;
import java.util.Map;


/**
 * Created by linqidi on 2016/12/9.
 */
public interface SpecialMapper {
    public List<SpecialModel> getCountByGender(String business);

    public List<SpecialModel> getAreaCoverage(String business);

    public List<SpecialModel> getAgeRange(String business);

    public List<SpecialModel> getHospitalTotal(String business);

    public List<SpecialModel> getHospitalTotalList(Map<String, Object> param);

    public int getHospitalTotalCount(Map<String, Object> param);

    public List<SpecialModel> getHospitalByTime(String business, String startTime, String endTime);

    public List<SpecialModel> getHospitalMaxByDay(String business, String startTime, String endTime);

    public List<SpecialModel> getDepartmentTotal(Map<String, Object> param);

    public int getDepartmentCount(Map<String, Object> param);

    public List<SpecialModel> getDepartmentByTime(String business, String startTime, String endTime);

    public List<SpecialModel> getDepartmentMaxByDay(String business, String startTime, String endTime);

    public List<SpecialModel> getAreaByYear();

}
