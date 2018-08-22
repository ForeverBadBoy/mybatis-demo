package com.forever;

import com.forever.model.User;
import com.forever.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author LENOVO
 * @date 2018/8/23
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisDemoApplication.class)
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        String key = "TEST_DATA";
        stringRedisTemplate.opsForValue().set(key, "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get(key));
    }

    @Test
    public void testObj() throws Exception {
        User user = new User();
        user.setUserName("kid");
        user.setPassword("123abc");
        user.setPhone("181****1234");

        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("TEST_USER", user);
        operations.set("TEST_TEMP_USER", user,10, TimeUnit.SECONDS);
        Thread.sleep(1000);
        //redisTemplate.delete("TEST_TEMP_USER");
        boolean exists = redisTemplate.hasKey("TEST_TEMP_USER");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }
    }

    @Autowired
    private UserService userService;

    /**
     * 测试是否取缓存而不是再次调用service方法
     */
    @Test
    public void getUser(){
        User user = userService.getById(12);
        log.info("====User:{}", user);
        User user1 = userService.getById(14);
        log.info("====User1:{}", user1);
    }
}
