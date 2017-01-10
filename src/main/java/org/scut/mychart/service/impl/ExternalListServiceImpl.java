package org.scut.mychart.service.impl;

import org.scut.mychart.mapper.ExternalListMapper;
import org.scut.mychart.model.ExternalList;

import org.scut.mychart.service.IExternalListService;
import org.scut.mychart.util.DictionaryString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by Allen on 2017/1/9.
 */
@Service
public class ExternalListServiceImpl implements IExternalListService {
    @Autowired
    private ExternalListMapper externalListMapper;

    private final static int PAGE_NUM = 15;

    @Override
    public Map<String, Object> getExternalHospitalTotal(String year, String p) {
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        String stime = "";
        String etime = "";
        if(!year.equalsIgnoreCase("all")) {
            stime = year + "-01-01";
            etime = year + "-12-31";
            param.put("stime", stime);
            param.put("etime", etime);
        }else {
            stime = "2010-01-01";
            etime = "2015-12-31";
            param.put("stime", stime);
            param.put("etime", etime);
        }

        int offset = (Integer.valueOf(p).intValue() - 1) * PAGE_NUM;
        param.put("offset", offset);
        List<ExternalList> data = externalListMapper.selectExternalHospitalList(param);
        int total = externalListMapper.selectExternalHospitalCount(param);

        int pageCount = getPageCount(total);

        result.put("data", data);
        result.put("pageCount", pageCount);
        return result;
    }

    @Override
    public Map<String, Object> getExternalHospitalPercent(String startTime, String endTime, String p) {
        Map<String, Object> result = new HashMap<String, Object>();
        String stime = startTime + "-01-01";
        String etime = endTime + "-12-31";
        List<ExternalList> total = externalListMapper.selectExternalHospitalByTime(DictionaryString.BUSINESS_EXTERNAL, stime, etime);
        List<ExternalList> day = externalListMapper.selectExternalHospitalMaxByDay(DictionaryString.BUSINESS_EXTERNAL, stime, etime);
        Map<String, Double> per = new HashMap<String, Double>();

        int pageCount = getPageCount(total.size());

        DecimalFormat df = new DecimalFormat("#.##");
        double calPer = 0.0;
        ExternalList d = null;
        int index = 0;
        int days = Integer.valueOf(endTime) - Integer.valueOf(startTime) + 1;
        for(ExternalList m : total) {
            d = day.get(index);
            calPer = (double)m.getSum() / (d.getMaxNum() * 365 * days) * 100;
            per.put(m.getHospital(), Double.valueOf(df.format(calPer)));
            index++;
        }

        /**
         * 用于排序
         */
        List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String,Double>>(per.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {

            @Override
            public int compare(Map.Entry<String, Double> o1,
                               Map.Entry<String, Double> o2) {
                if(o2.getValue() - o1.getValue() >= 0) {
                    return 1;
                }else {
                    return -1;
                }
            }
        });

        int offset = (Integer.valueOf(p).intValue() - 1) * PAGE_NUM;
        int len = offset+PAGE_NUM;
        if(len > list.size()) {
            len = list.size();
        }
        list = list.subList(offset, len);

        result.put("pageCount", pageCount);
        result.put("data", list);
        return result;
    }

    @Override
    public Map<String, Object> getExternalDepartmentTotal(String year, String p) {
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        String stime = "";
        String etime = "";
        if(!year.equalsIgnoreCase("all")) {
            stime = year + "-01-01";
            etime = year + "-12-31";
            param.put("stime", stime);
            param.put("etime", etime);
        }else {
            stime = "2010-01-01";
            etime = "2015-12-31";
            param.put("stime", stime);
            param.put("etime", etime);
        }

        int offset = (Integer.valueOf(p).intValue() - 1) * PAGE_NUM;
        param.put("offset", offset);

        List<ExternalList> data = externalListMapper.selectExternalDepartmentList(param);
        int total = externalListMapper.selectExternalDepartmentCount(param);
        int pageCount = getPageCount(total);

        result.put("data", data);
        result.put("pageCount", pageCount);
        return result;
    }

