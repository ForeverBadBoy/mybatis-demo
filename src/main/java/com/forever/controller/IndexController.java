package com.forever.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return json;
    }

}
