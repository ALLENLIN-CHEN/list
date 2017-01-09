package org.scut.mychart.service.impl;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.*;
import com.github.abel533.echarts.data.PointData;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.json.GsonUtil;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Funnel;
import com.github.abel533.echarts.series.Line;
import org.codehaus.groovy.runtime.dgmimpl.NumberNumberMultiply;
import org.scut.mychart.mapper.IndustryMapper;
import org.scut.mychart.model.CompanyModel;
import org.scut.mychart.model.IndustryModel;
import org.scut.mychart.service.IndustryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.*;

@Service("industryServiceImpl")
public class IndustryServiceImpl implements IndustryService {

    @Resource
    private IndustryMapper industryMapper;
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


    public HashMap<String, List<IndustryModel>> getMapResult(List<IndustryModel> total) {
        HashMap<String, List<IndustryModel>> result = new HashMap<String, List<IndustryModel>>();

        for (int i = 0; i < total.size(); i++) {
            IndustryModel i3 = total.get(i);
            List<IndustryModel> yearList=result.get(i3.getYear().toString());
            if (yearList == null) {
                yearList=new ArrayList<IndustryModel>();
            }
            yearList.add(i3);
            result.put(i3.getYear().toString(), yearList);
        }
        return result;
    }
    public double getSum(List<IndustryModel> total){
        double sum=0;
        for(IndustryModel i:total){
            sum+=i.getPerson_num();
        }
        return  sum;
    }
    public List<String> getIndustryNameList(){
        List<String> result=new ArrayList<String>();
        List<IndustryModel> industryModelList=industryMapper.selectIndustry(null);
        for(IndustryModel i:industryModelList){
            result.add(i.getIndustry_code());
        }
        return result;
    }
    public Map<String, Object> getIndustry_LineOption(String industry_code) {

        List<IndustryModel> totalList = null;
        if (industry_code != null) {
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("industry_code", industry_code);
            totalList = industryMapper.selectByGender(param);
        } else {
            industry_code="全行业";
            totalList = industryMapper.selectByGenderAll(null);
        }

        Map<String, Object> resultdata=new HashMap<>();
        resultdata.put("industry_code",industry_code);
        resultdata.put("industrylist",totalList);
        return resultdata;
    }

    public Map<String, Object> getIndustry_FunnelOption(String industry_code) {
        List<IndustryModel> totalList = null;
        if (industry_code != null) {
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("industry_code", industry_code);
            totalList = industryMapper.selectByAge(param);
        } else {
            industry_code="全行业";
            totalList = industryMapper.selectByAgeAll(null);
        }
        HashMap<String, List<IndustryModel>> result = this.getMapResult(totalList);
        List yearlist = Arrays.asList(result.keySet().toArray());
        Collections.sort(yearlist);
        List sumlist=new ArrayList<Double>();
        for (int i = 0; i < yearlist.size(); i++) {
            String year=yearlist.get(i).toString();
            List<IndustryModel> dataList=result.get(year);
            double temp_sum = getSum(dataList);
            sumlist.add(temp_sum);
        }
        Map<String, Object> resultdata=new HashMap<>();
        resultdata.put("yearlist",yearlist);
        resultdata.put("sumlist",sumlist);
        resultdata.put("industry_code",industry_code);
        resultdata.put("industrymap",result);
        return resultdata;
    }

    public Map<String, Object> getIndustry_BarOption() {
        Map<String, Object> resultdata=new HashMap<>();
        List<IndustryModel> totalList = industryMapper.selectOrderByCardinality(null);
        HashMap<String, List<IndustryModel>> result = this.getMapResult(totalList);
        List yearlist = Arrays.asList(result.keySet().toArray());
        Collections.sort(yearlist);

        resultdata.put("yearlist",yearlist);
        resultdata.put("industrymap",result);
        return resultdata;
    }

    public Map<String, Object> getListDataOrderByCardinality(String year, String p){
        Map<String, Object> result = new HashMap<String, Object>();

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
        List<IndustryModel> totalList = industryMapper.selectListOrderByCardinality(param);
        int pageCount = getPageCount(totalList.size());

        Map<String, Double> allRank = new HashMap<String, Double>();
        DecimalFormat df = new DecimalFormat("#.##");
        for(IndustryModel m : totalList) {
            allRank.put(m.getIndustry_code(), Double.valueOf(df.format(m.getCardinality())));
        }

        List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String,Double>>(allRank.entrySet());
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

}
