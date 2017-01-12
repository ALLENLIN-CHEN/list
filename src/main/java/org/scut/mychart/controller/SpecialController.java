package org.scut.mychart.controller;
import org.scut.mychart.service.SpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
/**
 * Created by linqidi on 2016/12/9.
 */
@Controller
@RequestMapping(value="/charts/special", produces="application/json;charset=UTF-8")
public class SpecialController {
    @Autowired
    private SpecialService specialService;

    @RequestMapping("/countByGender")
    @ResponseBody
    public Map<String, Object> getCountByGender() {
        Map<String, Object> result = specialService.getCountByGender();
        return result;
    }

    @RequestMapping("/countByGenderLine")
    @ResponseBody
    public Map<String, Object> getCountByGenderLine() {
        Map<String, Object> result = specialService.getCountByGenderLine();
        return result;
    }

    @RequestMapping("/areaCoverage")
    @ResponseBody
    public Map<String, Object> getAreaCoverage() {
        Map<String, Object> result = specialService.getAreaCoverage();
        return result;
    }

    @RequestMapping("/ageRange")
    @ResponseBody
    public Map<String, Object> getAgeRange() {
        Map<String, Object> result = specialService.getAgeRange();
        return result;
    }

    @RequestMapping("/hospitalTotal")
    @ResponseBody
    public Map<String, Object> getHospitalTotal(@RequestParam String year, @RequestParam String p){
        Map<String, Object> result = specialService.getHospitalTotal(year, p);
        return result;
    }

    @RequestMapping("/hospitalPercent")
    @ResponseBody
    public Map<String, Object> getHospitalPercent(@RequestParam String startTime, @RequestParam String endTime, @RequestParam String p){
        Map<String, Object> result = specialService.getHospitalPercent(startTime, endTime, p);
        return result;
    }

    @RequestMapping("/departmentTotal")
    @ResponseBody
    public Map<String, Object> getDepartmentTotal(@RequestParam String year, @RequestParam String p){
        Map<String, Object> result = specialService.getDepartmentTotal(year, p);
        return result;
    }

    @RequestMapping("/departmentPercent")
    @ResponseBody
    public Map<String, Object> getDepartmentPercent(@RequestParam String startTime, @RequestParam String endTime, @RequestParam String p){
        Map<String, Object> result = specialService.getDepartmentPercent(startTime, endTime, p);
        return result;
    }
}