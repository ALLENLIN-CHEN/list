package org.scut.mychart.controller;

import org.scut.mychart.model.RecommendResultModel;
import org.scut.mychart.service.impl.RecommendServiceImpl;
import org.scut.mychart.util.JSONUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gzw
 */
@Controller
@RequestMapping(value = "/recommend")
public class RecommendController {
    @Resource
    private RecommendServiceImpl recommendService;

    /**
     * 获取推荐结果
     * @param id
     * @return
     */
    @RequestMapping(value = "/result",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> getChartMap3dMarkBarOption(@RequestParam("id") String id){
        Map<String,Object> result=new HashMap<String,Object>();
        List<RecommendResultModel> recommendResultModelList =recommendService.getRecommendResult(id);
        result.put("data",recommendResultModelList);
        return result;
    }

    @RequestMapping(value = "/personsid",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object> getPersonsID(){
        Map<String,Object> result = new HashMap<String,Object>();
        Map<String,String> allpersons = new HashMap<>();
        List<String> persons = recommendService.getAllPersons();
//        for(int i=0;i<persons.size();i++)
//            result.put(persons.get(i).getPerson_id(),persons.get(i).getPerson_id());
        for(int i=0;i<persons.size();i++)
            allpersons.put(persons.get(i),persons.get(i));
        result.put("result",allpersons);
        return  result;
    }

}   

