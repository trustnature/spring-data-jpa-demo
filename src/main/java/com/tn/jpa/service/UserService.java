package com.tn.jpa.service;

import com.tn.jpa.domain.AccountInfo;

public interface UserService {
    public Long createNewAccount(String username, String password, Integer initBalance) ;
}