package com.xiateng.controller;

import com.xiateng.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class StarterController {

    @Autowired
    private TUserService tUserService;

    @RequestMapping(value = "/tUserList1")
    @ResponseBody
    public Map<String, Object> tUserList1(){
        Map<String, Object> map = new HashMap<>();
        int result = 0;
        try {
            result = tUserService.transactionalTest();
        } catch (Exception e) {
            e.printStackTrace();
            map.put("result","系统异常！");
            return map;
        }
        map.put("result",result);
        return map;
    }
}
