package com.lujieni.config;

import com.lujieni.bean.Person;
import com.lujieni.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * @Auther ljn
 * @Date 2020/2/15
 * scope标签的使用
 */
@Configuration
public class ScopeConfig {

    /**
     *
     * @return
     * prototype:多实例:ioc容器启动并不会去调用方法创建对象放在容器中,而是在每次获取的时候
     * singleton:单实例(默认值):ioc容器启动会调用方法创建对象放到ioc容器中
     */
    @Scope("prototype")
    @Bean
    public Person person(){
        return new Person().setAge(24).setName("张三");
    }
}
