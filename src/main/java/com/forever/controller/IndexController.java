package com.forever.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author LENOVO
 * @date 2018/08/14
 */
@Slf4j
@RestController
public class IndexController {

    @GetMapping("/")
    public JSONObject index(){
        JSONObject json = new JSONObject();
        json.put("name", "SpringBoot-mybatis-demo");
        json.put("desc", "SpringBoot mybatis demo");
        int a = 1 / 0;
        return json;
    }

    @GetMapping("/error")
    public ModelAndView error(){
        return new ModelAndView("/error");
    }
}
