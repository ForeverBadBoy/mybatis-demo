package com.forever.exception;

import com.forever.core.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LENOVO
 * @date 2018/8/21
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandle {

    public static final String ERROR_VIEW = "thymeleaf/error";

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest reqest,
                               HttpServletResponse response, Exception e) throws Exception {
        e.printStackTrace();
        log.error("controller异常:", e);
        if (isAjax(reqest)) {
            return ResultGenerator.genExceptionResult(e.getMessage());
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", reqest.getRequestURL());
            mav.setViewName(ERROR_VIEW);
            return mav;
        }
    }

    public static boolean isAjax(HttpServletRequest httpRequest) {
        return (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals(httpRequest.getHeader("X-Requested-With").toString()));
    }
}
