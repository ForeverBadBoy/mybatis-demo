package com.forever.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LENOVO
 * @date 2018/8/21
 */
@Controller
@RequestMapping("th")
public class ThymeleafController {

    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("name", "thymeleaf-模板");
        return "thymeleaf/index";
    }

    @RequestMapping("center")
    public String center() {
        return "thymeleaf/center";
    }

}
