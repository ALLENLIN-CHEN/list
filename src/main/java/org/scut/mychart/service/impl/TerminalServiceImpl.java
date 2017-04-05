package org.scut.mychart.service.impl;


import org.scut.mychart.mapper.TerminalMapper;
import org.scut.mychart.model.TerminalModel;
import org.scut.mychart.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service("terminalService")
public class TerminalServiceImpl implements TerminalService {

    @Autowired
    private TerminalMapper terminalMapper;
    private final static int PAGE_NUM = 15;
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
    public Map<String, Object> getTerminalType(String year, String p) {
        Map<String, String> param = new HashMap<String, String>();
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

        List<TerminalModel> totalList = terminalMapper.selectTerminalType(param);
        int pageCount = getPageCount(totalList.size());
        int offset = (Integer.valueOf(p).intValue() - 1) * PAGE_NUM;
        int len = offset+PAGE_NUM;
        if(len > totalList.size()) {
            len = totalList.size();
        }
        totalList = totalList.subList(offset, len);
        Map<String, Object> result=new HashMap<>();
        result.put("pageCount", pageCount);
        result.put("data", totalList);
        return result;
    }
    public Map<String, Object> getTerminalBusiness(String year, String p) {
        Map<String, String> param = new HashMap<String, String>();
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
        List<TerminalModel> totalList = terminalMapper.selectTerminalBusiness(param);
        int pageCount = getPageCount(totalList.size());

        int offset = (Integer.valueOf(p).intValue() - 1) * PAGE_NUM;
        int len = offset+PAGE_NUM;
        if(len > totalList.size()) {
            len = totalList.size();
        }
        totalList = totalList.subList(offset, len);
        Map<String, Object> result=new HashMap<>();
        result.put("pageCount", pageCount);
        result.put("data", totalList);
        return result;
    }
    public Map<String, Object> getTerminalStatus(String year, String p) {
        Map<String, String> param = new HashMap<String, String>();
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
        int days=-1;
        List<TerminalModel> totalList = terminalMapper.selectTerminalStatus(param);
        int pageCount = getPageCount(totalList.size());
        try {
            java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
            Date sdate =  formatter.parse(stime);
            Date edate =  formatter.parse(etime);
            days= (int)((edate.getTime()-sdate.getTime())/(24*3600*1000))+1;
        }catch (Exception o){
            o.printStackTrace();
        }

        for(TerminalModel m : totalList) {
            m.setErrorDays(days-m.getValue());
        }
        int offset = (Integer.valueOf(p).intValue() - 1) * PAGE_NUM;
        int len = offset+PAGE_NUM;
        if(len > totalList.size()) {
            len = totalList.size();
        }
        totalList = totalList.subList(offset, len);
        Map<String, Object> result=new HashMap<>();
        result.put("pageCount", pageCount);
        result.put("data", totalList);
        return result;
    }
}
