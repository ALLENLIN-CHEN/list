package org.scut.mychart.service.impl;

import org.scut.mychart.mapper.Recommend2Mapper;
import org.scut.mychart.model.Recommend2ResultModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gzw
 */
@Service("recommend2Service")
public class Recommend2ServiceImpl {
    @Resource  
    private Recommend2Mapper recommendDao;

    public List<Recommend2ResultModel> getRecommendResult(String id){
    	HashMap<String,String> param = new HashMap<String,String>();
    	param.put("id",id);
    	return recommendDao.selectRecommendResult(param);
    }

    public Map<String, Object> getResult(String id){
    	Map<String,Object> result=new HashMap<String,Object>();
    	HashMap<String,String> param = new HashMap<String,String>();
    	param.put("id",id);
//    	List<RecommendResultModel> resultModels  =new ArrayList<>();
    	List<Recommend2ResultModel> rating = recommendDao.selectRecommend2Rating(param);

    	

    	int total_size = rating.size();
    	System.out.println(total_size);


    	for( int i =0;i<total_size;i++){

        	

    		if(rating.get(i).getSex()=="1"){
    			rating.get(i).setSex("男性");
    		}
    		else{
    			rating.get(i).setSex("女性");
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

    public List<String> getAllPersons(){
        return recommendDao.selectAllPersons();

    }
}

