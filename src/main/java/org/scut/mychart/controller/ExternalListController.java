package org.scut.mychart.controller;

import org.scut.mychart.service.IExternalListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


/**
 * Created by Allen on 2017/1/10.
 */
@Controller
@RequestMapping(value = "/charts/externalList", produces="application/json;charset=UTF-8")
public class ExternalListController {

    @Autowired
    private IExternalListService iExternalListService;

    @RequestMapping("/hospitalTotal")
    @ResponseBody
    public Map<String, Object> getHospitalTotal(@RequestParam String year, @RequestParam String p){
        Map<String, Object> result = iExternalListService.getExternalHospitalTotal(year, p);
        return result;
    }

    @RequestMapping("/hospitalPercent")
    @ResponseBody
    public Map<String, Object> getHospitalPercent(@RequestParam String startTime, @RequestParam String endTime, @RequestParam String p){
        Map<String, Object> result = iExternalListService.getExternalHospitalPercent(startTime, endTime, p);
        return result;
    }

    @RequestMapping("/departmentTotal")
    @ResponseBody
    public Map<String, Object> getDepartmentTotal(@RequestParam String year, @RequestParam String p){
        Map<String, Object> result = iExternalListService.getExternalDepartmentTotal(year, p);
        return result;
    }

    @RequestMapping("/departmentPercent")
    @ResponseBody
    public Map<String, Object> getDepartmentPercent(@RequestParam String startTime, @RequestParam String endTime, @RequestParam String p){
        Map<String, Object> result = iExternalListService.getExternalDepartmentPercent(startTime, endTime, p);
        return result;
    }

    @RequestMapping("/doctorTotal")
    @ResponseBody
    public Map<String, Object> getDoctorTotal(@RequestParam String year, @RequestParam String p){
        Map<String, Object> result = iExternalListService.getExternalDoctorTotal(year, p);
        return result;
    }

    @RequestMapping("/doctorPercent")
    @ResponseBody
    public Map<String, Object> getDocotorPercent(@RequestParam String startTime, @RequestParam String endTime, @RequestParam String p){
        Map<String, Object> result = iExternalListService.getExternalDoctorPercent(startTime, endTime, p);
        return result;
    }
}
