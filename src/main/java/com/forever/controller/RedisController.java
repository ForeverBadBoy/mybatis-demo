package com.forever.controller;

import com.forever.core.Result;
import com.forever.core.ResultGenerator;
import com.forever.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LENOVO
 * @date 2018/8/22
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate strRedis;

    @Autowired
    private RedisOperator redis;

    @GetMapping("/list")
    public Result findAll(){
        String value = redis.get("key");
        String val = strRedis.opsForValue().get("key");
        Assert.isTrue(val.equals(value), "两者不相等");
        return ResultGenerator.genSuccessResult(value);
    }
}
