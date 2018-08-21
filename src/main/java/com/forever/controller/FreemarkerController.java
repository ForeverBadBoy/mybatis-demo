package com.forever.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LENOVO
 * @date 2018/8/21
 */
@Controller
@RequestMapping("ftl")
public class FreemarkerController {

    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("name", "ftl模板");
        return "freemarker/index";
    }

    @RequestMapping("center")
    public String center() {
        return "freemarker/center";
    }
}
