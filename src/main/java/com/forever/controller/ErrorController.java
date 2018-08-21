package com.forever.controller;

import com.forever.core.Result;
import com.forever.core.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LENOVO
 * @date 2018/8/21
 */
@Controller
@RequestMapping("err")
public class ErrorController {

    /**
     * 发生异常时的error页面跳转(由@ExceptionHandle控制)
     * @return
     */
    @RequestMapping("/geterror")
    public String getError() {
        int a = 1 / 0;
        return "thymeleaf/error";
    }

    /**
     * 正常的error页面访问路径
     * @return
     */
    @RequestMapping("/errorpage")
    public String error() {
        return "thymeleaf/error";
    }

    /**
     * 发生ajax异常时的统一异常格式返回(由@ExceptionHandle控制)
     * @return
     */
    @RequestMapping("/getajaxerror")
    @ResponseBody
    public Result getAjaxerror() {

        int a = 1 / 0;

        return ResultGenerator.genSuccessResult();
    }
}
