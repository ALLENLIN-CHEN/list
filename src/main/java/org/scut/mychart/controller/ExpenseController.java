package org.scut.mychart.controller;

import org.scut.mychart.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(value="/charts/expense", produces="application/json;charset=UTF-8")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @RequestMapping("/hospitalTotal")
    @ResponseBody
    public Map<String, Object> getHospitalTotal(@RequestParam String year, @RequestParam String p){
        Map<String, Object> result = expenseService.getHospitalTotal(year, p);
        return result;
    }

    @RequestMapping("/hospitalPercent")
    @ResponseBody
    public Map<String, Object> getHospitalPercent(@RequestParam String startTime, @RequestParam String endTime, @RequestParam String p){
        Map<String, Object> result = expenseService.getHospitalPercent(startTime, endTime, p);
        return result;
    }

    @RequestMapping("/departmentTotal")
    @ResponseBody
    public Map<String, Object> getDepartmentTotal(@RequestParam String year, @RequestParam String p){
        Map<String, Object> result = expenseService.getDepartmentTotal(year, p);
        return result;
    }

    @RequestMapping("/departmentPercent")
    @ResponseBody
    public Map<String, Object> getDepartmentPercent(@RequestParam String startTime, @RequestParam String endTime, @RequestParam String p){
        Map<String, Object> result = expenseService.getDepartmentPercent(startTime, endTime, p);
        return result;
    }
}