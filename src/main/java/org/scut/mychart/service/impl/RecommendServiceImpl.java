package org.scut.mychart.service.impl;

import org.scut.mychart.mapper.RecommendMapper;
import org.scut.mychart.model.RecommendResultModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gzw
 */
@Service("recommendService")
public class RecommendServiceImpl  {
    @Resource  
    private RecommendMapper recommendDao;

    public List<RecommendResultModel> getRecommendResult(String id){
    	HashMap<String,String> param = new HashMap<String,String>();
    	param.put("id",id);
    	return recommendDao.selectRecommendResult(param);
    }
    public Map<String, Object> getResult(String id){
    	Map<String,Object> result=new HashMap<String,Object>();
    	HashMap<String,String> param = new HashMap<String,String>();
    	param.put("id",id);
//    	List<RecommendResultModel> resultModels  =new ArrayList<>();
    	List<RecommendResultModel> rating = recommendDao.selectRecommendRating(param);
    	List<RecommendResultModel> place=recommendDao.selectPlaceInfo();
    	List<RecommendResultModel> exinfo=recommendDao.selectExInfo();
    	
    	int place_size=place.size();
    	System.out.println(place_size);
    	int total_size = rating.size();
    	System.out.println(total_size);
    	int ex_size=exinfo.size();
    	System.out.println(ex_size);

    	for( int i =0;i<total_size;i++){
    		for(int j=0;j<place_size;j++){		
    			if(place.get(j).getEx_id().trim().equals(rating.get(i).getC_city_id().trim())){
    				rating.get(i).setC_city_id(place.get(j).getEx_name());
    			}
    		}
        	

    		if(rating.get(i).getSex()=="1"){
    			rating.get(i).setSex("男性");
    		}
    		else{
    			rating.get(i).setSex("女性");
    		}
    		for(int j = 0;j<ex_size;j++){
// 人的详细信息
    			if(rating.get(i).getHistory_job1().equals(exinfo.get(j).getEx_id())){
    				rating.get(i).setHistory_job1(exinfo.get(j).getEx_name());
    			}
    			if(rating.get(i).getHistory_job2().equals(exinfo.get(j).getEx_id())){
    				rating.get(i).setHistory_job2(exinfo.get(j).getEx_name());
    			}
    			if(rating.get(i).getHistory_job3().equals(exinfo.get(j).getEx_id())){
    				rating.get(i).setHistory_job3(exinfo.get(j).getEx_name());
    			}
    			if(rating.get(i).getHistory_job4().equals(exinfo.get(j).getEx_id())){
    				rating.get(i).setHistory_job4(exinfo.get(j).getEx_name());
    			}
    			if(rating.get(i).getHistory_job5().equals(exinfo.get(j).getEx_id())){
    				rating.get(i).setHistory_job5(exinfo.get(j).getEx_name());
    			}
    			
    			if(rating.get(i).getIntend_job1().equals(exinfo.get(j).getEx_id())){
    				rating.get(i).setIntend_job1(exinfo.get(j).getEx_name());
    			}
    			if(rating.get(i).getIntend_job2().equals(exinfo.get(j).getEx_id())){
    				rating.get(i).setIntend_job2(exinfo.get(j).getEx_name());
    			}
    			if(rating.get(i).getIntend_job3().equals(exinfo.get(j).getEx_id())){
    				rating.get(i).setIntend_job3(exinfo.get(j).getEx_name());
    			}
    			if(rating.get(i).getIntend_job4().equals(exinfo.get(j).getEx_id())){
    				rating.get(i).setIntend_job4(exinfo.get(j).getEx_name());
    			}
    			if(rating.get(i).getIntend_job5().equals(exinfo.get(j).getEx_id())){
    				rating.get(i).setIntend_job5(exinfo.get(j).getEx_name());
    			}
    			if(rating.get(i).getJob_way_id().equals(exinfo.get(j).getEx_id())){
    				rating.get(i).setJob_way_id(exinfo.get(j).getEx_name());
    			}
    			if(rating.get(i).getEducation_id().equals(exinfo.get(j).getEx_id())){
    				rating.get(i).setEducation_id(exinfo.get(j).getEx_name());
    			}
    			
    			//企业替换
    			if(rating.get(i).getC_job_type_id().equals(exinfo.get(j).getEx_id())){
    				rating.get(i).setC_job_type_id(exinfo.get(j).getEx_name());
    			}
    			if(rating.get(i).getC_job_way_id().equals(exinfo.get(j).getEx_id())){
    				rating.get(i).setC_job_way_id(exinfo.get(j).getEx_name());
    			}
    			if(rating.get(i).getC_wage_way().equals(exinfo.get(j).getEx_id())){
    				rating.get(i).setC_wage_way(exinfo.get(j).getEx_name());
    			}
    			if(rating.get(i).getC_education_id().equals(exinfo.get(j).getEx_id())){
    				rating.get(i).setC_education_id(exinfo.get(j).getEx_name());
    			}
    			
    		}
    	}
//    	System.out.println('1');
//    	for(int j=1;j<place_size;j++){		
//			System.out.println('2');
//			System.out.println(place.get(j).getEx_id().trim());
//    		System.out.println(place.get(j).getEx_name());
//    	
//		}
    	
    		
    
    	

    	result.put("data", rating);
    	return result;
    	
    }
}

