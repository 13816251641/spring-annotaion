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
     * singleton:单实例(默认值):ioc容器启动会自动调用方法创建对象放到ioc容器中
     *
     * 懒加载@Lazy:
     *        单实例bean:默认在容器启动的时候创建对象;
     *        懒加载:容器启动不创建对象。第一次使用(获取)Bean创建对象,并初始化;
     *
     */
    @Scope("prototype")
    @Bean
    public Person person(){
        return new Person().setAge(24).setName("张三");
    }
}
