package com.tn.jpa.dao;

import com.tn.jpa.domain.AccountInfo;

public interface UserDao {
    public Long save(AccountInfo accountInfo);
}