package com.tn.jpa.service;

import com.tn.jpa.dao.UserDao;
import com.tn.jpa.domain.AccountInfo;
import com.tn.jpa.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public Long createNewAccount(String username, String password, Integer initBalance) {
        AccountInfo accountInfo = new AccountInfo();

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(password);

        accountInfo.setBalance(initBalance);
        accountInfo.setUserInfo(userInfo);

        return userDao.save(accountInfo);
    }


}
