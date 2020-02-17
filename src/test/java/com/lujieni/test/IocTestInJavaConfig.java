package com.lujieni.test;

import com.lujieni.bean.Person;
import com.lujieni.config.ConditionalConfig;
import com.lujieni.config.MyConfig;
import com.lujieni.config.ScopeConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

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

    /**
     * condition标签的使用
     */
    @Test
    public void test03(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConditionalConfig.class);

        //获取服务器的环境
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        System.out.println(environment.getProperty("os.name")); //Windows 10


        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        System.out.println(persons);
    }


}