    @Override
    public Map<String, Object> getExternalDepartmentPercent(String startTime, String endTime, String p) {
        Map<String, Object> result = new HashMap<String, Object>();
        String stime = startTime + "-01-01";
        String etime = endTime + "-12-31";
        List<ExternalList> total = externalListMapper.selectExternalDepartmentByTime(DictionaryString.BUSINESS_EXTERNAL, stime, etime);
        List<ExternalList> day = externalListMapper.selectExternalDepartmentMaxByDay(DictionaryString.BUSINESS_EXTERNAL, stime, etime);
        Map<String, Double> per = new HashMap<String, Double>();

        int pageCount = getPageCount(total.size());

        Map<String, Integer> totalMap = new HashMap<String, Integer>();
        for(ExternalList m : total) {
            String key = m.getHospital() + "-" + m.getDepartment();
            if(!totalMap.containsKey(key)) {
                totalMap.put(key, m.getSum());
            }
        }

        DecimalFormat df = new DecimalFormat("#.##");
        double calPer = 0.0;
        int days = Integer.valueOf(endTime) - Integer.valueOf(startTime) + 1;
        for(ExternalList m : day) {
            String key = m.getHospital() + "-" + m.getDepartment();
            if(totalMap.containsKey(key)) {
                calPer = (double)totalMap.get(key) / (m.getMaxNum() * 365 * days) * 100;
                per.put(key, Double.valueOf(df.format(calPer)));
            }
        }

        /**
         * 用于排序
         */
        List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String,Double>>(per.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {

            @Override
            public int compare(Map.Entry<String, Double> o1,
                               Map.Entry<String, Double> o2) {
                if(o1 == null && o2 == null) {
                    return 0;
                }
                if(o1 == null) {
                    return -1;
                }
                if(o2 == null) {
                    return 1;
                }
                if(o2.getValue() - o1.getValue() > 0) {
                    return 1;
                }
                if(o1.getValue() - o2.getValue() > 0){
                    return -1;
                }
                if(o2.getValue() - o1.getValue() == 0) {
                    return 0;
                }
                return 0;
            }
        });

        int offset = (Integer.valueOf(p).intValue() - 1) * PAGE_NUM;
        int len = offset+PAGE_NUM;
        if(len > list.size()) {
            len = list.size();
        }
        list = list.subList(offset, len);

        result.put("pageCount", pageCount);
        result.put("data", list);
        return result;
    }

    @Override
    public Map<String, Object> getExternalDoctorTotal(String year, String p) {
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        String stime = "";
        String etime = "";
        if(!year.equalsIgnoreCase("all")) {
            stime = year + "-01-01";
            etime = year + "-12-31";
            param.put("stime", stime);
            param.put("etime", etime);
        }else {
            stime = "2010-01-01";
            etime = "2015-12-31";
            param.put("stime", stime);
            param.put("etime", etime);
        }

        int offset = (Integer.valueOf(p).intValue() - 1) * PAGE_NUM;
        param.put("offset", offset);

        List<ExternalList> data = externalListMapper.selectExternalDoctorList(param);

        int total = externalListMapper.selectExternalDoctorCount(param);
        int pageCount = getPageCount(total);

        result.put("pageCount", pageCount);
        result.put("data", data);
        return result;
    }

    @Override
    public Map<String, Object> getExternalDoctorPercent(String startTime, String endTime, String p) {
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        Map<String, Object> result = new HashMap<String, Object>();
        String stime = startTime + "-01-01";
        String etime = endTime + "-12-31";
        List<ExternalList> total = externalListMapper.selectExternalDoctorByTime(DictionaryString.BUSINESS_EXTERNAL, stime, etime);
        List<ExternalList> day = externalListMapper.selectExternalDoctorMaxByDay(DictionaryString.BUSINESS_EXTERNAL, stime, etime);
        Map<String, Double> per = new HashMap<String, Double>();

        int pageCount = getPageCount(total.size());

        Map<String, Integer> totalMap = new HashMap<String, Integer>();
        for(ExternalList m : total) {
            String key = m.getHospital() + "-" + m.getDepartment() + "-" + m.getDoctor();
            if(!totalMap.containsKey(key)) {
                totalMap.put(key, m.getSum());
            }
        }

        DecimalFormat df = new DecimalFormat("#.##");
        double calPer = 0.0;
        int days = Integer.valueOf(endTime) - Integer.valueOf(startTime) + 1;
        for(ExternalList m : day) {
            String key = m.getHospital() + "-" + m.getDepartment() + "-" + m.getDoctor();
            if(totalMap.containsKey(key)) {
                calPer = (double)totalMap.get(key) / (m.getMaxNum() * 365 * days) * 100;
                per.put(key, Double.valueOf(df.format(calPer)));
            }
        }

        /**
         * 用于排序
         */
        List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String,Double>>(per.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {

            @Override
            public int compare(Map.Entry<String, Double> o1,
                               Map.Entry<String, Double> o2) {
                if(o1 == null && o2 == null) {
                    return 0;
                }
                if(o1 == null) {
                    return -1;
                }
                if(o2 == null) {
                    return 1;
                }
                if(o2.getValue() - o1.getValue() > 0) {
                    return 1;
                }
                if(o1.getValue() - o2.getValue() > 0){
                    return -1;
                }
                if(o2.getValue() - o1.getValue() == 0) {
                    return 0;
                }
                return 0;
            }
        });

        int offset = (Integer.valueOf(p).intValue() - 1) * PAGE_NUM;
        int len = offset+PAGE_NUM;
        if(len > list.size()) {
            len = list.size();
        }
        list = list.subList(offset, len);

        result.put("pageCount", pageCount);
        result.put("data", list);
        return result;
    }

    /**
     * 用于返回总页数
     * @param total
     * @return
     */
    private int getPageCount(int total) {
        int pageCount = 0;
        if(total < PAGE_NUM) {
            pageCount = 1;
        } else {
            int rest = total % PAGE_NUM;
            pageCount = total / PAGE_NUM;
            if(rest > 0) {
                pageCount++;
            }
        }
        return pageCount;
    }

}


