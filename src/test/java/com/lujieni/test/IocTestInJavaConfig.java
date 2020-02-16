package com.lujieni.test;

import com.lujieni.bean.Person;
import com.lujieni.config.MyConfig;
import com.lujieni.config.ScopeConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther ljn
 * @Date 2020/2/15
 * 基于@Configuration方式装配
 */
public class IocTestInJavaConfig {

   @Test
   public void test01(){
       AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
       String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
       for (String name:beanDefinitionNames){
           System.out.println(name);
       }
   }

    /**
     * scope标签的使用
     */
   @Test
    public void test02(){
       AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig.class);
       Person person1 = (Person)applicationContext.getBean("person");
       Person person2 = (Person)applicationContext.getBean("person");
       System.out.println(person1 == person2);
   }


}
