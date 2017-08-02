package org.scut.mychart.controller;

import org.scut.mychart.service.impl.Recommend2ServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author gzw
 */
@Controller
@RequestMapping(value = "/recommend2")
public class Recommend2Controller {
    @Resource
    private Recommend2ServiceImpl recommend2Service;

    /**
     * 获取推荐结果
     * @param id
     * @return
     */


    
    @RequestMapping(value = "/result",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> getResults(@RequestParam("id") String id){
    	
        Map<String, Object> result = recommend2Service.getResult(id);
        return result;
    }
    
   



}

 

