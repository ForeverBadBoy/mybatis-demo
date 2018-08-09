package com.forever.service;

import com.forever.model.User;

import java.util.List;

/**
 * @author LENOVO
 * @date 2018/08/09
 */
public interface UserService {

    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);
}
