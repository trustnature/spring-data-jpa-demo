package com.tn.jpa.dao;

import com.tn.jpa.domain.AccountInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Long save(AccountInfo accountInfo) {
        em.persist(accountInfo);
        return accountInfo.getAccountId();
    }
}
