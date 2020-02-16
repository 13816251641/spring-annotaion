package com.lujieni.test;

import com.lujieni.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther ljn
 * @Date 2020/2/16
 * 基于xml方式装配
 */
public class IocTestInXml {

    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Person person = (Person)applicationContext.getBean("lujieni");
        System.out.println(person);
    }

}
