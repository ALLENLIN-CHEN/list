package org.scut.mychart.controller;

import org.scut.mychart.service.impl.Recommend3ServiceImpl;
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
@RequestMapping(value = "/recommend3")
public class Recommend3Controller {
    @Resource
    private Recommend3ServiceImpl recommend3Service;

    /**
     * 获取推荐结果
     * @param id
     * @return
     */


    
    @RequestMapping(value = "/result",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> getResults(@RequestParam("id") String id){
    	
        Map<String, Object> result = recommend3Service.getResult(id);
        return result;
    }
    
   



}

 

