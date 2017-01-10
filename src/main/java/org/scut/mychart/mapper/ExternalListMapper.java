package org.scut.mychart.mapper;

import org.scut.mychart.model.ExternalList;

import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2017/1/9.
 */
public interface ExternalListMapper {
    List<ExternalList>selectExternalHospitalList(Map<String,Object>param);
    public int selectExternalHospitalCount(Map<String,Object>param);
    List<ExternalList>selectExternalHospitalByTime(String business,String startTime,String endTime);
    List<ExternalList>selectExternalHospitalMaxByDay(String business,String startTime,String endTime);

    List<ExternalList>selectExternalDepartmentList(Map<String,Object>param);
    public int selectExternalDepartmentCount(Map<String,Object>param);
    List<ExternalList>selectExternalDepartmentByTime(String business,String startTime,String endTime);
    List<ExternalList>selectExternalDepartmentMaxByDay(String business,String startTime,String endTime);

    List<ExternalList>selectExternalDoctorList(Map<String,Object>param);
    public int selectExternalDoctorCount(Map<String,Object>param);
    List<ExternalList>selectExternalDoctorByTime(String business,String startTime,String endTime);
    List<ExternalList>selectExternalDoctorMaxByDay(String business,String startTime,String endTime);
}
