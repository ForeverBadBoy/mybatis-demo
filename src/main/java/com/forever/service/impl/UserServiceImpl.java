package com.forever.service.impl;

import com.forever.mapper.UserMapper;
import com.forever.model.User;
import com.forever.service.UserService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LENOVO
 * @date 2018/08/09
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    /**
     * 这里会报错，但是并不会影响
     */
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    /**
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * @param pageNum  开始页数
     * @param pageSize 每页显示的数据条数
     * @return
     */
    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAllUser();
    }

    @Override
    @Cacheable(value="user-key")
    public User getById(Integer id) {
        //TODO 测试阶段先手动返回不查数据库
        log.info("===========getById:开始查询User:{}", id);
        User user = User.builder().userId(id).userName("kid").password("33445566").build();
        return user;
    }
}
