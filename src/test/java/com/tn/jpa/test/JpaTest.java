package com.tn.jpa.test;

import com.tn.jpa.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JpaTest {
    @Test
    public void springTest(){
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring-demo-cfg.xml");
        UserService userService = (UserService)ctx.getBean("userService", UserService.class);
        userService.createNewAccount("ZhangJianPing", "123456", 1);
    }

}
